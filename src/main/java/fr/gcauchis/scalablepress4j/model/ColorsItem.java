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

import java.util.Map;

/**
 * The Color Items object.
 * 
 * @author gcauchis
 * @see https://scalablepress.com/docs/#list-detailed-item-information
 */
public class ColorsItem {
    /** The colors */
    private Map<String, ColorSizesItem> colors;

    public ColorsItem(Map<String, ColorSizesItem> colors) {
        super();
        this.colors = colors;
    }

    public Map<String, ColorSizesItem> getColors() {
        return colors;
    }

    public void setColors(Map<String, ColorSizesItem> colors) {
        this.colors = colors;
    }

    @Override
    public String toString() {
        return "ColorsItem [colors=" + colors + "]";
    }
}
