package com.github.gcauchis.scalablepress.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.gcauchis.scalablepress.json.Category;
import com.github.gcauchis.scalablepress.json.Product;
import com.github.gcauchis.scalablepress.json.ProductOveriew;

@Service
public class ProductServices extends AbstractRestServices {
    
    private static final String SCALABLE_PRESS_API_BASE_URL = "https://api.scalablepress.com/v2/";

    /**
     * Get a list of available product categories.
     * The categories are not filled with the product, call {@link #getCategoryProducts(String)} the retrieve the {@link ProductOveriew}
     * @return an array with all available category objects.
     */
    public List<Category> getCategories()
    {
        return Arrays.asList(getForObjectArray(SCALABLE_PRESS_API_BASE_URL + "categories", Category[].class));
    }
    
    /**
     * Specify a category id to receive category information and a list of products in that category
     * @param categoryId
     * @return a category object which now contains an array of product overview objects.
     */
    public Category getCategoryProducts(String categoryId) {
        return getForObject(SCALABLE_PRESS_API_BASE_URL + "categories/" + categoryId, Category.class);
    }
    
    /**
     * Specify a product id to receive product information. 
     * @param productId
     * @return a product object.
     */
    public Product getProductInformation(String productId)
    {
        return getForObject(SCALABLE_PRESS_API_BASE_URL + "products/" + productId, Product.class);
    }
}
