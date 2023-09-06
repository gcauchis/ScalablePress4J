/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016-2023 Gabriel Cauchis
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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The Address json Object
 * 
 * @author gcauchis
 * @see <a href="https://scalablepress.com/docs/#address-object">https://scalablepress.com/docs/#address-object</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address {
    /** Name of customer receiving the product */
    private String name;
    /** Optional company associated with the customer */
    private String company;
    /** Address line 1 of customer */
    private String address1;
    /** Optional address line 2 of customer */
    private String address2;
    /** City of customer */
    private String city;
    /** State or province where customer resides */
    private String state;
    /** Zip code or postal code of customer */
    private String zip;
    /** <a href="https://www.iso.org/obp/ui/#search">ISO3166 country code</a>, defaults to <code>US</code> */
    private String country = "US";

    /**
     * Instantiates a new address.
     */
    public Address() {
        super();
    }

    /**
     * Instantiates a new address.
     *
     * @param name the Name of customer receiving the product
     * @param address1 the Address line 1 of customer
     * @param city the City of customer
     * @param state the State or province where customer resides
     * @param zip the Zip code or postal code of customer
     * @param country the <a href="https://www.iso.org/obp/ui/#search">ISO3166 country code</a>, defaults to US
     */
    public Address(String name, String address1, String city, String state,
            String zip, String country) {
        this.name = name;
        this.address1 = address1;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
    }

    /**
     * Instantiates a new address.
     *
     * @param name the Name of customer receiving the product
     * @param address1 the Address line 1 of customer
     * @param address2 the Optional address line 2 of customer
     * @param city the City of customer
     * @param state the State or province where customer resides
     * @param zip the Zip code or postal code of customer
     * @param country the <a href="https://www.iso.org/obp/ui/#search">ISO3166 country code</a>, defaults to US
     */
    public Address(String name, String address1, String address2, String city,
            String state, String zip, String country) {
        super();
        this.name = name;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
    }

    /**
     * Gets Name of customer receiving the product .
     *
     * @return Name of customer receiving the product 
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the Name of customer receiving the product .
     *
     * @param name the new Name of customer receiving the product 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets Optional company associated with the customer.
     *
     * @return Optional company associated with the customer
     */
    public String getCompany() {
        return company;
    }

    /**
     * Sets the Optional company associated with the customer.
     *
     * @param company the new Optional company associated with the customer
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * Gets the Address line 1 of customer.
     *
     * @return the Address line 1 of customer
     */
    public String getAddress1() {
        return address1;
    }

    /**
     * Sets the Address line 1 of customer.
     *
     * @param address1 the new Address line 1 of customer
     */
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    /**
     * Gets the Optional address line 2 of customer.
     *
     * @return the Optional address line 2 of customer
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * Sets the Optional address line 2 of customer.
     *
     * @param address2 the new Optional address line 2 of customer
     */
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    /**
     * Gets the City of customer.
     *
     * @return the City of customer
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the City of customer.
     *
     * @param city the new City of customer
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the State or province where customer resides.
     *
     * @return the State or province where customer resides
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the State or province where customer resides.
     *
     * @param state the new State or province where customer resides
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets the Zip code or postal code of customer.
     *
     * @return the Zip code or postal code of customer
     */
    public String getZip() {
        return zip;
    }

    /**
     * Sets the Zip code or postal code of customer.
     *
     * @param zip the new Zip code or postal code of customer
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * Gets the <a href="https://www.iso.org/obp/ui/#search">ISO3166 country code</a>, defaults to <code>US</code>.
     *
     * @return the <a href="https://www.iso.org/obp/ui/#search">ISO3166 country code</a>, defaults to <code>US</code>
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the <a href="https://www.iso.org/obp/ui/#search">ISO3166 country code</a>, defaults to <code>US</code>.
     *
     * @param country the new <a href="https://www.iso.org/obp/ui/#search">ISO3166 country code</a>, defaults to <code>US</code>
     */
    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address [name=" + name + ", company=" + company + ", address1="
                + address1 + ", address2=" + address2 + ", city=" + city
                + ", state=" + state + ", zip=" + zip + ", country=" + country
                + "]";
    }
}
