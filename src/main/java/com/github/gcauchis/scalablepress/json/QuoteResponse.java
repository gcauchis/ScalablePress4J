package com.github.gcauchis.scalablepress.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The Quote Response json object.
 * 
 * @author gcauchis
 * @see https://scalablepress.com/docs/#standard-quote
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteResponse {
    /** Quoted price for the order */
    private Number total;
    /** Shipping component of quote total */
    private Number shipping;
    /** Subtotal component of quote total */
    private Number subtotal;
    /** Tax component of quote total */
    private Number tax;
    /** Other fee components of quote total */
    private Number fees;
    /** List of warnings as human readable strings */
    private List<String> warnings;
    /** Array of error objects which are preventing a successful quote */
    private List<Error> issues;
    /**
     * Array of error objects which are preventing your quote from being
     * order-ready
     */
    private List<Error> orderIssues;
    /**
     * Unique identifier which can be used to place an order, can also be used
     * to retrieve a quote
     */
    private String orderToken;
    /** “test” or “live” */
    private String mode;

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

    public List<String> getWarnings() {
        return warnings;
    }

    public void setWarnings(List<String> warnings) {
        this.warnings = warnings;
    }

    public List<Error> getIssues() {
        return issues;
    }

    public void setIssues(List<Error> issues) {
        this.issues = issues;
    }

    public List<Error> getOrderIssues() {
        return orderIssues;
    }

    public void setOrderIssues(List<Error> orderIssues) {
        this.orderIssues = orderIssues;
    }

    public String getOrderToken() {
        return orderToken;
    }

    public void setOrderToken(String orderToken) {
        this.orderToken = orderToken;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    @Override
    public String toString() {
        return "QuoteResponse [total=" + total + ", shipping=" + shipping
                + ", subtotal=" + subtotal + ", tax=" + tax + ", fees=" + fees
                + ", warnings=" + warnings + ", issues=" + issues
                + ", orderIssues=" + orderIssues + ", orderToken=" + orderToken
                + ", mode=" + mode + "]";
    }
}
