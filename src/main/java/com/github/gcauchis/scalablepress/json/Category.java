package com.github.gcauchis.scalablepress.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Category {

    /** Printing categorization. Garment, Case, or Mug */
    private String type;
    /** Name of the category */
    private String name;
    /** Additional categorization, for example Unisex */
    private String family;
    /** Image object */
    private Image image;
    /** API endpoint for category details */
    private String url;
    /** Unique identifier for the category */
    private String categoryId;
    /** The category products */
    private List<ProductOveriew> products;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public List<ProductOveriew> getProducts() {
        return products;
    }

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
