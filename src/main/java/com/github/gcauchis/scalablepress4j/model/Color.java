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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The Color json object.
 * @author gcauchis
 * @see <a href="https://scalablepress.com/docs/#color-object">https://scalablepress.com/docs/#color-object</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Color {

    /** Name of the color */
    private String name;
    /** Hex color code of the color */
    private String hex;
    /** Array of {@link Image image objects} */
    private List<Image> image;
    /** Array of available sizes */
    private List<String> sizes;

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
     * Gets the Hex color code of the color.
     *
     * @return the Hex color code of the color
     */
    public String getHex() {
        return hex;
    }

    /**
     * Sets the Hex color code of the color.
     *
     * @param hex the new Hex color code of the color
     */
    public void setHex(String hex) {
        this.hex = hex;
    }

    /**
     * Gets the Array of {@link Image image objects}.
     *
     * @return the Array of {@link Image image objects}
     */
    public List<Image> getImage() {
        return image;
    }

    /**
     * Sets the Array of {@link Image image objects}.
     *
     * @param image the new Array of {@link Image image objects}
     */
    public void setImage(List<Image> image) {
        this.image = image;
    }

    /**
     * Gets the Array of available sizes.
     *
     * @return the Array of available sizes
     */
    public List<String> getSizes() {
        return sizes;
    }

    /**
     * Sets the Array of available sizes.
     *
     * @param sizes the new Array of available sizes
     */
    public void setSizes(List<String> sizes) {
        this.sizes = sizes;
    }

    @Override
    public String toString() {
        return "Color [name=" + name + ", hex=" + hex + ", image=" + image
                + ", sizes=" + sizes + "]";
    }
}
