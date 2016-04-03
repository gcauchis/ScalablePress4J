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
package com.github.gcauchis.scalablepress.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The Order json object
 * 
 * @author gcauchis
 * @see https://scalablepress.com/docs/#order-object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order {
    /** Name of the last event that occurred */
    private String status;
    /** Price for the order */
    private Number total;
    /** Shipping component of quote total */
    private Number shipping;
    /** Subtotal component of quote total */
    private Number subtotal;
    /** Tax component of quote total */
    private Number tax;
    /** Other fee components of quote total */
    private Number fees;
    /**
     * Unique identifier which can be used to place an order, can also be used
     * to retrieve a quote
     */
    private String orderToken;
    /** Time at which order object was created */
    private String createdAt;
    /** Array of item objects */
    private List<OrderItem> items;
    /** Array of event objects */
    private List<Event> events;
    /**
     * Unique id for the order, can be used to get order information using the
     * Order API (only exists when an order has been placed)
     */
    private String orderId;
    /** test or live */
    private String mode;
    /** Array of warningIDs */
    private List<String> warnings;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Number getTotal() {
        return total;
    }

    public void setTotal(Number total) {
        this.total = total;
    }

    public Number getShipping() {
        return shipping;
    }

    public void setShipping(Number shipping) {
        this.shipping = shipping;
    }

    public Number getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Number subtotal) {
        this.subtotal = subtotal;
    }

    public Number getTax() {
        return tax;
    }

    public void setTax(Number tax) {
        this.tax = tax;
    }

    public Number getFees() {
        return fees;
    }

    public void setFees(Number fees) {
        this.fees = fees;
    }

    public String getOrderToken() {
        return orderToken;
    }

    public void setOrderToken(String orderToken) {
        this.orderToken = orderToken;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public List<String> getWarnings() {
        return warnings;
    }

    public void setWarnings(List<String> warnings) {
        this.warnings = warnings;
    }

    @Override
    public String toString() {
        return "Order [status=" + status + ", total=" + total + ", shipping="
                + shipping + ", subtotal=" + subtotal + ", tax=" + tax
                + ", fees=" + fees + ", orderToken=" + orderToken
                + ", createdAt=" + createdAt + ", items=" + items + ", events="
                + events + ", orderId=" + orderId + ", mode=" + mode
                + ", warnings=" + warnings + "]";
    }
}
