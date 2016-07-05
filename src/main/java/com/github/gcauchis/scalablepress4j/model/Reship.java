/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Gabriel Cauchis
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
 * The Reship json object.
 *
 * @author gcauchis
 * @see <a href="https://scalablepress.com/docs/#reship-object">https://scalablepress.com/docs/#reship-object</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Reship {

    /** Time at which order object was returned to facility. */
    private String createdAt;

    /** Unique identifier which can be used to retrieve information about, place, and cancel this reship order. */
    private String reshipId;

    /** Name of the last event that occurred to this particular order item. */
    private String status;

    /** Unique identifier which can be used to retrieve information about the order that was returned. */
    private String orderId;

    /** Array of indices that correspond to the order items array. */
    private List<Number> orderItemIndices;

    /** Shipping price for an order that has been reshipped after being returned. */
    private Number price;

    /**
     * Gets the Time at which order object was returned to facility.
     *
     * @return the Time at which order object was returned to facility
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the Time at which order object was returned to facility.
     *
     * @param createdAt the new Time at which order object was returned to facility
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets the Unique identifier which can be used to retrieve information about, place, and cancel this reship order.
     *
     * @return the Unique identifier which can be used to retrieve information about, place, and cancel this reship order
     */
    public String getReshipId() {
        return reshipId;
    }

    /**
     * Sets the Unique identifier which can be used to retrieve information about, place, and cancel this reship order.
     *
     * @param reshipId the new Unique identifier which can be used to retrieve information about, place, and cancel this reship order
     */
    public void setReshipId(String reshipId) {
        this.reshipId = reshipId;
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
     * Gets the Unique identifier which can be used to retrieve information about the order that was returned.
     *
     * @return the Unique identifier which can be used to retrieve information about the order that was returned
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * Sets the Unique identifier which can be used to retrieve information about the order that was returned.
     *
     * @param orderId the new Unique identifier which can be used to retrieve information about the order that was returned
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * Gets the Array of indices that correspond to the order items array.
     *
     * @return the Array of indices that correspond to the order items array
     */
    public List<Number> getOrderItemIndices() {
        return orderItemIndices;
    }

    /**
     * Sets the Array of indices that correspond to the order items array.
     *
     * @param orderItemIndices the new Array of indices that correspond to the order items array
     */
    public void setOrderItemIndices(List<Number> orderItemIndices) {
        this.orderItemIndices = orderItemIndices;
    }

    /**
     * Gets the Shipping price for an order that has been reshipped after being returned.
     *
     * @return the Shipping price for an order that has been reshipped after being returned
     */
    public Number getPrice() {
        return price;
    }

    /**
     * Sets the Shipping price for an order that has been reshipped after being returned.
     *
     * @param price the new Shipping price for an order that has been reshipped after being returned
     */
    public void setPrice(Number price) {
        this.price = price;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Reship [createdAt=" + createdAt + ", reshipId=" + reshipId
                + ", status=" + status + ", orderId=" + orderId
                + ", orderItemIndices=" + orderItemIndices + ", price=" + price
                + "]";
    }
}
