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
package com.github.gcauchis.scalablepress.json;

/**
 * The Query
 * 
 * @author gcauchis
 * @see https://scalablepress.com/docs/#query-events
 */
public class QueryEvent {
    /** ID of an order. When given, only events of that order will be returned */
    private String orderId;
    /**
     * Event name. When given, only events with the provided name will be
     * returned
     */
    private String name;
    /**
     * Lower bound cutoff time. When given, only events after the provided date
     * will be returned. Date must be formatted <a
     * href="http://www.w3.org/TR/NOTE-datetime">ISO 8601</a>
     */
    private String start;
    /**
     * Upper bound cutoff time. When given, only events after the provided date
     * will be returned. Date must be formatted <a
     * href="http://www.w3.org/TR/NOTE-datetime">ISO 8601</a>
     */
    private String end;
    /**
     * Index of an order item. When given, only events of this item index will
     * be returned.
     */
    private String itemIndex;
    /**
     * Name of an order item. When given, only events of items with this name
     * will be returned
     */
    private String itemName;
    /**
     * Sort direction of the return result. Accepted values are ‘createdAt’ and
     * ‘-createdAt’, for ascending and descending event dates, respectively.
     */
    private String sort;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getItemIndex() {
        return itemIndex;
    }

    public void setItemIndex(String itemIndex) {
        this.itemIndex = itemIndex;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "QueryEvent [orderId=" + orderId + ", name=" + name + ", start="
                + start + ", end=" + end + ", itemIndex=" + itemIndex
                + ", itemName=" + itemName + ", sort=" + sort + "]";
    }
}
