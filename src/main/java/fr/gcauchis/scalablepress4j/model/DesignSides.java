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
package fr.gcauchis.scalablepress4j.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The Design Sides json object
 * 
 * @author gcauchis
 * @see https://scalablepress.com/docs/#create-design-object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DesignSides {

    /** Design side object */
    private DesignSide front;
    /** Design side object */
    private DesignSide back;
    /** Design side object */
    private DesignSide left;
    /** Design side object */
    private DesignSide right;

    public DesignSide getFront() {
        return front;
    }

    public void setFront(DesignSide front) {
        this.front = front;
    }

    public DesignSide getBack() {
        return back;
    }

    public void setBack(DesignSide back) {
        this.back = back;
    }

    public DesignSide getLeft() {
        return left;
    }

    public void setLeft(DesignSide left) {
        this.left = left;
    }

    public DesignSide getRight() {
        return right;
    }

    public void setRight(DesignSide right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "DesignSides [front=" + front + ", back=" + back + ", left="
                + left + ", right=" + right + "]";
    }
}
