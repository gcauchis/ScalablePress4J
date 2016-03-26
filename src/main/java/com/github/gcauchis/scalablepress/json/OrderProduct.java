package com.github.gcauchis.scalablepress.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The Order Product json object
 * 
 * @author gcauchis
 * @see https://scalablepress.com/docs/#standard-quote
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderProduct {
    /**
     * productId of the product you wish to order, retrieved from the Product
     * API, this product must be compatible with the design provided
     */
    private String id;
    /** Color of the product, see the Product API for available colors */
    private String color;
    /** Size of the product, see the Product API for available sizes */
    private String size;
    /** Quantity of this product/color/size to order */
    private Integer quantity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderProduct [id=" + id + ", color=" + color + ", size=" + size
                + ", quantity=" + quantity + "]";
    }
}
