package com.github.gcauchis.scalablepress.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The Quote json object
 * 
 * @author gcauchis
 * @see https://scalablepress.com/docs/#standard-quote
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {
    /** Type of product this design is for: screenprint, dtg, case or mug */
    private String type;
    /**
     * Unique identifier for a design object to print, provided by the Design
     * API
     */
    private String designId;
    /**
     * Providing this optional sides object instead of a designId allows making
     * quotes without creating a Design first
     */
    private Sides sides;
    /** Array of order product objects to print on */
    private List<OrderProduct> products;
    /** Shipping address object */
    private Address address;
    /** Custom features object */
    private Features features;
    /** Optional reference name */
    private String name;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesignId() {
        return designId;
    }

    public void setDesignId(String designId) {
        this.designId = designId;
    }

    public Sides getSides() {
        return sides;
    }

    public void setSides(Sides sides) {
        this.sides = sides;
    }

    public List<OrderProduct> getProducts() {
        return products;
    }

    public void setProducts(List<OrderProduct> products) {
        this.products = products;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Features getFeatures() {
        return features;
    }

    public void setFeatures(Features features) {
        this.features = features;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Quote [type=" + type + ", designId=" + designId + ", sides="
                + sides + ", products=" + products + ", address=" + address
                + ", features=" + features + ", name=" + name + "]";
    }
}
