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

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.github.gcauchis.scalablepress4j.model.Category;
import com.github.gcauchis.scalablepress4j.model.Color;
import com.github.gcauchis.scalablepress4j.model.ColorAvailability;
import com.github.gcauchis.scalablepress4j.model.Design;
import com.github.gcauchis.scalablepress4j.model.DesignResponse;
import com.github.gcauchis.scalablepress4j.model.Product;
import com.github.gcauchis.scalablepress4j.model.ProductAvailability;
import com.github.gcauchis.scalablepress4j.model.ProductOveriew;

/**
 * The Class WorkFlowTest.
 */
public class WorkFlowTest extends AbstractApiTest {

    /** The billing api. */
    private BillingApi billingApi;
    
    /** The design api. */
    private DesignApi designApi;
    
    /** The event api. */
    private EventApi eventApi;
    
    /** The order api. */
    private OrderApi orderApi;
    
    /** The product api. */
    private ProductApi productApi;
    
    /** The quote api. */
    private QuoteApi quoteApi;
    
    /** The reship api. */
    private ReshipApi reshipApi;

    /**
     * Inits the test.
     */
    @Before
    public void init() {
        billingApi = scalablePress.billingApi();
        designApi = scalablePress.designApi();
        orderApi = scalablePress.orderApi();
        eventApi = scalablePress.eventApi();
        productApi = scalablePress.productApi();
        quoteApi = scalablePress.quoteApi();
        reshipApi = scalablePress.reshipApi();
    }

    /**
     * Test context.
     */
    @Test
    public void context() {
        Assert.assertNotNull(billingApi);
        Assert.assertNotNull(designApi);
        Assert.assertNotNull(orderApi);
        Assert.assertNotNull(eventApi);
        Assert.assertNotNull(productApi);
        Assert.assertNotNull(quoteApi);
        Assert.assertNotNull(reshipApi);
    }

    /**
     * Workflow test.
     */
    @Test
    public void workflow() {
        log.info("###################################################################################");
        log.info("############################### Start workflow test ###############################");
        log.info("###################################################################################");
        final List<Category> categories = productApi.getCategories();
        Assert.assertNotNull(categories);
        Assert.assertFalse(categories.isEmpty());
        log.info("Categories: {}", categories.toString());

        final String categoryId = "short-sleeve-shirts";
        Category category = categories.stream().filter(c -> categoryId.equals(c.getCategoryId())).findFirst().orElse(null);
        Assert.assertNotNull("category " + categoryId + " not found", category);
        Assert.assertEquals(categoryId, category.getCategoryId());
        Assert.assertNull(category.getProducts());

        category = productApi.getCategoryProducts(categoryId);
        Assert.assertNotNull("category " + categoryId + " not found", category);
        Assert.assertNotNull(category.getProducts());
        Assert.assertEquals(categoryId, category.getCategoryId());
        log.info("Category products: {}", category);

        final String productId = "gildan-ultra-cotton-t-shirt";
        ProductOveriew productOveriew = category.getProducts().stream().filter(p -> productId.equals(p.getId())).findFirst().orElse(null);
        Assert.assertNotNull("Product " + productId + " not found in category " + categoryId, productOveriew);
        Assert.assertEquals(productId, productOveriew.getId());

        final Product productItem = productApi.getProductInformation(productId);
        Assert.assertNotNull("Product " + productId + " not found", productItem);
        Assert.assertEquals(productId, productItem.getProductId());
        log.info("Product: {}", productItem);
        Assert.assertTrue("Product " + productItem + " should be available", Boolean.parseBoolean(productItem.getAvailable()));

        Assert.assertNotNull(productItem.getColors());
        final String productColorId = "black";
        final Color productColor = productItem.getColors().stream().filter(c -> productColorId.equalsIgnoreCase(c.getName())).findFirst().orElse(null);
        Assert.assertNotNull("Color " + productColorId + " not found in product " + productId, productColor);

        final String productColorSize = "xxl";
        Assert.assertNotNull(productColor.getSizes());
        Assert.assertTrue("Size " + productColorSize + " not fond in color " + productColorId + " of product " + productId, productColor.getSizes().stream().filter(s -> productColorSize.equals(s)).findFirst().isPresent());
        
        final ProductAvailability productAvailability = productApi.getProductAvailability(productId);
        Assert.assertNotNull(productAvailability);
        log.info("ProductAvailability: {}", productAvailability);
        Assert.assertNotNull(productAvailability.getColorsAvailability());
        final ColorAvailability colorAvailability = productAvailability.getColorsAvailability().get(productColorId);
        Assert.assertNotNull("Color " + productColorId + " not available", colorAvailability);
        Assert.assertNotNull(colorAvailability.getSizesAvailability());
        Assert.assertNotNull(colorAvailability.getSizesAvailability().get(productColorSize));
        Assert.assertTrue("Size " + productColorSize + " unavailable for color " + productColorId, colorAvailability.getSizesAvailability().get(productColorSize) > 0);
        
        Design designRequest = buildTestDesign();
        DesignResponse response = designApi.create(designRequest);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getDesignId());
        log.info("Design created: {} ",response.toString());
        log.info("Design created with designId = {}", response.getDesignId());
        final String designId = response.getDesignId();
        
        DesignResponse retieveDesign = designApi.retrieve(designId);
        Assert.assertNotNull(retieveDesign);
        Assert.assertEquals(designId, retieveDesign.getDesignId());
        log.info("Design retrieved: {} ", retieveDesign.toString());
        
        // TODO: make order, quotes, billing... 
        
        
        
        
        
        
        
        
        
        DesignResponse deleted = designApi.delete(designId);
        Assert.assertNotNull(deleted);
        Assert.assertEquals(designId, deleted.getDesignId());
        log.info("Deleted design: {} ", deleted.toString());
        
        log.info("###################################################################################");
        log.info("################################ End workflow test ################################");
        log.info("###################################################################################");
    }
}
