package com.github.gcauchis.scalablepress.services;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.github.gcauchis.scalablepress.json.BulkQuote;
import com.github.gcauchis.scalablepress.json.Quote;
import com.github.gcauchis.scalablepress.json.QuoteResponse;

/**
 * implement the Quote api
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
        return post("quote", QuoteResponse.class, quote);
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
        return post("quote/bulk", QuoteResponse.class, bulkQuote);
    }
}
