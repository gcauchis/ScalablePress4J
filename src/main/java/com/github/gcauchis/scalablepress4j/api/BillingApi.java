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
package com.github.gcauchis.scalablepress4j.api;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.github.gcauchis.scalablepress4j.ScalablePressBadRequestException;
import com.github.gcauchis.scalablepress4j.model.Invoice;

/**
 * The Scalable Press API allows orders to be placed without paying first.
 * However customers with insufficient credit in their account will have orders
 * held until enough credit is available.<br/>
 * 
 * Every order has a corresponding Invoice object that is created after the
 * order has passed the validated status. The invoice object lists the total
 * amount charged, and the remaining balance due.<br/>
 * 
 * Payment can be made against the invoice if a balance is still outstanding.<br/>
 * 
 * Currently the billing API only allows paying an invoice by providing a PayPal
 * transaction ID. Credit card, PayPal checkout, and ACH payment is possible via
 * the Scalable Press website only.<br/>
 * <ul>
 * <li>List invoice objects</li>
 * <li>Retrieve invoice object</li>
 * <li>Pay invoice with PayPal transaction</li>
 * </ul>
 * 
 * @author gcauchis
 * @see <a href="https://scalablepress.com/docs/#billing-api">https://scalablepress.com/docs/#billing-api</a>
 */
public class BillingApi extends AbstractRestApi {

    /** The Constant URL_INVOICE. */
    private static final String URL_INVOICE = "invoice";

    /** The Constant URL_BILLING. */
    private static final String URL_BILLING = "billing";

    /**
     * Shows all invoices for an account, sorted descending.
     *
     * @return the list
     * @throws ScalablePressBadRequestException for invalid request or error occur during call.
     * @see <a href="https://scalablepress.com/docs/#list-invoice-objects">https://scalablepress.com/docs/#list-invoice-objects</a>
     */
    public List<Invoice> listInvoice() {
        // "billing/invoice" or "billing" ? definition and example different...
        return Arrays.asList(get(buildUrl(URL_BILLING, URL_INVOICE), Invoice[].class));
    }

    /**
     * Provide the invoiceId in order to receive the details of an invoice
     * 
     * @param invoiceId the invoiceId
     * @return an {@link Invoice invoice object}
     * @throws ScalablePressBadRequestException for invalid request or error occur during call.
     * @see <a href="https://scalablepress.com/docs/#retrieve-invoice-object">https://scalablepress.com/docs/#retrieve-invoice-object</a>
     */
    public Invoice retrieveInvoice(String invoiceId) {
        return get(buildUrl(URL_BILLING, URL_INVOICE, invoiceId), Invoice.class);
    }

    /**
     * Send the transaction ID of a confirmed PayPal transaction in order to
     * associate that payment with your billing account. The provided email
     * argument must match the payer email of the PayPal transaction. The amount
     * must match the amount of the transaction.<br/>
     * 
     * Each unique transaction can only be associated with any Scalable Press
     * account once.<br/>
     * 
     * Multiple PayPal transactions can be used to pay off the same invoice,
     * however until the total credits on the invoice equals or exceeds the
     * invoice total, the associated order may remain on hold in the unpaid
     * status.<br/>
     * 
     * @param invoiceId the invoiceId
     * @param transactionId
     *        The PayPal transaction ID of a completed transaction
     * @param amount
     *        Total amount of PayPal transaction
     * @param email
     *        Email address of payer of PayPal transaction
     * @return a Invoice object with updated balance.
     * @throws ScalablePressBadRequestException for invalid request or error occur during call.
     * @see <a href=
     *      "https://scalablepress.com/docs/#pay-invoice-with-paypal-transaction">https://scalablepress.com/docs/#pay-invoice-with-paypal-transaction</a>
     */
    public Invoice payInvoiceWithPayPalTransaction(String invoiceId,
            String transactionId, Number amount, String email) {
        Map<String, Object> args = new LinkedHashMap<>();
        args.put("transactionId", transactionId);
        args.put("amount", amount);
        args.put("email", email);
        return post(buildUrl(URL_BILLING, URL_INVOICE, invoiceId, "pay", "paypal"), args, Invoice.class);
    }
}
