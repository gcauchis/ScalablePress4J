package com.github.gcauchis.scalablepress.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

    /** Comments on the product (its fit and/or feel) */
    private String comments;
    /** Description of the product */
    private String description;
    /** Actual name of the product */
    private String name;
    /** Printing categorization. Garment, Case, or Mug */
    private String type;
    /** Product properties object */
    private ProductProperties properties;
    /** Array of available color objects */
    private List<Color> colors;
    /** Whether the product is available to order */
    private String available;
    /** API endpoint for product information (the current url) */
    private String url;
    /** Primary image object */
    private Image image;
    /** Unique identifier for the product */
    private String productId;
    /** Array of image objects */
    private List<Image> additionalImages;
    /** API endpoint for product availability information */
    private String availabilityUrl;

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ProductProperties getProperties() {
        return properties;
    }

    public void setProperties(ProductProperties properties) {
        this.properties = properties;
    }

    public List<Color> getColors() {
        return colors;
    }

    public void setColors(List<Color> colors) {
        this.colors = colors;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public List<Image> getAdditionalImages() {
        return additionalImages;
    }

    public void setAdditionalImages(List<Image> additionalImages) {
        this.additionalImages = additionalImages;
    }

    public String getAvailabilityUrl() {
        return availabilityUrl;
    }

    public void setAvailabilityUrl(String availabilityUrl) {
        this.availabilityUrl = availabilityUrl;
    }

    @Override
    public String toString() {
        return "Product [comments=" + comments + ", description=" + description
                + ", name=" + name + ", type=" + type + ", properties="
                + properties + ", colors=" + colors + ", available="
                + available + ", url=" + url + ", image=" + image
                + ", productId=" + productId + ", additionalImages="
                + additionalImages + ", availabilityUrl=" + availabilityUrl
                + "]";
    }
}
