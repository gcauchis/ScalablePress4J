package com.github.gcauchis.scalablepress.services;

import org.springframework.stereotype.Service;

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

}
