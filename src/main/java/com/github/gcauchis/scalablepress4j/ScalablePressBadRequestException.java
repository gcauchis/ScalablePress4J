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
package com.github.gcauchis.scalablepress4j;

import com.github.gcauchis.scalablepress4j.model.ErrorResponse;

/**
 * The Class ScalablePressBadRequestException.
 */
public class ScalablePressBadRequestException extends RuntimeException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5250945263556128109L;
    
    /**  the error response. */
    private final ErrorResponse errorResponse;

    /**
     * Instantiates a new scalable press bad request exception.
     *
     * @param errorResponse the error response
     */
    public ScalablePressBadRequestException(ErrorResponse errorResponse) {
        super(errorResponse.getStatusCode());
        this.errorResponse = errorResponse;
    }

    /**
     * Gets the error response.
     *
     * @return the error response
     */
    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    /* (non-Javadoc)
     * @see java.lang.Throwable#toString()
     */
    @Override
    public String toString() {
        return "ScalablePressBadRequestException [errorResponse="
                + errorResponse + "]";
    }

}
