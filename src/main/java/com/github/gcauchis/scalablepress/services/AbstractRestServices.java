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
package com.github.gcauchis.scalablepress.services;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.Header;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.gcauchis.scalablepress.ScalablePressBadRequestException;
import com.github.gcauchis.scalablepress.model.ErrorResponse;

public abstract class AbstractRestServices {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    /** The base url */
    @Value("${scalablepress.api.baseurl:https://api.scalablepress.com/v2/}")
    private String baseUrl;
    /** The basic auth */
    @Value("${scalablepress.api.basicauth}")
    private String basicAuth;
    /** The rest template */
    private RestTemplate restTemplate;
    /** The json object mapper */
    private ObjectMapper objectMapper = new ObjectMapper();

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

    private Header getBasicAuthenticateHeader() {
        if (basicAuth != null) {
            byte[] encodedAuth = Base64.encodeBase64(basicAuth.getBytes(Charset.forName("US-ASCII")));
            return new BasicHeader("Authorization", "Basic " + new String(encodedAuth));
        }
        return null;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getBasicAuth() {
        return basicAuth;
    }

    public void setBasicAuth(String basicAuth) {
        this.basicAuth = basicAuth;
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    protected <T> T get(String url, Class<T> responseType) throws RestClientException {
        log.trace("Call GET {} url {}", responseType.toString(), url);
        return getRestTemplate().getForEntity(baseUrl + url, responseType).getBody();
    }

    protected <T> T get(String url, Class<T> responseType, Map<String, ?> urlVariables) throws RestClientException {
        log.trace("Call GET {} url {} var {}", responseType.toString(), url, urlVariables);
        return getRestTemplate().getForEntity(baseUrl + url, responseType, urlVariables).getBody();
    }

    protected <T> T post(String url, Object request, Class<T> responseType) throws RestClientException {
        log.trace("Call POST {} url {} req {}", responseType.toString(), url, request);
        return getRestTemplate().postForEntity(baseUrl + url, request, responseType).getBody();
    }

    protected <T> T delete(String url, Class<T> responseType) throws RestClientException {
        log.trace("Call GET {} url {}", responseType.toString(), url);
        return getRestTemplate().exchange(baseUrl + url, HttpMethod.DELETE, null, responseType).getBody();
    }

}
