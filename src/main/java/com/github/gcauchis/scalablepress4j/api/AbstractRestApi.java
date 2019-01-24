/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2016-2019 Gabriel Cauchis
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.github.gcauchis.scalablepress4j.api;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.client.utils.URIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.gcauchis.scalablepress4j.ScalablePressBadRequestException;
import com.github.gcauchis.scalablepress4j.model.Error;
import com.github.gcauchis.scalablepress4j.model.ErrorResponse;
import com.github.gcauchis.scalablepress4j.model.PaginatedResult;

/**
 * The Class AbstractRestApi.
 */
public abstract class AbstractRestApi {

    /** The default items per page number. */
    public static final int DEFAULT_LIMIT = 50;

    /** The Constant URL_SEPARATOR. */
    protected static final String URL_SEPARATOR = "/";

    /** The api logger. */
    protected final Logger log = LoggerFactory.getLogger(getClass());

    /** The base url. */
    private String baseUrl;

    /** The basic auth. */
    private String basicAuth;

    /** The auth to put in the header. */
    private String basicAuthHttp;

    /** The json object mapper. */
    private ObjectMapper objectMapper = new ObjectMapper();

    /** Items per page. Defaults to 50. */
    private int limit = DEFAULT_LIMIT;

    /**
     * Gets the base url.
     *
     * @return the base url
     */
    public String getBaseUrl() {
        return baseUrl;
    }

    /**
     * Sets the base url.
     *
     * @param baseUrl the new base url
     */
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    /**
     * Gets the basic auth.
     *
     * @return the basic auth
     */
    public String getBasicAuth() {
        return basicAuth;
    }

    /**
     * Sets the basic auth.
     *
     * @param basicAuth the new basic auth
     */
    public void setBasicAuth(String basicAuth) {
        this.basicAuth = basicAuth;
        if (basicAuth != null) {
            basicAuthHttp = "Basic " + new String(Base64.encodeBase64(basicAuth.getBytes(StandardCharsets.US_ASCII)));
        } else {
            basicAuthHttp = null;
        }
    }

    /**
     * Gets the object mapper.
     *
     * @return the object mapper
     */
    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    /**
     * Sets the object mapper.
     *
     * @param objectMapper the new object mapper
     */
    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     * Gets the limit.
     *
     * @return the limit
     */
    public int getLimit() {
        return limit;
    }

    /**
     * Sets the limit.
     *
     * @param limit the new limit
     */
    public void setLimit(int limit) {
        this.limit = limit;
    }

    /**
     * Prepare paginated url.
     *
     * @param requestUrl the request url
     * @param page the page
     * @return the string
     */
    private String preparePaginatedUrl(final String requestUrl, int page) {
        if (page < 1) {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setStatusCode("500");
            Error error = new Error();
            error.setCode("");
            error.setMessage("Page number cannot be less than 1.");
            errorResponse.setIssues(Arrays.asList(error));
            throw new ScalablePressBadRequestException(errorResponse);
        }
        String url = requestUrl;
        int argSeparatorIndex = url.indexOf('?');
        if (argSeparatorIndex < 0) {
            url += "?";
        } else if (argSeparatorIndex < url.length() - 1) {
            url += "&";
        }
        url += "page=" + page;
        if (limit != DEFAULT_LIMIT) {
            url += "&limit=" + limit;
        }
        return url;
    }

    /**
     * Builds the paginated result.
     *
     * @param <T> the generic type
     * @param resultEntity the result entity
     * @param page the page
     * @return the paginated result
     */
    private <T> PaginatedResult<T> buildPaginatedResult(Response<T> resultEntity, int page) {
        PaginatedResult<T> paginatedResult = new PaginatedResult<>();
        paginatedResult.setResult(resultEntity.body);
        paginatedResult.setPageNumber(page);
        paginatedResult.setLimit(limit);
        List<String> xspPages = resultEntity.headers.get("X-SP-Pages");
        if (xspPages != null && !xspPages.isEmpty())
            paginatedResult.setPagesCount(Integer.parseInt(xspPages.get(0)));
        List<String> xspCount = resultEntity.headers.get("X-SP-Count");
        if (xspCount != null && !xspCount.isEmpty())
            paginatedResult.setItemsCount(Integer.parseInt(xspCount.get(0)));
        return paginatedResult;
    }

    /**
     * Get for entity.
     *
     * @param <T> the generic type
     * @param url the url
     * @param responseType the response type
     * @return the for entity
     */
    private <T> Response<T> getForEntity(String url, Class<T> responseType) {
        return forEntity(url, "GET", null, responseType, null);
    }

    /**
     * Get for entity.
     *
     * @param <T> the generic type
     * @param url the url
     * @param responseType the response type
     * @param urlVariables the url variables
     * @return the for entity
     */
    private <T> Response<T> getForEntity(String url, Class<T> responseType, Map<String, ?> urlVariables) {
        return forEntity(url, "GET", null, responseType, urlVariables);
    }

    /**
     * Post for entity.
     *
     * @param <T> the generic type
     * @param url the url
     * @param request the request
     * @param responseType the response type
     * @return the response
     */
    protected <T> Response<T> postForEntity(String url, Object request, Class<T> responseType) {
        return forEntity(url, "POST", request, responseType, null);
    }

    /**
     * Post for entity.
     *
     * @param <T> the generic type
     * @param url the url
     * @param request the request
     * @param responseType the response type
     * @param urlVariables the url variables
     * @return the response
     */
    protected <T> Response<T> postForEntity(String url, Object request, Class<T> responseType, Map<String, ?> urlVariables) {
        return forEntity(url, "POST", request, responseType, urlVariables);
    }

    /**
     * Call request for entity.
     *
     * @param <T> the generic type
     * @param url the url
     * @param requestMethod the http request method
     * @param request the request
     * @param responseType the response type
     * @param urlVariables the url variables
     * @return the response
     */
    private <T> Response<T> forEntity(String url, String requestMethod, Object request, Class<T> responseType, Map<String, ?> urlVariables) {
        StringBuilder response = new StringBuilder();
        HttpURLConnection connection = prepareConnection(url, requestMethod, urlVariables);
        try {

            // // Send request
            DataOutputStream wr = null;
            if (request != null) {
                String content = objectMapper.writeValueAsString(request);
                wr = new DataOutputStream(connection.getOutputStream());
                wr.write(content.getBytes(StandardCharsets.UTF_8));
                wr.flush();
            }

            // Get Response
            BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\n');
            }

            if (wr != null) {
                wr.close();
            }
            rd.close();
            log.trace("Response {}", response);
        } catch (IOException e) {
            log.error("Fail to send request", e);
            ErrorResponse errorResponse = new ErrorResponse();
            try {
                errorResponse.setStatusCode(connection.getResponseCode() + "");
                errorResponse.setMessage(connection.getResponseMessage());
            } catch (IOException e1) {
                errorResponse.setStatusCode("500");
                errorResponse.setMessage(e.getMessage());
            }
            throw new ScalablePressBadRequestException(errorResponse);
        }

        Response<T> responseEntity = new Response<>();
        responseEntity.headers = connection.getHeaderFields();
        log.debug("Header: {}", responseEntity.headers);
        try {
            responseEntity.body = objectMapper.readValue(response.toString(), responseType);
        } catch (IOException e) {
            log.error("Fail to parse response", e);
            ErrorResponse errorResponse = null;
            try {
                log.error("Response error: {} {}", connection.getResponseCode(), connection.getResponseMessage());
                errorResponse = objectMapper.readValue(response.toString(), ErrorResponse.class);
            } catch (IOException ioe) {
                log.error("Fail to parse error", ioe);
            }
            if (errorResponse != null) {
                log.error("Response error object: {}", errorResponse);
                throw new ScalablePressBadRequestException(errorResponse);
            }
        }
        return responseEntity;
    }

    /**
     * Prepare connection.
     *
     * @param url the url
     * @param requestMethod the request method
     * @param urlVariables the url variables
     * @return the http URL connection
     */
    private HttpURLConnection prepareConnection(String url, String requestMethod, Map<String, ?> urlVariables) {
        URL httpUrl;
        HttpURLConnection connection;
        try {
            URIBuilder uriBuilder = new URIBuilder(url);
            if (urlVariables != null) {
                for (Map.Entry<String, ?> entry : urlVariables.entrySet()) {
                    uriBuilder.addParameter(entry.getKey(), entry.getValue() == null ? "" : entry.getValue().toString());
                }
            }
            httpUrl = uriBuilder.build().toURL();
            connection = (HttpURLConnection) httpUrl.openConnection();
            connection.setRequestMethod(requestMethod);
            connection.setRequestProperty("Accept", "application/json, application/*+json");
            connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            if (basicAuthHttp != null) {
                connection.setRequestProperty("Authorization", basicAuthHttp);
            }
            connection.setDoOutput(true);
        } catch (IOException | URISyntaxException e) {
            log.error("Fail to buil connection", e);
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setStatusCode("500");
            errorResponse.setMessage(e.getMessage());
            throw new ScalablePressBadRequestException(errorResponse);
        }
        return connection;
    }

    /**
     * Gets the GET response.
     *
     * @param <T> the generic type
     * @param url the url
     * @param responseType the response type
     * @return the t
     */
    protected <T> T get(String url, Class<T> responseType) {
        log.trace("Call GET for: {}, to url: {}", responseType, url);
        return getForEntity(baseUrl + url, responseType).body;
    }

    /**
     * Gets the paginated GET response.
     *
     * @param <T> the generic type
     * @param url the url
     * @param page the page
     * @param responseType the response type
     * @return the paginated result
     */
    protected <T> PaginatedResult<T> get(String url, int page, Class<T> responseType) {
        log.trace("Call GET page {} for: {}, to url: {}", page, responseType, url);
        return buildPaginatedResult(getForEntity(preparePaginatedUrl(baseUrl + url, page), responseType), page);
    }

    /**
     * Gets the GET response.
     *
     * @param <T> the generic type
     * @param url the url
     * @param responseType the response type
     * @param urlVariables the url variables
     * @return the t
     */
    protected <T> T get(String url, Class<T> responseType, Map<String, ?> urlVariables) {
        log.trace("Call GET for: {}, to url: {}, with var: {}", responseType, url, urlVariables);
        return getForEntity(baseUrl + url, responseType, urlVariables).body;
    }

    /**
     * Gets the paginated GET response.
     *
     * @param <T> the generic type
     * @param url the url
     * @param page the page
     * @param responseType the response type
     * @param urlVariables the url variables
     * @return the paginated result
     * @throws ScalablePressBadRequestException for invalid request or error occur during call.
     */
    protected <T> PaginatedResult<T> get(String url, int page, Class<T> responseType, Map<String, ?> urlVariables) {
        log.trace("Call GET page {} for: {}, to url: {}, with var: {}", page, responseType, url, urlVariables);
        return buildPaginatedResult(getForEntity(preparePaginatedUrl(baseUrl + url, page), responseType, urlVariables), page);
    }

    /**
     * Gets the POST response.
     *
     * @param <T> the generic type
     * @param url the url
     * @param request the request
     * @param responseType the response type
     * @return the t
     * @throws ScalablePressBadRequestException for invalid request or error occur during call.
     */
    protected <T> T post(String url, Object request, Class<T> responseType) {
        log.trace("Call POST for: {}, to url: {}, with req {}", responseType, url, request);
        return postForEntity(baseUrl + url, request, responseType).body;
    }

    /**
     * Gets the paginated POST response.
     *
     * @param <T> the generic type
     * @param url the url
     * @param page the page
     * @param request the request
     * @param responseType the response type
     * @return the paginated result
     * @throws ScalablePressBadRequestException for invalid request or error occur during call.
     */
    protected <T> PaginatedResult<T> post(String url, int page, Object request, Class<T> responseType) {
        log.trace("Call POST page {} for: {}, to url: {}, with req {}", page, responseType, url, request);
        return buildPaginatedResult(postForEntity(preparePaginatedUrl(baseUrl + url, page), request, responseType), page);
    }

    /**
     * Gets the DELETE response.
     *
     * @param <T> the generic type
     * @param url the url
     * @param responseType the response type
     * @return the t
     * @throws ScalablePressBadRequestException for invalid request or error occur during call.
     */
    protected <T> T delete(String url, Class<T> responseType) {
        log.trace("Call DELETE for: {}, to url: {}", responseType, url);
        return forEntity(baseUrl + url, "DELETE", null, responseType, null).body;
    }

    /**
     * Builds the url of the given path.
     *
     * @param path the path
     * @return the url path[0](/path[1](/path[2](/path[3](...))))
     */
    protected String buildUrl(String... path) {
        if (path == null || path.length == 0) {
            return "";
        } else if (path.length == 1) {
            return path[0];
        } else {
            StringBuilder url = new StringBuilder(path[0]);
            for (int i = 1; i < path.length; i++) {
                url.append(URL_SEPARATOR).append(path[i]);
            }
            return url.toString();
        }
    }

    /**
     * The Class Response.
     *
     * @param <T> the generic type
     */
    private static class Response<T> {

        /** The headers. */
        private Map<String, List<String>> headers;

        /** The body. */
        private T body;

    }

}
