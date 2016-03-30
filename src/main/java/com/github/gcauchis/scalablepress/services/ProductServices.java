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

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.github.gcauchis.scalablepress.model.Category;
import com.github.gcauchis.scalablepress.model.Product;
import com.github.gcauchis.scalablepress.model.ProductAvailability;
import com.github.gcauchis.scalablepress.model.ProductOveriew;

/**
 * Implement the Product api.
 * @author gcauchis
 * @see https://scalablepress.com/docs/#product-api
 */
@Service
public class ProductServices extends AbstractRestServices {
    
    /**
     * Get a list of available product categories.
     * The categories are not filled with the product, call {@link #getCategoryProducts(String)} the retrieve the {@link ProductOveriew}
     * @return an array with all available category objects.
     * @see https://scalablepress.com/docs/#list-product-categories
     */
    public List<Category> getCategories() {
        return Arrays.asList(get("categories", Category[].class));
    }
    
    /**
     * Specify a category id to receive category information and a list of products in that category
     * @param categoryId
     * @return a category object which now contains an array of product overview objects.
     * @see https://scalablepress.com/docs/#list-products
     */
    public Category getCategoryProducts(String categoryId) {
        return get("categories/" + categoryId, Category.class);
    }
    
    /**
     * Specify a product id to receive product information. 
     * @param productId
     * @return a product object.
     * @see https://scalablepress.com/docs/#list-product-information
     */
    public Product getProductInformation(String productId) {
        return get("products/" + productId, Product.class);
    }
    
    /**
     * Specify a product id to receive product availability information.
     * If a color/size combination is not specified then it is unavailable.
     * @param productId
     * @return a product availability object.
     * @see https://scalablepress.com/docs/#list-product-availability
     */
    public ProductAvailability getProductAvailability(String productId) {
        return new ProductAvailability((Map<String, Object>) get("products/" + productId + "/availability", Object.class));
    }
    
    /**
     * need authororized api key, postpone for now
     * @param productId
     * @param apiKey
     * @see https://scalablepress.com/docs/#list-detailed-item-information
     */
    private void getDetailedProductItemsInformation(String productId, String apiKey)
    {
    }
}
