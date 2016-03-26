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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The Position Offset json object
 * 
 * @author gcauchis
 * @see https://scalablepress.com/docs/#create-design-object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PositionOffset {
    /** top offset in inches, specify this OR the bottom offset of the print */
    private Number top;
    /** bottom offset in inches, specify this OR the top offset of the print */
    private Number bottom;

    public Number getTop() {
        return top;
    }

    public void setTop(Number top) {
        this.top = top;
    }

    public Number getBottom() {
        return bottom;
    }

    public void setBottom(Number bottom) {
        this.bottom = bottom;
    }

    @Override
    public String toString() {
        return "PositionOffset [top=" + top + ", bottom=" + bottom + "]";
    }
}
