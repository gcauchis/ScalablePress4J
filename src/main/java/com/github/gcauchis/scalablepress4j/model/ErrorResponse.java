/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016-2023 Gabriel Cauchis
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

    /** The {@link Error error objects information} which are preventing a successful call. */
    private Error error;

    /** Path causing error. */
    private String path;

    /** The error message. */
    private String message;

    /**
     * Instantiates a new error response.
     */
    public ErrorResponse() {
        super();
    }

    /**
     * Instantiates a new error response with status code 520 (Unknown Error: The 520 error is used as a "catch-all response for when the origin server returns
     * something unexpected", listing connection resets, large headers, and empty or invalid responses as common triggers.).
     *
     * @param throwable the throwable
     */
    public ErrorResponse(Throwable throwable) {
        this("520", throwable);
    }

    /**
     * Instantiates a new error response.
     *
     * @param statusCode the status code
     * @param throwable the throwable
     */
    public ErrorResponse(String statusCode, Throwable throwable) {
        this(statusCode, throwable.getMessage());
    }

    /**
     * Instantiates a new error response.
     *
     * @param statusCode the status code
     * @param message the message
     */
    public ErrorResponse(String statusCode, String message) {
        super();
        this.statusCode = statusCode;
        this.message = message;
    }

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

    /**
     * Gets the error.
     *
     * @return the error
     */
    public Error getError() {
        return error;
    }

    /**
     * Sets the error.
     *
     * @param error the new error
     */
    public void setError(Error error) {
        this.error = error;
    }

    /**
     * Gets the path.
     *
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * Sets the path.
     *
     * @param path the new path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Gets the message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message.
     *
     * @param message the new message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ErrorResponse [statusCode=" + statusCode + ", error=" + error + " issues=" + issues + ", path=" + path + ", message=" + message + "]";
    }

}
