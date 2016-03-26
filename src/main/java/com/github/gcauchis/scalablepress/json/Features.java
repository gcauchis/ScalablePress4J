package com.github.gcauchis.scalablepress.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The Feature json object
 * 
 * @author gcauchis
 * @see https://scalablepress.com/docs/#custom-order-features
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Features {

    /** Shipping service code. Available service codes */
    private String shipping;
    /** Absolute URL for a PDF packing slip */
    private String packing;

    public String getShipping() {
        return shipping;
    }

    public void setShipping(String shipping) {
        this.shipping = shipping;
    }

    public String getPacking() {
        return packing;
    }

    public void setPacking(String packing) {
        this.packing = packing;
    }

    @Override
    public String toString() {
        return "Features [shipping=" + shipping + ", packing=" + packing + "]";
    }
}
