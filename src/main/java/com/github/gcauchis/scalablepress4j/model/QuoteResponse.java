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
 * The Quote Response json object.
 * 
 * @author gcauchis
 * @see https://scalablepress.com/docs/#quote-response-object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuoteResponse {

    /** The returned status code. */
    private Number statusCode;

    /** Quoted price for the order. */
    private Number total;

    /** Shipping component of quote total. */
    private Number shipping;

    /** Subtotal component of quote total. */
    private Number subtotal;

    /** Tax component of quote total. */
    private Number tax;

    /** Other fee components of quote total. */
    private Number fees;

    /** List of warnings as human readable strings. */
    private List<String> warnings;

    /** Array of {@link Error error objects} which are preventing a successful quote. */
    private List<Error> issues;

    /** Array of {@link Error error objects} which are preventing your quote from being order-ready. */
    private List<Error> orderIssues;

    /** Unique identifier which can be used to place an order, can also be used to retrieve a quote. */
    private String orderToken;

    /** "test" or "live". */
    private String mode;

    /**
     * Gets the returned status code.
     *
     * @return the returned status code
     */
    public Number getStatusCode() {
        return statusCode;
    }

    /**
     * Sets the returned status code.
     *
     * @param statusCode the new returned status code
     */
    public void setStatusCode(Number statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * Gets the Quoted price for the order.
     *
     * @return the Quoted price for the order
     */
    public Number getTotal() {
        return total;
    }

    /**
     * Sets the Quoted price for the order.
     *
     * @param total the new Quoted price for the order
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
     * Gets the List of warnings as human readable strings.
     *
     * @return the List of warnings as human readable strings
     */
    public List<String> getWarnings() {
        return warnings;
    }

    /**
     * Sets the List of warnings as human readable strings.
     *
     * @param warnings the new List of warnings as human readable strings
     */
    public void setWarnings(List<String> warnings) {
        this.warnings = warnings;
    }

    /**
     * Gets the issues.
     *
     * @return the issues
     */
    public List<Error> getIssues() {
        return issues;
    }

    /**
     * Sets the issues.
     *
     * @param issues the new issues
     */
    public void setIssues(List<Error> issues) {
        this.issues = issues;
    }

    /**
     * Gets the Array of {@link Error error objects} which are preventing your quote from being order-ready.
     *
     * @return the Array of {@link Error error objects} which are preventing your quote from being order-ready
     */
    public List<Error> getOrderIssues() {
        return orderIssues;
    }

    /**
     * Sets the Array of {@link Error error objects} which are preventing your quote from being order-ready.
     *
     * @param orderIssues the new Array of {@link Error error objects} which are preventing your quote from being order-ready
     */
    public void setOrderIssues(List<Error> orderIssues) {
        this.orderIssues = orderIssues;
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
     * Gets the "test" or "live".
     *
     * @return the "test" or "live"
     */
    public String getMode() {
        return mode;
    }

    /**
     * Sets the "test" or "live".
     *
     * @param mode the new "test" or "live"
     */
    public void setMode(String mode) {
        this.mode = mode;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "QuoteResponse [statusCode=" + statusCode + ", total=" + total
                + ", shipping=" + shipping + ", subtotal=" + subtotal
                + ", tax=" + tax + ", fees=" + fees + ", warnings=" + warnings
                + ", issues=" + issues + ", orderIssues=" + orderIssues
                + ", orderToken=" + orderToken + ", mode=" + mode + "]";
    }

}
