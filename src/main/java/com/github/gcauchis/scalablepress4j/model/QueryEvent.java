/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2016-2019 Gabriel Cauchis
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
 * The Query.
 *
 * @author gcauchis
 * @see <a href="https://scalablepress.com/docs/#query-events">https://scalablepress.com/docs/#query-events</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QueryEvent {
    /** ID of an order. When given, only events of that order will be returned */
    private String orderId;
    /** Event name. When given, only events with the provided name will be returned */
    private String name;
    /** Lower bound cutoff time. When given, only events after the provided date will be returned. Date must be formatted <a href="http://www.w3.org/TR/NOTE-datetime">ISO 8601</a> */
    private String start;
    /** Upper bound cutoff time. When given, only events after the provided date will be returned. Date must be formatted <a href="http://www.w3.org/TR/NOTE-datetime">ISO 8601</a> */
    private String end;
    /** Index of an order item. When given, only events of this item index will be returned. */
    private String itemIndex;
    /** Name of an order item. When given, only events of items with this name will be returned */
    private String itemName;
    /** Sort direction of the return result. Accepted values are <code>createdAt</code> and <code>-createdAt</code>, for ascending and descending event dates, respectively. */
    private String sort;

    /**
     * Gets the ID of an order. When given, only events of that order will be returned.
     *
     * @return the ID of an order
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * Sets the ID of an order. When given, only events of that order will be returned.
     *
     * @param orderId the new ID of an order
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * Gets the Event name. When given, only events with the provided name will be returned.
     *
     * @return the Event name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the Event name. When given, only events with the provided name will be returned.
     *
     * @param name the new Event name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the Lower bound cutoff time. When given, only events after the provided date will be returned. Date must be formatted <a href="http://www.w3.org/TR/NOTE-datetime">ISO 8601</a>.
     *
     * @return the Lower bound cutoff time
     */
    public String getStart() {
        return start;
    }

    /**
     * Sets the Lower bound cutoff time. When given, only events after the provided date will be returned. Date must be formatted <a href="http://www.w3.org/TR/NOTE-datetime">ISO 8601</a>.
     *
     * @param start the new Lower bound cutoff time
     */
    public void setStart(String start) {
        this.start = start;
    }

    /**
     * Gets the Upper bound cutoff time. When given, only events after the provided date will be returned. Date must be formatted <a href="http://www.w3.org/TR/NOTE-datetime">ISO 8601</a>.
     *
     * @return the Upper bound cutoff time
     */
    public String getEnd() {
        return end;
    }

    /**
     * Sets the Upper bound cutoff time. When given, only events after the provided date will be returned. Date must be formatted <a href="http://www.w3.org/TR/NOTE-datetime">ISO 8601</a>.
     *
     * @param end the new Upper bound cutoff time
     */
    public void setEnd(String end) {
        this.end = end;
    }

    /**
     * Gets the Index of an order item. When given, only events of this item index will be returned.
     *
     * @return the Index of an order item
     */
    public String getItemIndex() {
        return itemIndex;
    }

    /**
     * Sets the Index of an order item. When given, only events of this item index will be returned.
     *
     * @param itemIndex the new Index of an order item
     */
    public void setItemIndex(String itemIndex) {
        this.itemIndex = itemIndex;
    }

    /**
     * Gets the Name of an order item. When given, only events of items with this name will be returned.
     *
     * @return the Name of an order item
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Sets the Name of an order item. When given, only events of items with this name will be returned.
     *
     * @param itemName the new Name of an order item
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * Gets the Sort direction of the return result. Accepted values are <code>createdAt</code> and <code>-createdAt</code>, for ascending and descending event dates, respectively.
     *
     * @return the Sort direction of the return result
     */
    public String getSort() {
        return sort;
    }

    /**
     * Sets the Sort direction of the return result. Accepted values are <code>createdAt</code> and <code>-createdAt</code>, for ascending and descending event dates, respectively.
     *
     * @param sort the new Sort direction of the return result
     */
    public void setSort(String sort) {
        this.sort = sort;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "QueryEvent [orderId=" + orderId + ", name=" + name + ", start="
                + start + ", end=" + end + ", itemIndex=" + itemIndex
                + ", itemName=" + itemName + ", sort=" + sort + "]";
    }
}
