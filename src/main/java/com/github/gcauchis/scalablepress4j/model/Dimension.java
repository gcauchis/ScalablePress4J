/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2016-2018 Gabriel Cauchis
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
 * The Dimension json object
 * 
 * @author gcauchis
 * @see <a href="https://scalablepress.com/docs/#dimension-object">https://scalablepress.com/docs/#dimension-object</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Dimension {
    /** <b>Screenprint/DTG/poster only</b>, width in inches of the print on the garment, or the width of the poster, specify this OR the height of the print */
    private Number width;
    /** <b>Screenprint/DTG/poster only</b>, height in inches of the print on the garment, or the height of the poster, specify this OR the width of the print */
    private Number height;

    /**
     * Gets the <b>Screenprint/DTG/poster only</b>, width in inches of the print on the garment, or the width of the poster, specify this OR the height of the print.
     *
     * @return the width in inches of the print on the garment, or the width of the poster, specify this OR the height of the print.
     */
    public Number getWidth() {
        return width;
    }

    /**
     * Sets the <b>Screenprint/DTG/poster only</b>, width in inches of the print on the garment, or the width of the poster, specify this OR the height of the print.
     *
     * @param width the new width in inches of the print on the garment, or the width of the poster, specify this OR the height of the print.
     */
    public void setWidth(Number width) {
        this.width = width;
    }

    /**
     * Gets the <b>Screenprint/DTG/poster only</b>, height in inches of the print on the garment, or the height of the poster, specify this OR the width of the print.
     *
     * @return the height in inches of the print on the garment, or the height of the poster, specify this OR the width of the print.
     */
    public Number getHeight() {
        return height;
    }

    /**
     * Sets the <b>Screenprint/DTG/poster only</b>, height in inches of the print on the garment, or the height of the poster, specify this OR the width of the print.
     *
     * @param height the new height in inches of the print on the garment, or the height of the poster, specify this OR the width of the print.
     */
    public void setHeight(Number height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Dimension [width=" + width + ", height=" + height + "]";
    }
}
