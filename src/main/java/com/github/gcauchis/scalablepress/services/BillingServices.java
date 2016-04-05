package com.github.gcauchis.scalablepress.services;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.github.gcauchis.scalablepress.model.Invoice;

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
 * @see https://scalablepress.com/docs/#billing-api
 */
@Service
public class BillingServices extends AbstractRestServices {

    /**
     * Shows all invoices for an account, sorted descending.
     * 
     * @return
     * @see https://scalablepress.com/docs/#list-invoice-objects
     */
    public List<Invoice> listInvoice() {
        // "billing/invoice" or "billing" ? definition and example different...
        return Arrays.asList(get("billing/invoice", Invoice[].class));
    }

    /**
     * Provide the invoiceId in order to receive the details of an invoice
     * 
     * @param invoiceId
     * @return
     * @see https://scalablepress.com/docs/#retrieve-invoice-object
     */
    public Invoice retreiveInvoice(String invoiceId) {
        return get("billing/invoice/" + invoiceId, Invoice.class);
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
     * @param invoiceId
     * @param transactionId
     *            The PayPal transaction ID of a completed transaction
     * @param amount
     *            Total amount of PayPal transaction
     * @param email
     *            Email address of payer of PayPal transaction
     * @return a Invoice object with updated balance.
     * @see https://scalablepress.com/docs/#pay-invoice-with-paypal-transaction
     */
    public Invoice payInvoiceWithPayPalTransaction(String invoiceId, String transactionId, Number amount, String email) {
        Map<String, Object> args = new LinkedHashMap<>();
        args.put("transactionId", transactionId);
        args.put("amount", amount);
        args.put("email", email);
        return post("billing/invoice/" + invoiceId + "/pay/paypal", args, Invoice.class);
    }
}
