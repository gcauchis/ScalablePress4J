/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2016-2018 Gabriel Cauchis
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
 * The Sides json object.
 *
 * @author gcauchis
 * @see <a href="https://scalablepress.com/docs/#sides-object">https://scalablepress.com/docs/#sides-object</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Sides {
    
    /** <b>DTG</b>: set to any positive number to indicate printing on the front,<br /> <b>Screenprint</b>: the number of colors used on the front. */
    private Integer front;
    
    /** <b>DTG</b>: set to any positive number to indicate printing on the back,<br /> <b>Screenprint</b>: the number of colors used on the back. */
    private Integer back;
    
    /** <b>DTG</b>: set to any positive number to indicate printing on the right,<br /> <b>Screenprint</b>: the number of colors used on the right. */
    private Integer right;
    
    /** <b>DTG</b>: set to any positive number to indicate printing on the left,<br /> <b>Screenprint</b>: the number of colors used on the left. */
    private Integer left;

    /**
     * Gets the <br /><b>DTG</b>: set to any positive number to indicate printing on the front,<br /> <b>Screenprint</b>: the number of colors used on the front.
     *
     * @return the front
     */
    public Integer getFront() {
        return front;
    }

    /**
     * Sets the <br /><b>DTG</b>: set to any positive number to indicate printing on the front,<br /> <b>Screenprint</b>: the number of colors used on the front.
     *
     * @param front the new front
     */
    public void setFront(Integer front) {
        this.front = front;
    }

    /**
     * Gets the <br /><b>DTG</b>: set to any positive number to indicate printing on the back,<br /> <b>Screenprint</b>: the number of colors used on the back.
     *
     * @return the back
     */
    public Integer getBack() {
        return back;
    }

    /**
     * Sets the <br /><b>DTG</b>: set to any positive number to indicate printing on the back,<br /> <b>Screenprint</b>: the number of colors used on the back.
     *
     * @param back the new back
     */
    public void setBack(Integer back) {
        this.back = back;
    }

    /**
     * Gets the <br /> <b>DTG</b>: set to any positive number to indicate printing on the right,<br /> <b>Screenprint</b>: the number of colors used on the right.
     *
     * @return the right
     */
    public Integer getRight() {
        return right;
    }

    /**
     * Sets the <br /> <b>DTG</b>: set to any positive number to indicate printing on the right,<br /> <b>Screenprint</b>: the number of colors used on the right.
     *
     * @param right the new right
     */
    public void setRight(Integer right) {
        this.right = right;
    }

    /**
     * Gets the <br /> <b>DTG</b>: set to any positive number to indicate printing on the left,<br /> <b>Screenprint</b>: the number of colors used on the left.
     *
     * @return the left
     */
    public Integer getLeft() {
        return left;
    }

    /**
     * Sets the <br /> <b>DTG</b>: set to any positive number to indicate printing on the left,<br /> <b>Screenprint</b>: the number of colors used on the left.
     *
     * @param left the new left
     */
    public void setLeft(Integer left) {
        this.left = left;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Sides [front=" + front + ", back=" + back + ", right=" + right
                + ", left=" + left + "]";
    }
}
