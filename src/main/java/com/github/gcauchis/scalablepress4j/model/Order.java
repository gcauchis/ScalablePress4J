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
 * The Order json object.
 *
 * @author gcauchis
 * @see https://scalablepress.com/docs/#order-object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order {
    
    /** Name of the last event that occurred. */
    private String status;
    
    /** Price for the order. */
    private Number total;
    
    /** Shipping component of quote total. */
    private Number shipping;
    
    /** Subtotal component of quote total. */
    private Number subtotal;
    
    /** Tax component of quote total. */
    private Number tax;
    
    /** Other fee components of quote total. */
    private Number fees;
    
    /** Unique identifier which can be used to place an order, can also be used to retrieve a quote. */
    private String orderToken;
    
    /** Time at which order object was created. */
    private String createdAt;
    
    /** Time at which order object was deleted. */
    private String deletedAt;
    
    /** Array of {@link OrderItem item objects}. */
    private List<OrderItem> items;
    
    /** Array of {@link Event event objects}. */
    private List<Event> events;
    
    /** Unique id for the order, can be used to get order information using the Order API (only exists when an order has been placed). */
    private String orderId;
    
    /** <code>test</code> or <code>live</code>. */
    private String mode;
    
    /** Array of warningIDs. */
    private List<String> warnings;

    /**
     * Gets the Name of the last event that occurred.
     *
     * @return the Name of the last event that occurred
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the Name of the last event that occurred.
     *
     * @param status the new Name of the last event that occurred
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the Price for the order.
     *
     * @return the Price for the order
     */
    public Number getTotal() {
        return total;
    }

    /**
     * Sets the Price for the order.
     *
     * @param total the new Price for the order
     */
    public void setTotal(Number total) {
        this.total = total;
    }

    /**
     * Gets the Shipping component of quote total.
     *
     * @return the Shipping component of quote total
     */
    public Number getShipping() {
        return shipping;
    }

    /**
     * Sets the Shipping component of quote total.
     *
     * @param shipping the new Shipping component of quote total
     */
    public void setShipping(Number shipping) {
        this.shipping = shipping;
    }

    /**
     * Gets the Subtotal component of quote total.
     *
     * @return the Subtotal component of quote total
     */
    public Number getSubtotal() {
        return subtotal;
    }

    /**
     * Sets the Subtotal component of quote total.
     *
     * @param subtotal the new Subtotal component of quote total
     */
    public void setSubtotal(Number subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * Gets the Tax component of quote total.
     *
     * @return the Tax component of quote total
     */
    public Number getTax() {
        return tax;
    }

    /**
     * Sets the Tax component of quote total.
     *
     * @param tax the new Tax component of quote total
     */
    public void setTax(Number tax) {
        this.tax = tax;
    }

    /**
     * Gets the Other fee components of quote total.
     *
     * @return the Other fee components of quote total
     */
    public Number getFees() {
        return fees;
    }

    /**
     * Sets the Other fee components of quote total.
     *
     * @param fees the new Other fee components of quote total
     */
    public void setFees(Number fees) {
        this.fees = fees;
    }

    /**
     * Gets the Unique identifier which can be used to place an order, can also be used to retrieve a quote.
     *
     * @return the Unique identifier which can be used to place an order, can also be used to retrieve a quote
     */
    public String getOrderToken() {
        return orderToken;
    }

    /**
     * Sets the Unique identifier which can be used to place an order, can also be used to retrieve a quote.
     *
     * @param orderToken the new Unique identifier which can be used to place an order, can also be used to retrieve a quote
     */
    public void setOrderToken(String orderToken) {
        this.orderToken = orderToken;
    }

    /**
     * Gets the Time at which order object was created.
     *
     * @return the Time at which order object was created
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the Time at which order object was created.
     *
     * @param createdAt the new Time at which order object was created
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets the Time at which order object was deleted.
     *
     * @return the Time at which order object was deleted
     */
    public String getDeletedAt() {
        return deletedAt;
    }

    /**
     * Sets the Time at which order object was deleted.
     *
     * @param deletedAt the new Time at which order object was deleted
     */
    public void setDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt;
    }

    /**
     * Gets the Array of {@link OrderItem item objects}.
     *
     * @return the Array of {@link OrderItem item objects}
     */
    public List<OrderItem> getItems() {
        return items;
    }

    /**
     * Sets the Array of {@link OrderItem item objects}.
     *
     * @param items the new Array of {@link OrderItem item objects}
     */
    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    /**
     * Gets the Array of {@link Event event objects}.
     *
     * @return the Array of {@link Event event objects}
     */
    public List<Event> getEvents() {
        return events;
    }

    /**
     * Sets the Array of {@link Event event objects}.
     *
     * @param events the new Array of {@link Event event objects}
     */
    public void setEvents(List<Event> events) {
        this.events = events;
    }

    /**
     * Gets the Unique id for the order, can be used to get order information using the Order API (only exists when an order has been placed).
     *
     * @return the Unique id for the order
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * Sets the Unique id for the order, can be used to get order information using the Order API (only exists when an order has been placed).
     *
     * @param orderId the new Unique id for the order
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * Gets the <code>test</code> or <code>live</code>.
     *
     * @return the <code>test</code> or <code>live</code>
     */
    public String getMode() {
        return mode;
    }

    /**
     * Sets the <code>test</code> or <code>live</code>.
     *
     * @param mode the new <code>test</code> or <code>live</code>
     */
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * Gets the Array of warningIDs.
     *
     * @return the Array of warningIDs
     */
    public List<String> getWarnings() {
        return warnings;
    }

    /**
     * Sets the Array of warningIDs.
     *
     * @param warnings the new Array of warningIDs
     */
    public void setWarnings(List<String> warnings) {
        this.warnings = warnings;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Order [status=" + status + ", total=" + total + ", shipping="
                + shipping + ", subtotal=" + subtotal + ", tax=" + tax
                + ", fees=" + fees + ", orderToken=" + orderToken
                + ", createdAt=" + createdAt + ", deletedAt=" + deletedAt
                + ", items=" + items + ", events=" + events + ", orderId="
                + orderId + ", mode=" + mode + ", warnings=" + warnings + "]";
    }

}
