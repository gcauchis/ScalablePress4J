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
package com.github.gcauchis.scalablepress4j.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The Error Response Object.
 *
 * @author gcauchis
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse implements Serializable {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5881440703029137699L;

    /** The Status Code. */
    private String statusCode;
    
    /** Array of {@link Error error objects} which are preventing a successful call. */
    private List<Error> issues;

    /**
     * Gets The Status Code.
     *
     * @return The Status Code
     */
    public String getStatusCode() {
        return statusCode;
    }

    /**
     * Sets The Status Code.
     *
     * @param statusCode the new Status Code
     */
    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * Gets the Array of {@link Error error objects} which are preventing a successful call.
     *
     * @return the Array of {@link Error error objects} which are preventing a successful call
     */
    public List<Error> getIssues() {
        return issues;
    }

    /**
     * Sets the Array of {@link Error error objects} which are preventing a successful call.
     *
     * @param issues the new Array of {@link Error error objects} which are preventing a successful call
     */
    public void setIssues(List<Error> issues) {
        this.issues = issues;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ErrorResponse [statusCode=" + statusCode + ", issues=" + issues
                + "]";
    }
}
