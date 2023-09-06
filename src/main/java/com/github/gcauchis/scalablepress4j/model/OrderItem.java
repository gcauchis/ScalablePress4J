/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016-2023 Gabriel Cauchis
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
 * The Order Item json object.
 *
 * @author gcauchis
 * @see <a href="https://scalablepress.com/docs/#order-item-object">https://scalablepress.com/docs/#order-item-object</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderItem {

    /** The item index. */
    private Number itemIndex;

    /** Type of printing (<code>dtg</code>, <code>screenprint</code>, <code>case</code>, <code>mug</code>, or <code>poster</code>). */
    private String type;

    /** Unique identifier for a design object provided by the Design API. */
    private String designId;

    /** {@link Address object}. */
    private Address address;

    /** Array of {@link OrderProduct order product objects}. */
    private List<OrderProduct> products;

    /** API endpoint to Design API where information on the design can be retrieved. */
    private String designUrl;

    /** Name of the last event that occurred to this particular order item. */
    private String status;

    /**
     * Once the status is shipped, this will contain the tracking number of the item. Multiple order items may have the same tracking number if they are shipped
     * together.
     */
    private String tracking;

    /** {@link Features Custom features object}. */
    private Features features;

    /** Reference name provided by the user. */
    private String name;

    /**
     * Gets the item index.
     *
     * @return the item index
     */
    public Number getItemIndex() {
        return itemIndex;
    }

    /**
     * Sets the item index.
     *
     * @param itemIndex the new item index
     */
    public void setItemIndex(Number itemIndex) {
        this.itemIndex = itemIndex;
    }

    /**
     * Gets the Type of printing (<code>dtg</code>, <code>screenprint</code>, <code>case</code>, <code>mug</code>, or <code>poster</code>).
     *
     * @return the Type of printing
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the Type of printing (<code>dtg</code>, <code>screenprint</code>, <code>case</code>, <code>mug</code>, or <code>poster</code>).
     *
     * @param type the new Type of printing
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the Unique identifier for a design object provided by the Design API.
     *
     * @return the Unique identifier for a design object provided by the Design API
     */
    public String getDesignId() {
        return designId;
    }

    /**
     * Sets the Unique identifier for a design object provided by the Design API.
     *
     * @param designId the new Unique identifier for a design object provided by the Design API
     */
    public void setDesignId(String designId) {
        this.designId = designId;
    }

    /**
     * Gets the {@link Address object}.
     *
     * @return the {@link Address object}
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the {@link Address object}.
     *
     * @param address the new {@link Address object}
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Gets the Array of {@link OrderProduct order product objects}.
     *
     * @return the Array of {@link OrderProduct order product objects}
     */
    public List<OrderProduct> getProducts() {
        return products;
    }

    /**
     * Sets the Array of {@link OrderProduct order product objects}.
     *
     * @param products the new Array of {@link OrderProduct order product objects}
     */
    public void setProducts(List<OrderProduct> products) {
        this.products = products;
    }

    /**
     * Gets the API endpoint to Design API where information on the design can be retrieved.
     *
     * @return the API endpoint to Design API where information on the design can be retrieved
     */
    public String getDesignUrl() {
        return designUrl;
    }

    /**
     * Sets the API endpoint to Design API where information on the design can be retrieved.
     *
     * @param designUrl the new API endpoint to Design API where information on the design can be retrieved
     */
    public void setDesignUrl(String designUrl) {
        this.designUrl = designUrl;
    }

    /**
     * Gets the Name of the last event that occurred to this particular order item.
     *
     * @return the Name of the last event that occurred to this particular order item
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the Name of the last event that occurred to this particular order item.
     *
     * @param status the new Name of the last event that occurred to this particular order item
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the Once the status is shipped, this will contain the tracking number of the item. Multiple order items may have the same tracking number if they
     * are shipped together.
     *
     * @return the tracking number of the item
     */
    public String getTracking() {
        return tracking;
    }

    /**
     * Sets the Once the status is shipped, this will contain the tracking number of the item. Multiple order items may have the same tracking number if they
     * are shipped together.
     *
     * @param tracking the new tracking number of the item
     */
    public void setTracking(String tracking) {
        this.tracking = tracking;
    }

    /**
     * Gets the {@link Features Custom features object}.
     *
     * @return the {@link Features Custom features object}
     */
    public Features getFeatures() {
        return features;
    }

    /**
     * Sets the {@link Features Custom features object}.
     *
     * @param features the new {@link Features Custom features object}
     */
    public void setFeatures(Features features) {
        this.features = features;
    }

    /**
     * Gets the Reference name provided by the user.
     *
     * @return the Reference name provided by the user
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the Reference name provided by the user.
     *
     * @param name the new Reference name provided by the user
     */
    public void setName(String name) {
        this.name = name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "OrderItem [itemIndex=" + itemIndex + ", type=" + type
                + ", designId=" + designId + ", address=" + address
                + ", products=" + products + ", designUrl=" + designUrl
                + ", status=" + status + ", tracking=" + tracking
                + ", features=" + features + ", name=" + name + "]";
    }
}
