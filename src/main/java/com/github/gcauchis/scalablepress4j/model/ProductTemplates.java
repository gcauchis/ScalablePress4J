/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2016-2017 Gabriel Cauchis
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
 * The Class ProductTemplates json object.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductTemplates {

    /** The front template name. */
    private String front;
    
    /** The back template name. */
    private String back;
    
    /** The left template name. */
    private String left;
    
    /** The right template name. */
    private String right;

    /**
     * Gets the front template name.
     *
     * @return the front template name
     */
    public String getFront() {
        return front;
    }

    /**
     * Sets the front template name.
     *
     * @param front the new front template name
     */
    public void setFront(String front) {
        this.front = front;
    }

    /**
     * Gets the back template name.
     *
     * @return the back template name
     */
    public String getBack() {
        return back;
    }

    /**
     * Sets the back template name.
     *
     * @param back the new back template name
     */
    public void setBack(String back) {
        this.back = back;
    }

    /**
     * Gets the left template name.
     *
     * @return the left template name
     */
    public String getLeft() {
        return left;
    }

    /**
     * Sets the left template name.
     *
     * @param left the new left template name
     */
    public void setLeft(String left) {
        this.left = left;
    }

    /**
     * Gets the right template name.
     *
     * @return the right template name
     */
    public String getRight() {
        return right;
    }

    /**
     * Sets the right template name.
     *
     * @param right the new right template name
     */
    public void setRight(String right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "ProductTemplate [front=" + front + ", back=" + back + ", left="
                + left + ", right=" + right + "]";
    }
}
