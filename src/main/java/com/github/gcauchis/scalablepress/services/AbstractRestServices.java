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

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public abstract class AbstractRestServices {

    protected final Logger log = LoggerFactory.getLogger(getClass());
    
    /** The base url */
    @Value("${scalablepress.api.baseurl}")
    private String baseUrl;
    /** The basic auth */
    @Value("${scalablepress.api.basicauth}")
    private String basicAuth;
    /** The rest template */
    private RestTemplate restTemplate = new RestTemplate();
    
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

    private HttpEntity<?> getRequestEntry() {
        HttpHeaders httpHeaders = new HttpHeaders();
        if (basicAuth != null)
        {
            byte[] encodedAuth = Base64.encodeBase64(basicAuth.getBytes(Charset .forName("US-ASCII")));
            httpHeaders.set("Authorization", "Basic " + new String(encodedAuth));
        }
        return new HttpEntity<>(httpHeaders);
    }

    protected <T> T get(String url, Class<T> responseType) throws RestClientException {
        log.trace("Call GET {} url {}", responseType.toString(), url);
        return ((ResponseEntity<T>) restTemplate.exchange(baseUrl + url, HttpMethod.GET, getRequestEntry(), responseType)).getBody();
    }
    
    protected <T> T get(String url, Class<T> responseType, Map<String, ?> urlVariables) throws RestClientException {
        log.trace("Call GET {} url {} var {}", responseType.toString(), url, urlVariables);
        return ((ResponseEntity<T>) restTemplate.exchange(baseUrl + url, HttpMethod.GET, getRequestEntry(), responseType, urlVariables)).getBody();
    }
    
    protected <T> T post(String url, Class<T> responseType, Map<String, ?> urlVariables) throws RestClientException {
        log.trace("Call POST {} url {} var {}", responseType.toString(), url, urlVariables);
        return ((ResponseEntity<T>) restTemplate.exchange(baseUrl + url, HttpMethod.POST, getRequestEntry(), responseType, urlVariables)).getBody();
    }
    
    protected <T> T post(String url, Class<T> responseType, Object... uriVariables) throws RestClientException {
        log.trace("Call POST {} url {} var {}", responseType.toString(), url, Arrays.toString(uriVariables));
        return ((ResponseEntity<T>) restTemplate.exchange(baseUrl + url, HttpMethod.POST, getRequestEntry(), responseType, uriVariables)).getBody();
    }
    
}
