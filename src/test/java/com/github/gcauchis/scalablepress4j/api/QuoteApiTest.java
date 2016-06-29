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

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.github.gcauchis.scalablepress4j.ScalablePressBadRequestException;
import com.github.gcauchis.scalablepress4j.model.Address;
import com.github.gcauchis.scalablepress4j.model.Features;
import com.github.gcauchis.scalablepress4j.model.OrderProduct;
import com.github.gcauchis.scalablepress4j.model.Quote;
import com.github.gcauchis.scalablepress4j.model.QuoteResponse;
import com.github.gcauchis.scalablepress4j.model.Sides;

/**
 * The Class QuoteApiTest.
 */
public class QuoteApiTest  extends AbstractApiTest{

    /** The quote api. */
    private QuoteApi quoteApi;

    /**
     * Inits the test.
     */
    @Before
    public void init() {
        quoteApi = scalablePress.quoteApi();
    }

    /**
     * Test context.
     */
    @Test
    public void context() {
        Assert.assertNotNull(quoteApi);
    }

    /**
     * Test quote.
     */
    //Invalid designId : found a valid one for testing
    @Test(expected = ScalablePressBadRequestException.class)
    public void quote()
    {
        Quote quote = new Quote();
        quote.setType("dtg");
        List<OrderProduct> products = new ArrayList<>();
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setId("gildan-sweatshirt-crew");
        orderProduct.setColor("ash");
        orderProduct.setQuantity(12);
        orderProduct.setSize("lrg");
        products.add(orderProduct);
        quote.setProducts(products);
        Address address = new Address();
        address.setName("My Customer");
        address.setAddress1("123 Scalable Drive");
        address.setCity("West Pressfield");
        address.setState("CA");
        address.setZip("12345");
        quote.setAddress(address);
        quote.setDesignId("53ed3a23b3730f0e27a66513");
        Sides sides = new Sides();
        sides.setFront(1);
        quote.setSides(sides);
        Features features = new Features();
        features.setShipping("US-STD");
        quote.setFeatures(features);
        QuoteResponse quoteResponse = quoteApi.quote(quote);
        Assert.assertNotNull(quoteResponse);
        log.info(quoteResponse.toString());
    }
}
