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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.gcauchis.scalablepress.model.Category;
import com.github.gcauchis.scalablepress.model.ColorSizesItem;
import com.github.gcauchis.scalablepress.model.ColorsItem;
import com.github.gcauchis.scalablepress.model.Product;
import com.github.gcauchis.scalablepress.model.ProductAvailability;
import com.github.gcauchis.scalablepress.model.ProductOveriew;
import com.github.gcauchis.scalablepress.model.Size;

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
     * Specify a product id to receive product information. For each color of the product, this information includes the following
     * WARNING: Item information requests output a large amount of data. As a result, an authorized API key is required to make this request. To authorize your API key, contact api@scalablepress.com.
     * @param productId
     * @see https://scalablepress.com/docs/#list-detailed-item-information
     */
    public ColorsItem getDetailedProductItemsInformation(String productId) {
        Map<String, Object> response = (Map<String, Object>) get("products/" + productId + "/items", Object.class);
        Map<String, ColorSizesItem> colorsItem = new LinkedHashMap<>();
        ObjectMapper mapper = getObjectMapper();
        for (Map.Entry<String, Object> entryResponse : response.entrySet()) {
            String color = entryResponse.getKey();
            Map<String, Object> colorSizes = (Map<String, Object>) entryResponse .getValue();
            Map<String, Size> colorSizesItem = new LinkedHashMap<>();
            for (Map.Entry<String, Object> entrySize : colorSizes.entrySet()) {
                colorSizesItem.put(entrySize.getKey(), mapper.convertValue(entrySize.getValue(), Size.class));
            }
            colorsItem.put(color, new ColorSizesItem(colorSizesItem));
        }
        return new ColorsItem(colorsItem);
    }
}
