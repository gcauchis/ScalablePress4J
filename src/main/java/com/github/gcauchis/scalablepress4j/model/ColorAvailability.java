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

import java.util.Map;
import java.util.stream.Collectors;

/**
 * The Color Availability json object.
 * @author gcauchis
 * @see <a href="https://scalablepress.com/docs/#color-availability-object">https://scalablepress.com/docs/#color-availability-object</a>
 */
public class ColorAvailability {

    /**  Name of the color. */
    private String name;
    
    /**  A map with the size as key and the number of availability as value. */
    private Map<String, Integer> sizesAvailability;

    /**
     * Instantiates a new color availability.
     */
    public ColorAvailability() {
        super();
    }

    /**
     * Instantiates a new color availability.
     *
     * @param name the name
     * @param sizesAvailability the sizes availability
     */
    public ColorAvailability(String name, Map<String, ?> sizesAvailability) {
        super();
        this.name = name;
        this.sizesAvailability = sizesAvailability.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> Integer.valueOf(e.getValue().toString())));
    }

    /**
     * Gets the Name of the color.
     *
     * @return the Name of the color
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the Name of the color.
     *
     * @param name the new Name of the color
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the A map with the size as key and the number of availability as value.
     *
     * @return the A map with the size as key and the number of availability as value
     */
    public Map<String, Integer> getSizesAvailability() {
        return sizesAvailability;
    }

    /**
     * Sets A map with the size as key and the number of availability as value.
     *
     * @param sizesAvailability A map with the size as key and the number of availability as value
     */
    public void setSizesAvailability(Map<String, Integer> sizesAvailability) {
        this.sizesAvailability = sizesAvailability;
    }

    @Override
    public String toString() {
        return "ColorAvailability [name=" + name + ", sizesAvailability="
                + sizesAvailability + "]";
    }

}
