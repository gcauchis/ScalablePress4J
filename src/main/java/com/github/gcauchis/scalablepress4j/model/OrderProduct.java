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
import com.github.gcauchis.scalablepress4j.api.ProductApi;

/**
 * The Order Product json object.
 *
 * @author gcauchis
 * @see <a href="https://scalablepress.com/docs/#order-product-object">https://scalablepress.com/docs/#order-product-object</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderProduct {
    /**
     * <code>productId</code> of the product you wish to order, retrieved from the {@link ProductApi Product API}, this product must be compatible with the
     * design provided.
     */
    private String id;

    /** Color of the product, see the {@link ProductApi Product API} for available colors. */
    private String color;

    /** Size of the product, see the {@link ProductApi Product API} for available sizes. */
    private String size;

    /** Quantity of this product/color/size to order. */
    private Integer quantity;

    /**
     * Gets the <code>productId</code> of the product you wish to order, retrieved from the {@link ProductApi Product API}, this product must be compatible with
     * the design provided.
     *
     * @return the <code>productId</code> of the product you wish to order
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the <code>productId</code> of the product you wish to order, retrieved from the {@link ProductApi Product API}, this product must be compatible with
     * the design provided.
     *
     * @param id the new <code>productId</code> of the product you wish to order
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the Color of the product, see the {@link ProductApi Product API} for available colors.
     *
     * @return the Color of the product
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the Color of the product, see the {@link ProductApi Product API} for available colors.
     *
     * @param color the new Color of the product
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Gets the Size of the product, see the {@link ProductApi Product API} for available sizes.
     *
     * @return the Size of the product
     */
    public String getSize() {
        return size;
    }

    /**
     * Sets the Size of the product, see the {@link ProductApi Product API} for available sizes.
     *
     * @param size the new Size of the product
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * Gets the Quantity of this product/color/size to order.
     *
     * @return the Quantity of this product/color/size to order
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Sets the Quantity of this product/color/size to order.
     *
     * @param quantity the new Quantity of this product/color/size to order
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "OrderProduct [id=" + id + ", color=" + color + ", size=" + size
                + ", quantity=" + quantity + "]";
    }
}
