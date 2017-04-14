/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2016-2017 Gabriel Cauchis
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
 * The Product json object.
 * 
 * @author gcauchis
 * @see <a href="https://scalablepress.com/docs/#product-object">https://scalablepress.com/docs/#product-object</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {

    /** Comments on the product (its fit and/or feel). */
    private String comments;

    /** Description of the product. */
    private String description;

    /** Actual name of the product. */
    private String name;

    /** Printing categorization. <code>Garment</code>, <code>Case</code>, <code>Mug</code>, or <code>Poster</code> */
    private String type;

    /** {@link ProductProperties Product properties object}. */
    private ProductProperties properties;

    /** Array of available {@link Color color objects}. */
    private List<Color> colors;

    /** Whether the product is available to order. */
    private String available;
    
    /** The {@link ProductTemplates templates} names. */
    private ProductTemplates templates;

    /** API endpoint for product information (the current url). */
    private String url;

    /** {@link Image Primary image object}. */
    private Image image;

    /** Unique identifier for the product. */
    private String productId;

    /** Array of {@link Image image objects}. */
    private List<Image> additionalImages;

    /** API endpoint for product availability information. */
    private String availabilityUrl;

    /**
     * Gets the Comments on the product (its fit and/or feel).
     *
     * @return the Comments on the product (its fit and/or feel)
     */
    public String getComments() {
        return comments;
    }

    /**
     * Sets the Comments on the product (its fit and/or feel).
     *
     * @param comments the new Comments on the product (its fit and/or feel)
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * Gets the Description of the product.
     *
     * @return the Description of the product
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the Description of the product.
     *
     * @param description the new Description of the product
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the Actual name of the product.
     *
     * @return the Actual name of the product
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the Actual name of the product.
     *
     * @param name the new Actual name of the product
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the Printing categorization. <code>Garment</code>, <code>Case</code>, <code>Mug</code>, or <code>Poster</code>.
     *
     * @return the Printing categorization
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the Printing categorization. <code>Garment</code>, <code>Case</code>, <code>Mug</code>, or <code>Poster</code>.
     *
     * @param type the new Printing categorization
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the {@link ProductProperties Product properties object}.
     *
     * @return the {@link ProductProperties Product properties object}
     */
    public ProductProperties getProperties() {
        return properties;
    }

    /**
     * Sets the {@link ProductProperties Product properties object}.
     *
     * @param properties the new {@link ProductProperties Product properties object}
     */
    public void setProperties(ProductProperties properties) {
        this.properties = properties;
    }

    /**
     * Gets the Array of available {@link Color color objects}.
     *
     * @return the Array of available {@link Color color objects}
     */
    public List<Color> getColors() {
        return colors;
    }

    /**
     * Sets the Array of available {@link Color color objects}.
     *
     * @param colors the new Array of available {@link Color color objects}
     */
    public void setColors(List<Color> colors) {
        this.colors = colors;
    }

    /**
     * Gets Whether the product is available to order.
     *
     * @return the availability to order
     */
    public String getAvailable() {
        return available;
    }

    /**
     * Sets Whether the product is available to order.
     *
     * @param available the new availability to order
     */
    public void setAvailable(String available) {
        this.available = available;
    }

    /**
     * Gets the {@link ProductTemplates templates}.
     *
     * @return the {@link ProductTemplates templates}
     */
    public ProductTemplates getTemplates() {
        return templates;
    }

    /**
     * Sets the {@link ProductTemplates templates}.
     *
     * @param template the new {@link ProductTemplates templates}
     */
    public void setTemplates(ProductTemplates templates) {
        this.templates = templates;
    }

    /**
     * Gets the API endpoint for product information (the current url).
     *
     * @return the API endpoint for product information (the current url)
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the API endpoint for product information (the current url).
     *
     * @param url the new API endpoint for product information (the current url)
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Gets the {@link Image Primary image object}.
     *
     * @return the {@link Image Primary image object}
     */
    public Image getImage() {
        return image;
    }

    /**
     * Sets the {@link Image Primary image object}.
     *
     * @param image the new {@link Image Primary image object}
     */
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * Gets the Unique identifier for the product.
     *
     * @return the Unique identifier for the product
     */
    public String getProductId() {
        return productId;
    }

    /**
     * Sets the Unique identifier for the product.
     *
     * @param productId the new Unique identifier for the product
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * Gets the Array of {@link Image image objects}.
     *
     * @return the Array of {@link Image image objects}
     */
    public List<Image> getAdditionalImages() {
        return additionalImages;
    }

    /**
     * Sets the Array of {@link Image image objects}.
     *
     * @param additionalImages the new Array of {@link Image image objects}
     */
    public void setAdditionalImages(List<Image> additionalImages) {
        this.additionalImages = additionalImages;
    }

    /**
     * Gets the API endpoint for product availability information.
     *
     * @return the API endpoint for product availability information
     */
    public String getAvailabilityUrl() {
        return availabilityUrl;
    }

    /**
     * Sets the API endpoint for product availability information.
     *
     * @param availabilityUrl the new API endpoint for product availability information
     */
    public void setAvailabilityUrl(String availabilityUrl) {
        this.availabilityUrl = availabilityUrl;
    }

    @Override
    public String toString() {
        return "Product [comments=" + comments + ", description=" + description
                + ", name=" + name + ", type=" + type + ", properties="
                + properties + ", colors=" + colors + ", available=" + available
                + ", templates=" + templates + ", url=" + url + ", image=" + image
                + ", productId=" + productId + ", additionalImages="
                + additionalImages + ", availabilityUrl=" + availabilityUrl
                + "]";
    }

}
