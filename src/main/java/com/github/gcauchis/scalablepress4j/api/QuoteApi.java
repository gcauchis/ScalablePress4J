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
package com.github.gcauchis.scalablepress4j.api;

import com.github.gcauchis.scalablepress4j.ScalablePressBadRequestException;
import com.github.gcauchis.scalablepress4j.model.BulkQuote;
import com.github.gcauchis.scalablepress4j.model.Order;
import com.github.gcauchis.scalablepress4j.model.Quote;
import com.github.gcauchis.scalablepress4j.model.QuoteResponse;

/**
 * The Quote API lets you get an exact quote before placing an order. When using
 * this API, it is important to understand the three possible outcomes:<br>
 * <ul>
 * <li>Order-ready — quote is successful and the information sent to the API is
 * enough to place an actual order</li>
 * <li>Quote-only — quote is successful but the information sent is not
 * sufficient to place an order</li>
 * <li>Error — quote is unsuccessful due to the information being sent to the
 * API is either invalid or incomplete</li>
 * </ul>
 * 
 * Standard quotes allow a single design printed on one or more products,
 * shipped to a single address. Bulk quotes allow greater flexibility for
 * multiple printing orders and split shipping.<br>
 * 
 * Besides making a quote, the Quote API can also be used to retrieve a quote
 * which was previously completed. The quote API can also breakdown a bulk
 * quote’s pricing into a per item basis.<br>
 * 
 * In order to receive a quote and place an order for any of these advanced
 * features, the bulk quote API should be used:<br>
 * 
 * <ul>
 * <li>Split shipping — send a single printing design to multiple shipping
 * addresses and take advantage of large quantity printing pricing</li>
 * <li>Multiple designs — print multiple designs on multiple garments and take
 * advantage of possible combined shipping</li>
 * <li>Multiple printing — print on different products and take advantage of
 * possible combined shipping</li>
 * </ul>
 * 
 * A bulk quote with a single but unspecified design can be generated to
 * estimate post-discount pricing.<br>
 * 
 * The Quote API also allows for custom order features for your order:<br>
 * 
 * <ul>
 * <li>Select shipping option — select a preferred shipping option for an item
 * in the order. Third party shipping account is required</li>
 * <li>Custom packing slip — provide a packing slip to be shipped with the
 * package</li>
 * <li>Custom white label - provide a custom from address on the shipping white
 * label</li>
 * </ul>
 * 
 * @author gcauchis
 * @see <a href="https://scalablepress.com/docs/#quote-api">https://scalablepress.com/docs/#quote-api</a>
 */
public class QuoteApi extends AbstractRestApi {

    /**
     * The standard quote API allows a quote for a single design printed on one
     * or more products, shipped to a single address.
     * 
     * @param quote
     * @return a quote response object.
     * @throws ScalablePressBadRequestException for invalid request or error occur during call.
     * @see <a href="https://scalablepress.com/docs/#standard-quote">https://scalablepress.com/docs/#standard-quote</a>
     */
    public QuoteResponse quote(Quote quote) throws ScalablePressBadRequestException {
        return post("quote", quote, QuoteResponse.class);
    }

    /**
     * The bulk quote API allows receiving quotes for printing multiple designs,
     * items, and shipping to multiple addresses. Discounts will automatically
     * be applied whenever possible.
     * 
     * The name property of each quote item accepts any string and can be used
     * for your reference.
     * 
     * @param bulkQuote
     * @return a quote response object.
     * @throws ScalablePressBadRequestException for invalid request or error occur during call.
     * @see <a href="https://scalablepress.com/docs/#bulk-quote">https://scalablepress.com/docs/#bulk-quote</a>
     */
    public QuoteResponse bulkQuote(BulkQuote bulkQuote) throws ScalablePressBadRequestException {
        return post("quote/bulk", bulkQuote, QuoteResponse.class);
    }
    
    /**
     * After you have made a successful order-ready quote, you will be provided with an orderToken. This order token can be used to retrieve the quote it is associated with.
     * @param orderToken
     * @return an order object.
     * @throws ScalablePressBadRequestException for invalid request or error occur during call.
     * @see <a href="https://scalablepress.com/docs/#retrieve-quote">https://scalablepress.com/docs/#retrieve-quote</a>
     */
    public Order retrieve(String orderToken) throws ScalablePressBadRequestException {
        return get("quote/" + orderToken, Order.class);
    }
}
