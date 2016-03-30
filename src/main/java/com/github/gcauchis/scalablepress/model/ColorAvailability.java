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
 * The Color Availability json object.
 * @author gcauchis
 * @see https://scalablepress.com/docs/#list-product-availability
 */
public class ColorAvailability {

    /** Name of the color */
    private String name;
    /** A map with the size as key and the number of availability as value */
    private Map<String, Integer> sizesAvailability;

    public ColorAvailability() {
        super();
    }

    public ColorAvailability(String name, Map<String, Object> sizesAvailability) {
        super();
        this.name = name;
        this.sizesAvailability = sizesAvailability.entrySet().stream()
                .collect(Collectors.toMap(e -> e.getKey(), e -> Integer.valueOf(e.getValue().toString())));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Integer> getSizesAvailability() {
        return sizesAvailability;
    }

    public void setSizesAvailability(Map<String, Integer> sizesAvailability) {
        this.sizesAvailability = sizesAvailability;
    }

    @Override
    public String toString() {
        return "ColorAvailability [name=" + name + ", sizesAvailability="
                + sizesAvailability + "]";
    }

}
