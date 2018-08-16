/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2016-2018 Gabriel Cauchis
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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.gcauchis.scalablepress4j.ScalablePressBadRequestException;
import com.github.gcauchis.scalablepress4j.model.Category;
import com.github.gcauchis.scalablepress4j.model.ColorSizesItem;
import com.github.gcauchis.scalablepress4j.model.ColorsItem;
import com.github.gcauchis.scalablepress4j.model.Product;
import com.github.gcauchis.scalablepress4j.model.ProductAvailability;
import com.github.gcauchis.scalablepress4j.model.ProductOveriew;
import com.github.gcauchis.scalablepress4j.model.Size;

/**
 * The Products API provides specifications and pictures of all products
 * available for printing.
 * 
 * The Product API powers product catalog
 * 
 * @author gcauchis
 * @see <a href="https://scalablepress.com/docs/#product-api">https://scalablepress.com/docs/#product-api</a>
 */
public class ProductApi extends AbstractRestApi {

    /** The Constant URL_PRODUCTS. */
    private static final String URL_PRODUCTS = "products";

    /** The Constant URL_CATEGORIES. */
    private static final String URL_CATEGORIES = "categories";

    /**
     * Get a list of available product categories.
     * The categories are not filled with the product, call {@link #getCategoryProducts(String)} the retrieve the {@link ProductOveriew}
     * 
     * @return an array with all available {@link Category category objects}
     * @throws ScalablePressBadRequestException for invalid request or error occur during call.
     * @see <a href="https://scalablepress.com/docs/#list-product-categories">https://scalablepress.com/docs/#list-product-categories</a>
     */
    public List<Category> getCategories() {
        return Arrays.asList(get(URL_CATEGORIES, Category[].class));
    }

    /**
     * Specify a category id to receive category information and a list of products in that category
     * 
     * @param categoryId the categoryId
     * @return a {@link Category category object} which now contains an array of product overview objects.
     * @throws ScalablePressBadRequestException for invalid request or error occur during call.
     * @see <a href="https://scalablepress.com/docs/#list-products">https://scalablepress.com/docs/#list-products</a>
     */
    public Category getCategoryProducts(String categoryId) {
        return get(buildUrl(URL_CATEGORIES, categoryId), Category.class);
    }

    /**
     * Specify a product id to receive product information.
     * 
     * @param productId the productId
     * @return a {@link Product product object}
     * @throws ScalablePressBadRequestException for invalid request or error occur during call.
     * @see <a href="https://scalablepress.com/docs/#list-product-information">https://scalablepress.com/docs/#list-product-information</a>
     */
    public Product getProductInformation(String productId) {
        return get(buildUrl(URL_PRODUCTS, productId), Product.class);
    }

    /**
     * Specify a product id to receive product availability information.
     * If a color/size combination is not specified then it is unavailable.
     * 
     * @param productId the productId
     * @return a {@link ProductAvailability product availability object}
     * @throws ScalablePressBadRequestException for invalid request or error occur during call.
     * @see <a href="https://scalablepress.com/docs/#list-product-availability">https://scalablepress.com/docs/#list-product-availability</a>
     */
    @SuppressWarnings("unchecked")
    public ProductAvailability getProductAvailability(String productId) {
        return new ProductAvailability((Map<String, ?>) get(buildUrl(URL_PRODUCTS, productId, "availability"), Object.class));
    }

    /**
     * Specify a product id to receive product information. For each color of the product, this information includes the following
     * WARNING: Item information requests output a large amount of data. As a result, an authorized API key is required to make this request. To authorize your
     * API key, contact api@scalablepress.com.
     *
     * @param productId the productId
     * @return the {@link ColorsItem detailed product items information}
     * @throws ScalablePressBadRequestException for invalid request or error occur during call.
     * @see <a href="https://scalablepress.com/docs/#list-detailed-item-information">https://scalablepress.com/docs/#list-detailed-item-information</a>
     */
    @SuppressWarnings("unchecked")
    public ColorsItem getDetailedProductItemsInformation(String productId) {
        Map<String, ?> response = (Map<String, ?>) get(buildUrl(URL_PRODUCTS, productId, "items"), Object.class);
        Map<String, ColorSizesItem> colorsItem = new LinkedHashMap<>();
        ObjectMapper mapper = getObjectMapper();
        for (Map.Entry<String, ?> entryResponse : response.entrySet()) {
            String color = entryResponse.getKey();
            Map<String, ?> colorSizes = (Map<String, ?>) entryResponse.getValue();
            Map<String, Size> colorSizesItem = new LinkedHashMap<>();
            for (Map.Entry<String, ?> entrySize : colorSizes.entrySet()) {
                colorSizesItem.put(entrySize.getKey(), mapper.convertValue(entrySize.getValue(), Size.class));
            }
            colorsItem.put(color, new ColorSizesItem(colorSizesItem));
        }
        return new ColorsItem(colorsItem);
    }
}
