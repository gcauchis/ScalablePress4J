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
package com.github.gcauchis.scalablepress.services;

import org.springframework.stereotype.Service;

import com.github.gcauchis.scalablepress.model.BulkQuote;
import com.github.gcauchis.scalablepress.model.Order;
import com.github.gcauchis.scalablepress.model.Quote;
import com.github.gcauchis.scalablepress.model.QuoteResponse;

/**
 * Implement the Quote api
 * 
 * @author gcauchis
 * @see https://scalablepress.com/docs/#quote-api
 */
@Service
public class QuoteServices extends AbstractRestServices {

    /**
     * The standard quote API allows a quote for a single design printed on one
     * or more products, shipped to a single address.
     * 
     * @param quote
     * @return a quote response object.
     * @see https://scalablepress.com/docs/#standard-quote
     */
    public QuoteResponse quote(Quote quote) {
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
     * @see https://scalablepress.com/docs/#bulk-quote
     */
    public QuoteResponse bulkQuote(BulkQuote bulkQuote) {
        return post("quote/bulk", bulkQuote, QuoteResponse.class);
    }
    
    /**
     * After you have made a successful order-ready quote, you will be provided with an orderToken. This order token can be used to retrieve the quote it is associated with.
     * @param orderToken
     * @return an order object.
     * @see https://scalablepress.com/docs/#retrieve-quote
     */
    public Order retreive(String orderToken) {
        return get("quote/" + orderToken, Order.class);
    }
}
