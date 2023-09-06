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

import java.util.Map;

/**
 * The Color Items object.
 * 
 * @author gcauchis
 * @see <a href="https://scalablepress.com/docs/#list-detailed-item-information">https://scalablepress.com/docs/#list-detailed-item-information</a>
 */
public class ColorSizesItem {
    /** The color sizes */
    private Map<String, Size> sizes;

    /**
     * Instantiates a new color sizes item.
     */
    public ColorSizesItem() {
        super();
    }

    /**
     * Instantiates a new color sizes item.
     *
     * @param sizes the sizes
     */
    public ColorSizesItem(Map<String, Size> sizes) {
        this.sizes = sizes;
    }

    /**
     * Gets the sizes.
     *
     * @return the sizes
     */
    public Map<String, Size> getSizes() {
        return sizes;
    }

    /**
     * Sets the sizes.
     *
     * @param sizes the sizes
     */
    public void setSizes(Map<String, Size> sizes) {
        this.sizes = sizes;
    }

    @Override
    public String toString() {
        return "ColorSizesItem [sizes=" + sizes + "]";
    }
}
