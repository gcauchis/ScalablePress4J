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
 * The Product Propeties json object.
 * 
 * @author gcauchis
 * @see <a href="https://scalablepress.com/docs/#product-properties-object">https://scalablepress.com/docs/#product-properties-object</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductProperties {

    /** Brand of the product. */
    private String brand;

    /** Material the product is made from. */
    private String material;

    /** Style code associated with the product. */
    private String style;

    /**
     * Gets the Brand of the product.
     *
     * @return the Brand of the product
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Sets the Brand of the product.
     *
     * @param brand the new Brand of the product
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Gets the Material the product is made from.
     *
     * @return the Material the product is made from
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Sets the Material the product is made from.
     *
     * @param material the new Material the product is made from
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * Gets the Style code associated with the product.
     *
     * @return the Style code associated with the product
     */
    public String getStyle() {
        return style;
    }

    /**
     * Sets the Style code associated with the product.
     *
     * @param style the new Style code associated with the product
     */
    public void setStyle(String style) {
        this.style = style;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ProductProperties [brand=" + brand + ", material=" + material
                + ", style=" + style + "]";
    }
}
