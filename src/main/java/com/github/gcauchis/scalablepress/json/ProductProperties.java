package com.github.gcauchis.scalablepress.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductProperties {
    /** Brand of the product */
    private String brand;
    /** Material the product is made from */
    private String material;
    /** Style code associated with the product */
    private String style;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Override
    public String toString() {
        return "ProductProperties [brand=" + brand + ", material=" + material
                + ", style=" + style + "]";
    }
}
