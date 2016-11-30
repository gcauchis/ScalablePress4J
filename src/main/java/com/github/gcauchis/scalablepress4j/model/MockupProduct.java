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

/**
 * The MockupProduct json object.
 *
 * @author gcauchis
 * @see <a href="https://scalablepress.com/docs/#mockup-product-object">https://scalablepress.com/docs/#mockup-product-object</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MockupProduct {

    /**
     * productId of the mockup product. <a href="https://scalablepress.com/docs/#available-products">See available products</a>
     * 
     * @see <a href="https://scalablepress.com/docs/#available-products">See available products</a
     */
    private String id;

    /**
     * Color of the product, see the {@link com.github.gcauchis.scalablepress4j.api.ProductApi Product API} for available colors, some colors may be unavailable
     * in this API
     * 
     * @see com.github.gcauchis.scalablepress4j.api.ProductApi ProductApi
     */
    private String color;

    /**
     * Gets the productId of the mockup product.
     *
     * @return the productId of the mockup product
     * @see <a href="https://scalablepress.com/docs/#available-products">See available products</a
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the productId of the mockup product.
     *
     * @param id the new productId of the mockup product
     * @see <a href="https://scalablepress.com/docs/#available-products">See available products</a
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the Color of the product.
     *
     * @return the Color of the product
     * @see com.github.gcauchis.scalablepress4j.api.ProductApi ProductApi
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the Color of the product.
     *
     * @param color the new Color of the product
     * @see com.github.gcauchis.scalablepress4j.api.ProductApi ProductApi
     */
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "MockupProduct [id=" + id + ", color=" + color + "]";
    }

}
