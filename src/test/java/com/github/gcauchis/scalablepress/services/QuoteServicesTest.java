package com.github.gcauchis.scalablepress.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.github.gcauchis.scalablepress.json.Address;
import com.github.gcauchis.scalablepress.json.OrderProduct;
import com.github.gcauchis.scalablepress.json.Quote;
import com.github.gcauchis.scalablepress.json.QuoteResponse;
import com.github.gcauchis.scalablepress.test.PropertyTestConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {QuoteServices.class, PropertyTestConfiguration.class}, loader = AnnotationConfigContextLoader.class)
public class QuoteServicesTest {

private final Logger log = LoggerFactory.getLogger(getClass());
    
    @Autowired
    private QuoteServices quoteServices;
    
    @Test
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
        address.setZip(12345);
        quote.setAddress(address);
        quote.setDesignId("53ed3a23b3730f0e27a66513");
        QuoteResponse quoteResponse = quoteServices.quote(quote);
        Assert.assertNotNull(quoteResponse);
        log.info(quoteResponse.toString());
    }
}
