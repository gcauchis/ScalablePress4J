/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Gabriel Cauchis
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
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.Header;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

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

    /** The api logger. */
    protected final Logger log = LoggerFactory.getLogger(getClass());

    /**  The base url. */
    private String baseUrl;

    /**  The basic auth. */
    private String basicAuth;

    /**  The rest template. */
    private RestTemplate restTemplate;

    /**  The json object mapper. */
    private ObjectMapper objectMapper = new ObjectMapper();

    /** Items per page. Defaults to 50. */
    private int limit = DEFAULT_LIMIT;

    /**
     * Gets the rest template.
     *
     * @return the rest template
     */
    private RestTemplate getRestTemplate() {
        if (restTemplate == null) {
            restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory(HttpClientBuilder.create()
                                    .setDefaultHeaders(Arrays.asList(getBasicAuthenticateHeader()))
                                    .build()));
            restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {

                @Override
                public void handleError(ClientHttpResponse response) throws IOException {
                    log.error("Response error: {} {}", response.getStatusCode(), response.getStatusText());
                    ErrorResponse errorResponse = null;
                    try {
                        errorResponse = objectMapper.readValue(response.getBody(), ErrorResponse.class);
                    } catch (IOException ioe) {
                        log.error("Fail to parse error", ioe);
                    }
                    if (errorResponse != null) {
                        log.error("Response error object: {}", errorResponse);
                        throw new ScalablePressBadRequestException(errorResponse);
                    }

                    super.handleError(response);
                }
            });
        }
        return restTemplate;
    }

    /**
     * Gets the basic authenticate header.
     *
     * @return the basic authenticate header
     */
    private Header getBasicAuthenticateHeader() {
        if (basicAuth != null) {
            byte[] encodedAuth = Base64.encodeBase64(basicAuth.getBytes(Charset.forName("US-ASCII")));
            return new BasicHeader("Authorization", "Basic " + new String(encodedAuth));
        }
        return null;
    }

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
        restTemplate = null;
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
    private <T> PaginatedResult<T> buildPaginatedResult(ResponseEntity<T> resultEntity, int page) {
        PaginatedResult<T> paginatedResult = new PaginatedResult<>();
        paginatedResult.setResult(resultEntity.getBody());
        paginatedResult.setPageNumber(page);
        paginatedResult.setLimit(limit);
        HttpHeaders headers = resultEntity.getHeaders();
        List<String> xspPages = headers.get("X-SP-Pages");
        if (xspPages != null && !xspPages.isEmpty())
            paginatedResult.setPagesCount(Integer.parseInt(xspPages.get(0)));
        List<String> xspCount = headers.get("X-SP-Count");
        if (xspCount != null && !xspCount.isEmpty())
            paginatedResult.setItemsCount(Integer.parseInt(xspCount.get(0)));
        return paginatedResult;
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
        log.trace("Call GET for: {}, to url: {}", responseType.toString(), url);
        return getRestTemplate().getForEntity(baseUrl + url, responseType).getBody();
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
        log.trace("Call GET page {} for: {}, to url: {}", page, responseType.toString(), url);
        return buildPaginatedResult(getRestTemplate().getForEntity(preparePaginatedUrl(baseUrl + url, page), responseType), page);
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
        log.trace("Call GET for: {}, to url: {}, with var: {}", responseType.toString(), url, urlVariables);
        return getRestTemplate().getForEntity(baseUrl + url, responseType, urlVariables).getBody();
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
     */
    protected <T> PaginatedResult<T> get(String url, int page, Class<T> responseType, Map<String, ?> urlVariables) {
        log.trace("Call GET page {} for: {}, to url: {}, with var: {}", page, responseType.toString(), url, urlVariables);
        return buildPaginatedResult(getRestTemplate().getForEntity(preparePaginatedUrl(baseUrl + url, page), responseType, urlVariables), page);
    }

    /**
     * Gets the POST response.
     *
     * @param <T> the generic type
     * @param url the url
     * @param request the request
     * @param responseType the response type
     * @return the t
     */
    protected <T> T post(String url, Object request, Class<T> responseType) {
        log.trace("Call POST for: {}, to url: {}, with req {}", responseType.toString(), url, request);
        return getRestTemplate().postForEntity(baseUrl + url, request, responseType).getBody();
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
     */
    protected <T> PaginatedResult<T> post(String url, int page, Object request, Class<T> responseType) {
        log.trace("Call POST page {} for: {}, to url: {}, with req {}", page, responseType.toString(), url, request);
        return buildPaginatedResult(getRestTemplate().postForEntity(preparePaginatedUrl(baseUrl + url, page), request, responseType), page);
    }

    /**
     * Gets the DELETE response.
     *
     * @param <T> the generic type
     * @param url the url
     * @param responseType the response type
     * @return the t
     */
    protected <T> T delete(String url, Class<T> responseType) {
        log.trace("Call DELETE for: {}, to url: {}", responseType.toString(), url);
        return getRestTemplate().exchange(baseUrl + url, HttpMethod.DELETE, null, responseType).getBody();
    }

}
