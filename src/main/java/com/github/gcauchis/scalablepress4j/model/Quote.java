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
package com.github.gcauchis.scalablepress4j.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The Quote json object.
 *
 * @author gcauchis
 * @see <a href="https://scalablepress.com/docs/#quote-object">https://scalablepress.com/docs/#quote-object</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Quote {

    /** Type of product this design is for: <code>screenprint</code>, <code>dtg</code>, <code>case</code>, <code>mug</code>, or <code>poster</code>. */
    private String type;

    /** Unique identifier for a design object to print, provided by the Design API. */
    private String designId;

    /** Providing this optional {@link Sides sides object} instead of a designId allows making quotes without creating a Design first. */
    private Sides sides;

    /** Array of {@link OrderProduct order product objects} to print on. */
    private List<OrderProduct> products;

    /** Shipping {@link Address address object}. */
    private Address address;

    /** Custom {@link Features features object}. */
    private Features features;

    /** Optional reference name. */
    private String name;

    /**
     * Gets the Type of product this design is for: <code>screenprint</code>, <code>dtg</code>, <code>case</code>, <code>mug</code>, or <code>poster</code>.
     *
     * @return the Type of product
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the Type of product this design is for: <code>screenprint</code>, <code>dtg</code>, <code>case</code>, <code>mug</code>, or <code>poster</code>.
     *
     * @param type the new Type of product
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the Unique identifier for a design object to print, provided by the Design API.
     *
     * @return the Unique identifier for a design object to print, provided by the Design API
     */
    public String getDesignId() {
        return designId;
    }

    /**
     * Sets the Unique identifier for a design object to print, provided by the Design API.
     *
     * @param designId the new Unique identifier for a design object to print, provided by the Design API
     */
    public void setDesignId(String designId) {
        this.designId = designId;
    }

    /**
     * Gets the Providing this optional {@link Sides sides object} instead of a designId allows making quotes without creating a Design first.
     *
     * @return the optional {@link Sides sides object}
     */
    public Sides getSides() {
        return sides;
    }

    /**
     * Sets the Providing this optional {@link Sides sides object} instead of a designId allows making quotes without creating a Design first.
     *
     * @param sides the new optional {@link Sides sides object}
     */
    public void setSides(Sides sides) {
        this.sides = sides;
    }

    /**
     * Gets the Array of {@link OrderProduct order product objects} to print on.
     *
     * @return the Array of {@link OrderProduct order product objects} to print on
     */
    public List<OrderProduct> getProducts() {
        return products;
    }

    /**
     * Sets the Array of {@link OrderProduct order product objects} to print on.
     *
     * @param products the new Array of {@link OrderProduct order product objects} to print on
     */
    public void setProducts(List<OrderProduct> products) {
        this.products = products;
    }

    /**
     * Gets the Shipping {@link Address address object}.
     *
     * @return the Shipping {@link Address address object}
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the Shipping {@link Address address object}.
     *
     * @param address the new Shipping {@link Address address object}
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Gets the Custom {@link Features features object}.
     *
     * @return the Custom {@link Features features object}
     */
    public Features getFeatures() {
        return features;
    }

    /**
     * Sets the Custom {@link Features features object}.
     *
     * @param features the new Custom {@link Features features object}
     */
    public void setFeatures(Features features) {
        this.features = features;
    }

    /**
     * Gets the Optional reference name.
     *
     * @return the Optional reference name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the Optional reference name.
     *
     * @param name the new Optional reference name
     */
    public void setName(String name) {
        this.name = name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Quote [type=" + type + ", designId=" + designId + ", sides="
                + sides + ", products=" + products + ", address=" + address
                + ", features=" + features + ", name=" + name + "]";
    }
}
