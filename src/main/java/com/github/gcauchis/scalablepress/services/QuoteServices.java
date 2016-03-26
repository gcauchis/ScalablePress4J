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

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.github.gcauchis.scalablepress.json.Address;
import com.github.gcauchis.scalablepress.json.BulkQuote;
import com.github.gcauchis.scalablepress.json.OrderProduct;
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
        return post("quote", quote, QuoteResponse.class);
//        Map<String, Object> urlVariables = new LinkedHashMap<>();
//        urlVariables.put("type", quote.getType());
//        List<OrderProduct> products = quote.getProducts();
//        if (products != null)
//        {
//            for (int i = 0; i < products.size() ; i++)
//            {
//                OrderProduct orderProduct = products.get(i);
//                urlVariables.put("products[" + i +"][id]", orderProduct.getId());
//                urlVariables.put("products[" + i +"][color]", orderProduct.getColor());
//                urlVariables.put("products[" + i +"][quantity]", orderProduct.getQuantity().intValue());
//                urlVariables.put("products[" + i +"][size]", orderProduct.getSize());
//            }
//        }
//        Address address = quote.getAddress();
//        urlVariables.put("address[name]", address.getName());
//        urlVariables.put("address[address1]", address.getAddress1());
//        urlVariables.put("address[city]", address.getCity());
//        urlVariables.put("address[state]", address.getState());
//        urlVariables.put("address[zip]", address.getZip().intValue());
//
//        urlVariables.put("designId", quote.getDesignId());
//        log.debug(urlVariables.toString());
//        return post("quote", QuoteResponse.class, urlVariables);
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
}
