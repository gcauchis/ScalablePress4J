package com.github.gcauchis.scalablepress.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The Invoice json object
 * 
 * @author gcauchis
 * @see https://scalablepress.com/docs/#invoice-object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Invoice {
    /**
     * Unique id for the order, can be used to get invoice information or pay
     * the invoice
     */
    private String invoiceId;
    /** The time at which the invoice object was created */
    private String createdAt;
    /** The order that this invoice is for */
    private String orderId;
    /** The dollar total charges on the invoice, matches the order total */
    private Number total;
    /**
     * The dollar total that remains unpaid on the invoice. A negative balance
     * indicates overpayment
     */
    private Number balance;

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Number getTotal() {
        return total;
    }

    public void setTotal(Number total) {
        this.total = total;
    }

    public Number getBalance() {
        return balance;
    }

    public void setBalance(Number balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Invoice [invoiceId=" + invoiceId + ", createdAt=" + createdAt
                + ", orderId=" + orderId + ", total=" + total + ", balance="
                + balance + "]";
    }

}
