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
package com.github.gcauchis.scalablepress4j.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The MockupOutput json object.
 *
 * @author gcauchis
 * @see <a href="https://scalablepress.com/docs/#mockup-output-object">https://scalablepress.com/docs/#mockup-output-object</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MockupOutput {

    /** Width of the output image in pixels. */
    private Integer width;

    /** Height of the output image in pixels. */
    private Integer height;

    /** Minimum padding between the mockup and the image border in pixels. */
    private Integer padding;

    /** Format of the output image, supported formats are: <code>png</code>, <code>jpg<code>. */
    private String format;

    /**
     * Gets the Width of the output image in pixels.
     *
     * @return the Width of the output image in pixels
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * Sets the Width of the output image in pixels.
     *
     * @param width the new Width of the output image in pixels
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     * Gets the Height of the output image in pixels.
     *
     * @return the Height of the output image in pixels
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * Sets the Height of the output image in pixels.
     *
     * @param height the new Height of the output image in pixels
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * Gets the Minimum padding between the mockup and the image border in pixels.
     *
     * @return the Minimum padding between the mockup and the image border in pixels
     */
    public Integer getPadding() {
        return padding;
    }

    /**
     * Sets the Minimum padding between the mockup and the image border in pixels.
     *
     * @param padding the new Minimum padding between the mockup and the image border in pixels
     */
    public void setPadding(Integer padding) {
        this.padding = padding;
    }

    /**
     * Gets the Format of the output image, supported formats are: <code>png</code>, <code>jpg<code>.
     *
     * @return the Format of the output image
     */
    public String getFormat() {
        return format;
    }

    /**
     * Sets the Format of the output image, supported formats are: <code>png</code>, <code>jpg<code>.
     *
     * @param format the new Format of the output image
     */
    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "MockupOutput [width=" + width + ", height=" + height + ", padding=" + padding + ", format=" + format + "]";
    }

}
