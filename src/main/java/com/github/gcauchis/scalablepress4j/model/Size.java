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
 * The Size json object.
 *
 * @author gcauchis
 * @see <a href="https://scalablepress.com/docs/#size-object">https://scalablepress.com/docs/#size-object</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Size {

    /** The quantity available. */
    private Number quantity;

    /** The price of the product. */
    private Number price;

    /** The weight in pounds of the product. */
    private Number weight;

    /** The size of the product. */
    private Number size;

    /** The color of the product. */
    private String color;

    /** The Global Trade Item Number. */
    private String GTIN;

    /**
     * Gets the quantity available.
     *
     * @return the quantity available
     */
    public Number getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity available.
     *
     * @param quantity the new quantity available
     */
    public void setQuantity(Number quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the price of the product.
     *
     * @return the price of the product
     */
    public Number getPrice() {
        return price;
    }

    /**
     * Sets the price of the product.
     *
     * @param price the new price of the product
     */
    public void setPrice(Number price) {
        this.price = price;
    }

    /**
     * Gets the weight in pounds of the product.
     *
     * @return the weight in pounds of the product
     */
    public Number getWeight() {
        return weight;
    }

    /**
     * Sets the weight in pounds of the product.
     *
     * @param weight the new weight in pounds of the product
     */
    public void setWeight(Number weight) {
        this.weight = weight;
    }

    /**
     * Gets the size of the product.
     *
     * @return the size of the product
     */
    public Number getSize() {
        return size;
    }

    /**
     * Sets the size of the product.
     *
     * @param size the new size of the product
     */
    public void setSize(Number size) {
        this.size = size;
    }

    /**
     * Gets the color of the product.
     *
     * @return the color of the product
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the color of the product.
     *
     * @param color the new color of the product
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Gets the Global Trade Item Number.
     *
     * @return the Global Trade Item Number
     */
    public String getGTIN() {
        return GTIN;
    }

    /**
     * Sets the Global Trade Item Number.
     *
     * @param gTIN the new Global Trade Item Number
     */
    public void setGTIN(String gTIN) {
        GTIN = gTIN;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Size [quantity=" + quantity + ", price=" + price + ", weight="
                + weight + ", size=" + size + ", color=" + color + ", GTIN="
                + GTIN + "]";
    }
}
