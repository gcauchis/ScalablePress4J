/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2016-2018 Gabriel Cauchis
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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The Invoice json object.
 *
 * @author gcauchis
 * @see <a href="https://scalablepress.com/docs/#invoice-object">https://scalablepress.com/docs/#invoice-object</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Invoice {
    
    /** Unique id for the order, can be used to get invoice information or pay the invoice. */
    private String invoiceId;
    
    /** The time at which the invoice object was created. */
    private String createdAt;
    
    /** The order that this invoice is for. */
    private String orderId;
    
    /** The dollar total charges on the invoice, matches the order total. */
    private Number total;
    
    /** The dollar total that remains unpaid on the invoice. A negative balance indicates overpayment */
    private Number balance;

    /**
     * Gets the Unique id for the order, can be used to get invoice information or pay the invoice.
     *
     * @return the Unique id for the order, can be used to get invoice information or pay the invoice
     */
    public String getInvoiceId() {
        return invoiceId;
    }

    /**
     * Sets the Unique id for the order, can be used to get invoice information or pay the invoice.
     *
     * @param invoiceId the new Unique id for the order, can be used to get invoice information or pay the invoice
     */
    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    /**
     * Gets the The time at which the invoice object was created.
     *
     * @return the The time at which the invoice object was created
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the The time at which the invoice object was created.
     *
     * @param createdAt the new The time at which the invoice object was created
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets the The order that this invoice is for.
     *
     * @return the The order that this invoice is for
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * Sets the The order that this invoice is for.
     *
     * @param orderId the new The order that this invoice is for
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * Gets The dollar total charges on the invoice, matches the order total.
     *
     * @return The dollar total charges on the invoice, matches the order total
     */
    public Number getTotal() {
        return total;
    }

    /**
     * Sets The dollar total charges on the invoice, matches the order total.
     *
     * @param total the new dollar total charges on the invoice, matches the order total
     */
    public void setTotal(Number total) {
        this.total = total;
    }

    /**
     * Gets The dollar total that remains unpaid on the invoice. A negative balance indicates overpayment.
     *
     * @return The dollar total that remains unpaid on the invoice. A negative balance indicates overpayment
     */
    public Number getBalance() {
        return balance;
    }

    /**
     * Sets The dollar total that remains unpaid on the invoice. A negative balance indicates overpayment.
     *
     * @param balance the new dollar total that remains unpaid on the invoice. A negative balance indicates overpayment
     */
    public void setBalance(Number balance) {
        this.balance = balance;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Invoice [invoiceId=" + invoiceId + ", createdAt=" + createdAt
                + ", orderId=" + orderId + ", total=" + total + ", balance="
                + balance + "]";
    }

}
