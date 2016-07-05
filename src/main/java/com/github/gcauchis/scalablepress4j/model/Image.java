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

/**
 * The Image json object.
 * @author gcauchis
 * @see <a href="https://scalablepress.com/docs/#image-object">https://scalablepress.com/docs/#image-object</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Image {

    /** Type of image. */
    private String label;
    
    /** URL to the image. */
    private String url;

    /**
     * Gets the Type of image.
     *
     * @return the Type of image
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the Type of image.
     *
     * @param label the new Type of image
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Gets the URL to the image.
     *
     * @return the URL to the image
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the URL to the image.
     *
     * @param url the new URL to the image
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Image [label=" + label + ", url=" + url + "]";
    }
}
