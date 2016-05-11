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
package com.github.gcauchis.scalablepress4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.gcauchis.scalablepress4j.api.AbstractRestApi;
import com.github.gcauchis.scalablepress4j.api.BillingApi;
import com.github.gcauchis.scalablepress4j.api.DesignApi;
import com.github.gcauchis.scalablepress4j.api.EventApi;
import com.github.gcauchis.scalablepress4j.api.OrderApi;
import com.github.gcauchis.scalablepress4j.api.ProductApi;
import com.github.gcauchis.scalablepress4j.api.QuoteApi;
import com.github.gcauchis.scalablepress4j.api.ReshipApi;

/**
 * The ScalablePress4J class is a Service who provide the Scalable Press APIs.
 */
@Service
public class ScalablePress4J {

    /** The Constant SCALABLE_PRESS_V2_BASE_URL. */
    public static final String SCALABLE_PRESS_V2_BASE_URL = "https://api.scalablepress.com/v2/";

    /** The Constant SCALABLE_PRESS_V3_BASE_URL. */
    public static final String SCALABLE_PRESS_V3_BASE_URL = "https://api.scalablepress.com/v3/";

    /** The basic auth */
    private String basicAuth;

    /** The billing. */
    private BillingApi billingApi;

    /** The design. */
    private DesignApi designApi;

    /** The event. */
    private EventApi eventApi;

    /** The order. */
    private OrderApi orderApi;

    /** The product. */
    private ProductApi productApi;

    /** The quote. */
    private QuoteApi quoteApi;

    /** The reship. */
    private ReshipApi reshipApi;

    /**
     * Sets the api authentication key.
     *
     * @param basicAuth
     *            the api authentication key.
     * @see https://scalablepress.com/docs/#authentication
     */
    @Value("${scalablepress.api.basicauth}")
    public void setBasicAuth(String basicAuth) {
        this.basicAuth = basicAuth;
        if (billingApi != null) {
            billingApi.setBasicAuth(basicAuth);
        }
        if (designApi != null) {
            designApi.setBasicAuth(basicAuth);
        }
        if (eventApi != null) {
            eventApi.setBasicAuth(basicAuth);
        }
        if (orderApi != null) {
            orderApi.setBasicAuth(basicAuth);
        }
        if (productApi != null) {
            productApi.setBasicAuth(basicAuth);
        }
        if (quoteApi != null) {
            quoteApi.setBasicAuth(basicAuth);
        }
        if (reshipApi != null) {
            reshipApi.setBasicAuth(basicAuth);
        }
    }

    private void prepareV2Api(AbstractRestApi service) {
        service.setBaseUrl(SCALABLE_PRESS_V2_BASE_URL);
        service.setBasicAuth(basicAuth);
    }

    private void prepareV3Api(AbstractRestApi service) {
        service.setBaseUrl(SCALABLE_PRESS_V3_BASE_URL);
        service.setBasicAuth(basicAuth);
    }

    /**
     * Retrieve the billing api.
     *
     * @return {@link BillingApi}
     */
    public BillingApi billingApi() {
        if (billingApi == null) {
            billingApi = new BillingApi();
            prepareV2Api(billingApi);
        }
        return billingApi;
    }

    /**
     * Retrieve the design api.
     *
     * @return {@link DesignApi}
     */
    public DesignApi designApi() {
        if (designApi == null) {
            designApi = new DesignApi();
            prepareV2Api(designApi);
        }
        return designApi;
    }

    /**
     * Retrieve the event api.
     *
     * @return {@link EventApi}
     */
    public EventApi eventApi() {
        if (eventApi == null) {
            eventApi = new EventApi();
            prepareV3Api(eventApi);
        }
        return eventApi;
    }

    /**
     * Retrieve the order api.
     *
     * @return {@link OrderApi}
     */
    public OrderApi orderApi() {
        if (orderApi == null) {
            orderApi = new OrderApi();
            prepareV2Api(orderApi);
        }
        return orderApi;
    }

    /**
     * Retrieve the product api.
     *
     * @return {@link ProductApi}
     */
    public ProductApi productApi() {
        if (productApi == null) {
            productApi = new ProductApi();
            prepareV2Api(productApi);
        }
        return productApi;
    }

    /**
     * Retrieve the quote api.
     *
     * @return {@link QuoteApi}
     */
    public QuoteApi quoteApi() {
        if (quoteApi == null) {
            quoteApi = new QuoteApi();
            prepareV2Api(quoteApi);
        }
        return quoteApi;
    }

    /**
     * Retrieve the reship api.
     *
     * @return {@link ReshipApi}
     */
    public ReshipApi reshipApi() {
        if (reshipApi == null) {
            reshipApi = new ReshipApi();
            prepareV2Api(reshipApi);
        }
        return reshipApi;
    }
}
