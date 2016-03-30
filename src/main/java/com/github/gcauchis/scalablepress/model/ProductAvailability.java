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
package com.github.gcauchis.scalablepress.model;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * The Product Availability json object.
 * @author gcauchis
 * @see https://scalablepress.com/docs/#list-product-availability
 */
public class ProductAvailability {

    /** A map with the color name as key and the color sizes availability as value */
    private Map<String, ColorAvailability> colorsAvailability;

    public Map<String, ColorAvailability> getColorsAvailability() {
        return colorsAvailability;
    }

    public ProductAvailability() {
        super();
    }

    public ProductAvailability(Map<String, Object> colorsAvailability) {
        super();
        this.colorsAvailability = colorsAvailability.entrySet().stream()
                .collect(Collectors.toMap(e -> e.getKey(), e -> new ColorAvailability(e.getKey(), (Map<String, Object>) e.getValue())));
    }

    public void setColorsAvailability(
            Map<String, ColorAvailability> colorsAvailability) {
        this.colorsAvailability = colorsAvailability;
    }

    @Override
    public String toString() {
        return "ProductAvailability [colorsAvailability=" + colorsAvailability
                + "]";
    }
}
