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

import java.util.Map;

/**
 * The Error json object.
 * 
 * @author gcauchis
 * @see https://scalablepress.com/docs/#error-object
 */
public class Error {
    
    /** Identifier for type of error message. */
    private String code;
    
    /** Path causing error. */
    private String path;
    
    /** User-friendly error message. */
    private String message;
    
    /** Optional specification. */
    private Map<String, Object> spec;

    /**
     * Gets the Identifier for type of error message.
     *
     * @return the Identifier for type of error message.
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the Identifier for type of error message.
     *
     * @param code the new Identifier for type of error message.
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets the Path causing error.
     *
     * @return the Path causing error
     */
    public String getPath() {
        return path;
    }

    /**
     * Sets the Path causing error.
     *
     * @param path the new Path causing error
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Gets the User-friendly error message.
     *
     * @return the User-friendly error message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the User-friendly error message.
     *
     * @param message the new User-friendly error message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the Optional specification.
     *
     * @return the Optional specification
     */
    public Map<String, Object> getSpec() {
        return spec;
    }

    /**
     * Sets the Optional specification.
     *
     * @param spec the Optional specification
     */
    public void setSpec(Map<String, Object> spec) {
        this.spec = spec;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Error [code=" + code + ", path=" + path + ", message="
                + message + ", spec=" + spec + "]";
    }

}
