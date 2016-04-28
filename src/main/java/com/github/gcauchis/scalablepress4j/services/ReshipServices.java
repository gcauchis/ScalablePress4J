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
package com.github.gcauchis.scalablepress4j.services;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.github.gcauchis.scalablepress4j.model.Address;
import com.github.gcauchis.scalablepress4j.model.Reship;

/**
 * Reship API
 * 
 * @author gcauchis
 * @see https://scalablepress.com/docs/#reship-api
 */
@Service
public class ReshipServices extends AbstractRestServices {

    /**
     * You can get the status and other information on all orders that have been
     * shipped and returned.
     * 
     * @return Array of reship objects
     * @see https://scalablepress.com/docs/#retrieve-reship-orders
     */
    public List<Reship> retrieve() {
        return Arrays.asList(get("reship", Reship[].class));
    }

    /**
     * The status and other information of an order that has been returned after
     * shipping can be checked using the reshipId field, which is accessible
     * through retrieving all reship orders.
     * 
     * @param reshipId
     * @return a reship object
     * @see https://scalablepress.com/docs/#retrieve-single-reship-order
     */
    public Reship retrieve(String reshipId) {
        return get("reship/" + reshipId, Reship.class);
    }

    /**
     * A returned item can be requested to be reshipped using the address field
     * to input a new address object and the reshipId. Requesting a reship will
     * cost additional shipping and will only be made if your account balance
     * has the required funds.
     * 
     * @param reshipId
     * @param address
     * @return
     * @see https://scalablepress.com/docs/#place-reship-order
     */
    public Reship place(String reshipId, Address address) {
        Map<String, Object> args = new LinkedHashMap<>();
        args.put("address", address);
        return post("reship/" + reshipId + "/request", args, Reship.class);
    }

    /**
     * A reship request can be cancelled using the unique identifier, reshipId.
     * This will revert the order status to returned and your account will be
     * refunded the additional shipping charge.
     * 
     * @param reshipId
     * @return
     * @see https://scalablepress.com/docs/#cancel-reship-order
     */
    public Reship cancel(String reshipId) {
        return post("reship/" + reshipId + "/cancel", null, Reship.class);
    }
}
