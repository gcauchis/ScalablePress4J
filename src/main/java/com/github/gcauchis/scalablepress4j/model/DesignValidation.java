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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The Design Validation json object
 * 
 * @author gcauchis
 * @see <a href="https://scalablepress.com/docs/#design-validation-object">https://scalablepress.com/docs/#design-validation-object</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DesignValidation {
    /** Result of validation - will return null for now */
    private String result;
    /** Status of the validation object */
    private String status;

    /**
     * Gets the Result of validation - will return null for now.
     *
     * @return the Result of validation - will return null for now
     */
    public String getResult() {
        return result;
    }

    /**
     * Sets the Result of validation - will return null for now.
     *
     * @param result the new Result of validation - will return null for now
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * Gets the Status of the validation object.
     *
     * @return the Status of the validation object
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the Status of the validation object.
     *
     * @param status the new Status of the validation object
     */
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DesignValidation [result=" + result + ", status=" + status
                + "]";
    }
}
