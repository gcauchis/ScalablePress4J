package com.github.gcauchis.scalablepress.services;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.gcauchis.scalablepress.json.Category;
import com.github.gcauchis.scalablepress.json.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ProductServices.class)
public class ProductServicesTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ProductServices productServices;

    @Test
    public void testContext() {
        Assert.assertNotNull(productServices);
    }

    @Test
    public void getCategories() {
        List<Category> categories = productServices.getCategories();
        Assert.assertNotNull(categories);
        log.info(categories.toString());
        Assert.assertFalse(categories.isEmpty());
    }

    @Test
    public void getCategoryProducts() {
        Category category = productServices
                .getCategoryProducts("short-sleeve-shirts");
        Assert.assertNotNull(category);
        log.info(category.toString());
    }

    @Test
    public void getProductInformation() {
        Product product = productServices
                .getProductInformation("gildan-ultra-cotton-t-shirt");
        Assert.assertNotNull(product);
        log.info(product.toString());
    }
}
