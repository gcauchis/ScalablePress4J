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

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.gcauchis.scalablepress4j.ScalablePressBadRequestException;
import com.github.gcauchis.scalablepress4j.model.ErrorResponse;

/**
 * The Class AbstractRestApiTest.
 */
public class AbstractRestApiTest {

    /** The rest api. */
    private AbstractRestApi restApi;

    /** The base url. */
    private final String baseUrl = "http://testurl";

    /**
     * Inits the.
     */
    @BeforeEach
    public void init() {
        restApi = new AbstractRestApi() {
        };
        restApi.setBaseUrl(baseUrl);
    }

    /**
     * Initialization.
     */
    @Test
    public void initialization() {
        restApi.setBaseUrl(baseUrl);
        Assertions.assertEquals(baseUrl, restApi.getBaseUrl());
        restApi.setBasicAuth(null);
        Assertions.assertNull(restApi.getBasicAuth());
        final String basicAuth = "testBasicAuth";
        restApi.setBasicAuth(basicAuth);
        Assertions.assertEquals(basicAuth, restApi.getBasicAuth());
        Assertions.assertNotNull(restApi.getObjectMapper());
        Assertions.assertEquals(AbstractRestApi.DEFAULT_LIMIT, restApi.getLimit());
        final int limit = 10;
        restApi.setLimit(limit);
        Assertions.assertEquals(limit, restApi.getLimit());
    }

    /**
     * Pagination fail.
     */
    @Test
    public void paginationFail() {
        ScalablePressBadRequestException exception = Assertions.assertThrows(ScalablePressBadRequestException.class,
                () -> restApi.get("test", 0, ErrorResponse.class));
        Assertions.assertNotNull(exception.getErrorResponse());
        ErrorResponse errorResponse = exception.getErrorResponse();
        Assertions.assertEquals("400", errorResponse.getStatusCode());
        Assertions.assertEquals("Page number cannot be less than 1.", errorResponse.getMessage());
        exception = Assertions.assertThrows(ScalablePressBadRequestException.class,
                () -> restApi.get("test", 1, ErrorResponse.class));
        Assertions.assertNotNull(exception.getErrorResponse());
        errorResponse = exception.getErrorResponse();
        Assertions.assertEquals("520", errorResponse.getStatusCode());
        Assertions.assertTrue(exception.getCause() instanceof UnknownHostException);
        restApi.setBaseUrl(baseUrl + "?test=rf");
        exception = Assertions.assertThrows(ScalablePressBadRequestException.class,
                () -> restApi.get("test", 1, ErrorResponse.class));
        Assertions.assertNotNull(exception.getErrorResponse());
        errorResponse = exception.getErrorResponse();
        Assertions.assertEquals("520", errorResponse.getStatusCode());
        Assertions.assertTrue(exception.getCause() instanceof UnknownHostException);
    }

    /**
     * Prepare connection fail.
     */
    @Test
    public void prepareConnectionFail() {
        restApi.setBaseUrl("test");
        restApi.setBasicAuth("test");
        Map<String, String> urlVariables = new HashMap<>();
        urlVariables.put("test", "testvar");
        urlVariables.put("test2", null);
        ScalablePressBadRequestException exception = Assertions.assertThrows(ScalablePressBadRequestException.class,
                () -> restApi.get("test", ErrorResponse.class, urlVariables));
        Assertions.assertNotNull(exception.getErrorResponse());
        ErrorResponse errorResponse = exception.getErrorResponse();
        Assertions.assertEquals("520", errorResponse.getStatusCode());
    }
    

    /**
     * Builds the url.
     */
    @Test
    public void buildUrl() {
        Assertions.assertEquals("", restApi.buildUrl((String[]) null));
        Assertions.assertEquals("", restApi.buildUrl(new String[0]));
        Assertions.assertEquals("test", restApi.buildUrl("test"));
        Assertions.assertEquals("test/test2", restApi.buildUrl("test", "test2"));
    }
}
