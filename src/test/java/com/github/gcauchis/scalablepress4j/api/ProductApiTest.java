/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2016-2019 Gabriel Cauchis
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

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.gcauchis.scalablepress4j.model.Category;
import com.github.gcauchis.scalablepress4j.model.Product;
import com.github.gcauchis.scalablepress4j.model.ProductAvailability;

/**
 * The Class ProductApiTest.
 */
class ProductApiTest extends AbstractApiTest {

    /** The product api. */
    private ProductApi productApi;

    /**
     * Inits the test.
     */
    @BeforeEach
    void init() {
        productApi = scalablePress.productApi();
    }

    /**
     * Test context.
     */
    @Test
    void context() {
        Assertions.assertNotNull(productApi);
    }

    /**
     * Test gets the categories.
     */
    @Test
    void getCategories() {
        List<Category> categories = productApi.getCategories();
        Assertions.assertNotNull(categories);
        log.info(categories.toString());
        Assertions.assertFalse(categories.isEmpty());
    }

    /**
     * Test gets the category products.
     */
    @Test
    void getCategoryProducts() {
        Category category = productApi.getCategoryProducts("short-sleeve-shirts");
        Assertions.assertNotNull(category);
        log.info(category.toString());
    }

    /**
     * Test gets the product information.
     */
    @Test
    void getProductInformation() {
        Product product = productApi.getProductInformation("gildan-ultra-cotton-t-shirt");
        Assertions.assertNotNull(product);
        log.info(product.toString());
    }

    /**
     * Test gets the product availability.
     */
    @Test
    void getProductAvailability() {
        ProductAvailability productAvailability = productApi.getProductAvailability("gildan-ultra-cotton-t-shirt");
        Assertions.assertNotNull(productAvailability);
        log.info(productAvailability.toString());
    }
}
