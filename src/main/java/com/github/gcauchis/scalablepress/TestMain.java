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
package com.github.gcauchis.scalablepress;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.github.gcauchis.scalablepress.json.Address;
import com.github.gcauchis.scalablepress.json.Category;
import com.github.gcauchis.scalablepress.json.OrderProduct;
import com.github.gcauchis.scalablepress.json.Product;
import com.github.gcauchis.scalablepress.json.ProductAvailability;
import com.github.gcauchis.scalablepress.json.Quote;
import com.github.gcauchis.scalablepress.json.QuoteResponse;
import com.github.gcauchis.scalablepress.services.ProductServices;
import com.github.gcauchis.scalablepress.services.QuoteServices;

@SpringBootApplication
public class TestMain implements CommandLineRunner {

    private final Logger log = LoggerFactory.getLogger(TestMain.class);
    
    @Autowired
    private ProductServices productServices;
    
    @Autowired
    private QuoteServices quoteServices;
    
    public static void main(String[] args) {
        SpringApplication.run(TestMain.class, args);
    }
    
    @Override
    public void run(String... arg0) throws Exception {
        List<Category> categories = productServices.getCategories();
        log.info(categories.toString());
        Category category = categories.get(0);
        Category filledCategory = productServices.getCategoryProducts(category.getCategoryId());
        log.info(filledCategory.toString());
        Product product = productServices.getProductInformation(filledCategory.getProducts().get(0).getId());
        log.info(product.toString());
        ProductAvailability productAvailability = productServices.getProductAvailability(product.getProductId());
        log.info(productAvailability.toString());
        
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
        address.setZip(12345);
        quote.setAddress(address);
        quote.setDesignId("53ed3a23b3730f0e27a66513");
        QuoteResponse quoteResponse = quoteServices.quote(quote);
        log.info(quoteResponse.toString());
    }

}
