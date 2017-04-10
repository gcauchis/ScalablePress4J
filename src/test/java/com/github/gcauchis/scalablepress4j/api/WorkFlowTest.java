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

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.github.gcauchis.scalablepress4j.model.Address;
import com.github.gcauchis.scalablepress4j.model.Category;
import com.github.gcauchis.scalablepress4j.model.Color;
import com.github.gcauchis.scalablepress4j.model.ColorAvailability;
import com.github.gcauchis.scalablepress4j.model.Design;
import com.github.gcauchis.scalablepress4j.model.DesignResponse;
import com.github.gcauchis.scalablepress4j.model.Order;
import com.github.gcauchis.scalablepress4j.model.OrderProduct;
import com.github.gcauchis.scalablepress4j.model.Product;
import com.github.gcauchis.scalablepress4j.model.ProductAvailability;
import com.github.gcauchis.scalablepress4j.model.ProductOveriew;
import com.github.gcauchis.scalablepress4j.model.Quote;
import com.github.gcauchis.scalablepress4j.model.QuoteResponse;

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
    
    /** The mockup api. */
    private MockupApi mockupApi;

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
        mockupApi = scalablePress.mockupApi();
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
        Assert.assertNotNull(mockupApi);
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
        Category category = categories.stream().filter(c -> categoryId.equals(c.getCategoryId())).findFirst()
                .orElse(null);
        Assert.assertNotNull("category " + categoryId + " not found", category);
        Assert.assertEquals(categoryId, category.getCategoryId());
        Assert.assertNull(category.getProducts());
        log.info("### Category " + categoryId + " found");

        category = productApi.getCategoryProducts(categoryId);
        Assert.assertNotNull("category " + categoryId + " not found", category);
        Assert.assertNotNull(category.getProducts());
        Assert.assertEquals(categoryId, category.getCategoryId());
        log.info("Category products: {}", category);
        log.info("### Category products " + categoryId + " found");

        final String productId = "gildan-ultra-cotton-t-shirt";
        ProductOveriew productOveriew = category.getProducts().stream().filter(p -> productId.equals(p.getId()))
                .findFirst().orElse(null);
        Assert.assertNotNull("Product " + productId + " not found in category " + categoryId, productOveriew);
        Assert.assertEquals(productId, productOveriew.getId());
        log.info("### Product " + productId + " found");

        final Product productItem = productApi.getProductInformation(productId);
        Assert.assertNotNull("Product " + productId + " not found", productItem);
        Assert.assertEquals(productId, productItem.getProductId());
        log.info("Product: {}", productItem);
        Assert.assertTrue("Product " + productItem + " should be available",
                Boolean.parseBoolean(productItem.getAvailable()));
        log.info("### Product " + productId + " available");

        Assert.assertNotNull(productItem.getColors());
        final String productColorId = "black";
        final Color productColor = productItem.getColors().stream()
                .filter(c -> productColorId.equalsIgnoreCase(c.getName())).findFirst().orElse(null);
        Assert.assertNotNull("Color " + productColorId + " not found in product " + productId, productColor);
        log.info("### Color " + productColorId + " found in product " + productId);

        final String productColorSize = "xxl";
        Assert.assertNotNull(productColor.getSizes());
        Assert.assertTrue(
                "Size " + productColorSize + " not found in color " + productColorId + " for product " + productId,
                productColor.getSizes().stream().filter(s -> productColorSize.equals(s)).findFirst().isPresent());
        log.info("### Size " + productColorSize + " found in color " + productColorId + " for product " + productId);

        final ProductAvailability productAvailability = productApi.getProductAvailability(productId);
        Assert.assertNotNull(productAvailability);
        log.info("ProductAvailability: {}", productAvailability);
        Assert.assertNotNull(productAvailability.getColorsAvailability());
        final ColorAvailability colorAvailability = productAvailability.getColorsAvailability().get(productColorId);
        Assert.assertNotNull("Color " + productColorId + " not available", colorAvailability);
        Assert.assertNotNull(colorAvailability.getSizesAvailability());
        Assert.assertNotNull(colorAvailability.getSizesAvailability().get(productColorSize));
        Assert.assertTrue("Size " + productColorSize + " unavailable for color " + productColorId,
                colorAvailability.getSizesAvailability().get(productColorSize) > 0);
        log.info("### Size " + productColorSize + " available in color " + productColorId);

        Design designRequest = buildTestDesign();
        DesignResponse response = designApi.create(designRequest);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getDesignId());
        log.info("Design created: {} ", response.toString());
        log.info("Design created with designId = {}", response.getDesignId());
        final String designId = response.getDesignId();
        log.info("### Design created successfully with id " + designId);

        DesignResponse retieveDesign = designApi.retrieve(designId);
        Assert.assertNotNull(retieveDesign);
        Assert.assertEquals(designId, retieveDesign.getDesignId());
        log.info("Design retrieved: {} ", retieveDesign.toString());
        log.info("### Design retrieve successfully for id " + designId);

        Quote quote = new Quote();
        quote.setType("dtg");
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setId(productId);
        orderProduct.setColor(productColorId);
        orderProduct.setSize(productColorSize);
        orderProduct.setQuantity(1);
        quote.setProducts(Arrays.asList(orderProduct));
        Address address = new Address("My Customer", "123 Scalable Drive", "West Pressfield", "CA", "12345", null);
        quote.setAddress(address);
        quote.setDesignId(designId);

        QuoteResponse quoteResponse = quoteApi.quote(quote);
        Assert.assertNotNull(quoteResponse);
        log.info("QuoteResponse retrieved: {} ", quoteResponse.toString());
        String orderToken = quoteResponse.getOrderToken();
        Assert.assertNotNull(orderToken);
        log.info("### Quote successfuly posted with order token " + orderToken);

        Order retrieveOrder = quoteApi.retrieve(orderToken);
        Assert.assertNotNull(retrieveOrder);
        log.info("Order retrieved: {} ", retrieveOrder.toString());
        Assert.assertEquals(orderToken, retrieveOrder.getOrderToken());
        Assert.assertEquals("quote", retrieveOrder.getStatus());
        String orderId = retrieveOrder.getOrderId();
        log.info("### Order found for token " + orderToken);

        Order placedOrder = orderApi.place(orderToken);
        Assert.assertNotNull(placedOrder);
        log.info("Order placed: {} ", placedOrder.toString());
        Assert.assertEquals("order", placedOrder.getStatus());
        Assert.assertEquals(orderId, placedOrder.getOrderId());
        log.info("### Order placed for token " + orderToken);

        retrieveOrder = orderApi.retrieve(orderId);
        Assert.assertNotNull(retrieveOrder);
        log.info("Order retrieved: {} ", retrieveOrder.toString());
        Assert.assertEquals(orderToken, retrieveOrder.getOrderToken());
        Assert.assertEquals("order", retrieveOrder.getStatus());
        log.info("### Order found for id " + orderId);

        List<Order> currentOrders = orderApi.retrieve();
        Assert.assertNotNull(currentOrders);
        Assert.assertFalse(currentOrders.isEmpty());
        log.info("Current Orders: {} ", currentOrders.toString());

        for (Order orderToCancel : currentOrders) {
            if (!orderToCancel.getStatus().equals("cancelled")) {
                Order canceledOrder = orderApi.cancel(orderToCancel.getOrderId());
                log.info("Canceled order: {} ", canceledOrder.toString());
                Assert.assertEquals("cancelled", canceledOrder.getStatus());
                Assert.assertEquals(orderToCancel.getOrderId(), canceledOrder.getOrderId());
            }
        }

        // TODO Billing

        DesignResponse deleted = designApi.delete(designId);
        Assert.assertNotNull(deleted);
        Assert.assertEquals(designId, deleted.getDesignId());
        log.info("Deleted design: {} ", deleted.toString());
        log.info("### Design retrieve successfully for id " + designId);

        log.info("###################################################################################");
        log.info("################################ End workflow test ################################");
        log.info("###################################################################################");
    }
}
