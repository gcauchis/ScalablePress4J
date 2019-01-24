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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The Category json object.
 * @author gcauchis
 * @see <a href="https://scalablepress.com/docs/#list-product-categories">https://scalablepress.com/docs/#list-product-categories</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Category {

    /** Printing categorization. <code>Garment</code>, <code>Case</code>, <code>Mug</code>, or <code>Poster</code>. */
    private String type;
    /** Name of the category */
    private String name;
    /** Additional categorization, for example <code>Unisex</code> */
    private String family;
    /** {@link Image Image object} */
    private Image image;
    /** API endpoint for category details */
    private String url;
    /** Unique identifier for the category */
    private String categoryId;
    /** The category products */
    private List<ProductOveriew> products;

    /**
     * Gets the Printing categorization. <code>Garment</code>, <code>Case</code>, <code>Mug</code>, or <code>Poster</code>.
     *
     * @return the Printing categorization. <code>Garment</code>, <code>Case</code>, <code>Mug</code>, or <code>Poster</code>
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the Printing categorization. <code>Garment</code>, <code>Case</code>, <code>Mug</code>, or <code>Poster</code>.
     *
     * @param type the new Printing categorization. <code>Garment</code>, <code>Case</code>, <code>Mug</code>, or <code>Poster</code>
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the Name of the category.
     *
     * @return the Name of the category
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the Name of the category.
     *
     * @param name the new Name of the category
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the Additional categorization, for example <code>Unisex</code>.
     *
     * @return the Additional categorization, for example <code>Unisex</code>
     */
    public String getFamily() {
        return family;
    }

    /**
     * Sets the Additional categorization, for example <code>Unisex</code>.
     *
     * @param family the new Additional categorization, for example <code>Unisex</code>
     */
    public void setFamily(String family) {
        this.family = family;
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
     * Gets the API endpoint for category details.
     *
     * @return the API endpoint for category details
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the API endpoint for category details.
     *
     * @param url the new API endpoint for category details
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Gets the Unique identifier for the category.
     *
     * @return the Unique identifier for the category
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * Sets the Unique identifier for the category.
     *
     * @param categoryId the new Unique identifier for the category
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * Gets the The category products.
     *
     * @return the The category products
     */
    public List<ProductOveriew> getProducts() {
        return products;
    }

    /**
     * Sets the The category products.
     *
     * @param products the new The category products
     */
    public void setProducts(List<ProductOveriew> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Category [type=" + type + ", name=" + name + ", family="
                + family + ", image=" + image + ", url=" + url
                + ", categoryId=" + categoryId + ", products=" + products + "]";
    }
}
