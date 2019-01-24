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
package com.github.gcauchis.scalablepress4j.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The Feature json object.
 *
 * @author gcauchis
 * @see <a href="https://scalablepress.com/docs/#custom-order-features">https://scalablepress.com/docs/#custom-order-features</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Features {

    /**
     * Shipping service code. <a href="https://scalablepress.com/docs/#shipping-service-codes">Available service codes</a>
     * @see https://scalablepress.com/docs/#shipping-service-codes
     */
    private String shipping;
    
    /** Absolute URL for a PDF packing slip. */
    private String packing;

    /**
     * Gets the Shipping service code. <a href="https://scalablepress.com/docs/#shipping-service-codes">Available service codes</a>.
     *
     * @return the Shipping service code
     * @see https://scalablepress.com/docs/#shipping-service-codes
     */
    public String getShipping() {
        return shipping;
    }

    /**
     * Sets the Shipping service code. <a href="https://scalablepress.com/docs/#shipping-service-codes">Available service codes</a>.
     *
     * @param shipping the new Shipping service code
     * @see https://scalablepress.com/docs/#shipping-service-codes
     */
    public void setShipping(String shipping) {
        this.shipping = shipping;
    }

    /**
     * Gets the Absolute URL for a PDF packing slip.
     *
     * @return the Absolute URL for a PDF packing slip
     */
    public String getPacking() {
        return packing;
    }

    /**
     * Sets the Absolute URL for a PDF packing slip.
     *
     * @param packing the new Absolute URL for a PDF packing slip
     */
    public void setPacking(String packing) {
        this.packing = packing;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Features [shipping=" + shipping + ", packing=" + packing + "]";
    }
}
