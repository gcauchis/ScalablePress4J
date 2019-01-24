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

/**
 * The Class PaginatedResult.
 *
 * @param <R> the generic type
 */
public class PaginatedResult<R> {

    /** The result. */
    private R result;
    /** The current page number. */
    private int pageNumber;
    /** Total number of pages for this query. */
    private int pagesCount;
    /** Total number of items of the query. */
    private int itemsCount;
    /** Items per page. Defaults to 50. */
    private int limit;

    /**
     * Gets the result.
     *
     * @return the result
     */
    public R getResult() {
        return result;
    }

    /**
     * Sets the result.
     *
     * @param result the new result
     */
    public void setResult(R result) {
        this.result = result;
    }

    /**
     * Gets the current page number.
     *
     * @return the current page number
     */
    public int getPageNumber() {
        return pageNumber;
    }

    /**
     * Sets the current page number.
     *
     * @param pageNumber the new current page number
     */
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    /**
     * Gets the Total number of pages for this query.
     *
     * @return the Total number of pages for this query
     */
    public int getPagesCount() {
        return pagesCount;
    }

    /**
     * Sets the Total number of pages for this query.
     *
     * @param pagesCount the new Total number of pages for this query
     */
    public void setPagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
    }

    /**
     * Gets the Total number of items of the query.
     *
     * @return the Total number of items of the query
     */
    public int getItemsCount() {
        return itemsCount;
    }

    /**
     * Sets the Total number of items of the query.
     *
     * @param itemsCount the new Total number of items of the query
     */
    public void setItemsCount(int itemsCount) {
        this.itemsCount = itemsCount;
    }

    /**
     * Gets the Items per page. Defaults to 50.
     *
     * @return the Items per page
     */
    public int getLimit() {
        return limit;
    }

    /**
     * Sets the Items per page. Defaults to 50.
     *
     * @param limit the new Items per page
     */
    public void setLimit(int limit) {
        this.limit = limit;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "PaginatedResult [result=" + result + ", pageNumber="
                + pageNumber + ", pagesCount=" + pagesCount + ", itemsCount="
                + itemsCount + ", limit=" + limit + "]";
    }

}
