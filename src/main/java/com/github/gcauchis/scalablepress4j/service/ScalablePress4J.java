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
package com.github.gcauchis.scalablepress4j.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * The ScalablePress4J class is a Service provider.
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
    private BillingService billing;

    /** The design. */
    private DesignService design;

    /** The event. */
    private EventService event;

    /** The order. */
    private OrderService order;

    /** The product. */
    private ProductService product;

    /** The quote. */
    private QuoteService quote;

    /** The reship. */
    private ReshipService reship;

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
        if (billing != null) {
            billing.setBasicAuth(basicAuth);
        }
        if (design != null) {
            design.setBasicAuth(basicAuth);
        }
        if (event != null) {
            event.setBasicAuth(basicAuth);
        }
        if (order != null) {
            order.setBasicAuth(basicAuth);
        }
        if (product != null) {
            product.setBasicAuth(basicAuth);
        }
        if (quote != null) {
            quote.setBasicAuth(basicAuth);
        }
        if (reship != null) {
            reship.setBasicAuth(basicAuth);
        }
    }

    private void prepareV2Service(AbstractRestService service) {
        service.setBaseUrl(SCALABLE_PRESS_V2_BASE_URL);
        service.setBasicAuth(basicAuth);
    }

    private void prepareV3Service(AbstractRestService service) {
        service.setBaseUrl(SCALABLE_PRESS_V3_BASE_URL);
        service.setBasicAuth(basicAuth);
    }

    /**
     * Retrieve the billing service.
     *
     * @return {@link BillingService}
     */
    public BillingService billing() {
        if (billing == null) {
            billing = new BillingService();
            prepareV2Service(billing);
        }
        return billing;
    }

    /**
     * Retrieve the design service.
     *
     * @return {@link DesignService}
     */
    public DesignService design() {
        if (design == null) {
            design = new DesignService();
            prepareV2Service(design);
        }
        return design;
    }

    /**
     * Retrieve the event service.
     *
     * @return {@link EventService}
     */
    public EventService event() {
        if (event == null) {
            event = new EventService();
            prepareV3Service(event);
        }
        return event;
    }

    /**
     * Retrieve the order service.
     *
     * @return {@link OrderService}
     */
    public OrderService order() {
        if (order == null) {
            order = new OrderService();
            prepareV2Service(order);
        }
        return order;
    }

    /**
     * Retrieve the product service.
     *
     * @return {@link ProductService}
     */
    public ProductService product() {
        if (product == null) {
            product = new ProductService();
            prepareV2Service(product);
        }
        return product;
    }

    /**
     * Retrieve the quote service.
     *
     * @return {@link QuoteService}
     */
    public QuoteService quote() {
        if (quote == null) {
            quote = new QuoteService();
            prepareV2Service(quote);
        }
        return quote;
    }

    /**
     * Retrieve the reship service.
     *
     * @return {@link ReshipService}
     */
    public ReshipService reship() {
        if (reship == null) {
            reship = new ReshipService();
            prepareV2Service(reship);
        }
        return reship;
    }
}
