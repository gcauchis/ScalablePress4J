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

import com.github.gcauchis.scalablepress.model.Address;
import com.github.gcauchis.scalablepress.model.Order;
import com.github.gcauchis.scalablepress.model.OrderItem;
import com.github.gcauchis.scalablepress.model.QuoteResponse;

/**
 * The Order API lets you place an order, modify its details, and check the
 * status of a previously placed order. The Order API can also place, modify,
 * and check reship orders, or order that have been returned after being
 * shipped.
 * 
 * @author gcauchis
 * @see https://scalablepress.com/docs/#order-api
 */
@Service
public class OrderServices extends AbstractRestServices{

    /**
     * In order to place an order, you first must make a quote request. After a
     * successful quote request, you will be provided with a orderToken. This
     * order token can then be used to place an order.
     * 
     * @param orderToken
     * @return an order object.
     * @see https://scalablepress.com/docs/#place-order
     */
    public Order place(String orderToken) {
        Map<String, String> args = new LinkedHashMap<>();
        args.put("orderToken", orderToken);
        return post("order", args, Order.class);
    }

    /**
     * After placing an order, you can reprint any item in that order using the
     * orderId. Specify which item by passing in an item index. If you pass in a
     * new address, a new product, and/or new features, the new object will
     * replace the corresponding old object.
     * 
     * @param orderId
     * @param orderItems
     * @return a quote response object
     * @see https://scalablepress.com/docs/#reprint-order
     */
    public QuoteResponse reprint(String orderId, List<OrderItem> orderItems) {
        return post("order/" + orderId + "/reprint", orderItems.toArray(new OrderItem[orderItems.size()]), QuoteResponse.class);
    }
    
    /**
     * After placing several orders you can get the status and other information
     * on each of your orders.
     * 
     * @return an array of order objects.
     * @see https://scalablepress.com/docs/#retrieve-orders
     */
    public List<Order> retrieve() {
        return Arrays.asList(get("order", Order[].class));
    }
    
    /**
     * Once an order has been placed, you can check on the status and other
     * information of an order by using the orderId field provided in the order
     * object.
     * 
     * @param orderId
     * @return an order object.
     * @see https://scalablepress.com/docs/#retrieve-single-order
     */
    public Order retrieve(String orderId) {
        return get("order/" + orderId, Order.class);
    }
    
    /**
     * So long as an order’s status has been validated and is not cancelled or
     * shipping, an order’s shipping address can be changed using the orderId.
     * An order’s status and orderId can both be found in order object, which
     * can be accessed when you retrieve a single order.<br /> WARNING : Shipping
     * addresses cannot be changed between domestic and international.
     * 
     * @param orderId
     * @param itemIndex
     * @param newAddress
     * @return an order object with an additional event with a meta that
     *         documents the original and new to address
     * @see https://scalablepress.com/docs/#change-order-address
     */
    public Order changeAddress(String orderId, int itemIndex, Address newAddress) {
        Map<String, Object> args = new LinkedHashMap<>();
        args.put("itemIndex", itemIndex);
        args.put("address", newAddress);
        return post("order/" + orderId + "/changeAddress", args, Order.class);
    }
    
    /**
     * So long as an order’s status has not reached printing, you can cancel an
     * order by using the orderId. An order’s status and orderId can both be
     * found in order object, which can be accessed when you retrieve a single
     * order.
     * 
     * @param orderId
     * @return an order object with an deletedAt timestamp that records the time
     *         the order object was cancelled.
     * @see https://scalablepress.com/docs/#cancel-entire-order
     */
    public Order cancel(String orderId) {
        return delete("order/" + orderId, Order.class);
    }
}
