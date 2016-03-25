package com.github.gcauchis.scalablepress.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductOveriew {

    /** Product name */
    private String name;
    /** Reference code associated with the product */
    private String style;
    /** Image object */
    private Image image;
    /** Unique identifier for the product */
    private String id;
    /** API endpoint for product details */
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ProductOveriew [name=" + name + ", style=" + style + ", image="
                + image + ", id=" + id + ", url=" + url + "]";
    }

}
