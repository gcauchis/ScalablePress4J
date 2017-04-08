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
 * The Product Overview json object.
 * 
 * @author gcauchis
 * @see <a href="https://scalablepress.com/docs/#product-overview-object">https://scalablepress.com/docs/#product-overview-object</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductOveriew {

    /** Product name. */
    private String name;

    /** Reference code associated with the product. */
    private String style;

    /** {@link Image Image object}. */
    private Image image;

    /** Unique identifier for the product. */
    private String id;

    /** API endpoint for product details. */
    private String url;

    /**
     * Gets the Product name.
     *
     * @return the Product name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the Product name.
     *
     * @param name the new Product name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the Reference code associated with the product.
     *
     * @return the Reference code associated with the product
     */
    public String getStyle() {
        return style;
    }

    /**
     * Sets the Reference code associated with the product.
     *
     * @param style the new Reference code associated with the product
     */
    public void setStyle(String style) {
        this.style = style;
    }

    /**
     * Gets the {@link Image Image object}.
     *
     * @return the {@link Image Image object}
     */
    public Image getImage() {
        return image;
    }

    /**
     * Sets the {@link Image Image object}.
     *
     * @param image the new {@link Image Image object}
     */
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * Gets the Unique identifier for the product.
     *
     * @return the Unique identifier for the product
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the Unique identifier for the product.
     *
     * @param id the new Unique identifier for the product
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the API endpoint for product details.
     *
     * @return the API endpoint for product details
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the API endpoint for product details.
     *
     * @param url the new API endpoint for product details
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ProductOveriew [name=" + name + ", style=" + style + ", image="
                + image + ", id=" + id + ", url=" + url + "]";
    }

}
