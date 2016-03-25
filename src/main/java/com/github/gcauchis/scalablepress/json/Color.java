package com.github.gcauchis.scalablepress.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Color {

    /** Name of the color */
    private String name;
    /** Hex color code of the color */
    private String hex;
    /** Array of image objects */
    private List<Image> image;
    /** Array of available sizes */
    private List<String> sizes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    public List<Image> getImage() {
        return image;
    }

    public void setImage(List<Image> image) {
        this.image = image;
    }

    public List<String> getSizes() {
        return sizes;
    }

    public void setSizes(List<String> sizes) {
        this.sizes = sizes;
    }

    @Override
    public String toString() {
        return "Color [name=" + name + ", hex=" + hex + ", image=" + image
                + ", sizes=" + sizes + "]";
    }
}
