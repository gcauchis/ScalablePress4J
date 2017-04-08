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
 * The Position json object.
 *
 * @author gcauchis
 * @see <a href="https://scalablepress.com/docs/#position-object">https://scalablepress.com/docs/#position-object</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Position {
    /** <b>Screenprint/DTG only</b>, horizontal position. <a href="https://scalablepress.com/services#artwork_requirements">Artwork requirements</a>. */
    private String horizontal;

    /** <b>Screenprint/DTG only</b>, {@link PositionOffset position offset object}. */
    private PositionOffset offset;

    /**
     * Gets the <b>Screenprint/DTG only</b>, horizontal position. <a href="https://scalablepress.com/services#artwork_requirements">Artwork requirements</a>..
     *
     * @return the horizontal position
     */
    public String getHorizontal() {
        return horizontal;
    }

    /**
     * Sets the <b>Screenprint/DTG only</b>, horizontal position. <a href="https://scalablepress.com/services#artwork_requirements">Artwork requirements</a>..
     *
     * @param horizontal the new horizontal position
     */
    public void setHorizontal(String horizontal) {
        this.horizontal = horizontal;
    }

    /**
     * Gets the <b>Screenprint/DTG only</b>, {@link PositionOffset position offset object}.
     *
     * @return the {@link PositionOffset position offset object}
     */
    public PositionOffset getOffset() {
        return offset;
    }

    /**
     * Sets the <b>Screenprint/DTG only</b>, {@link PositionOffset position offset object}.
     *
     * @param offset the new {@link PositionOffset position offset object}
     */
    public void setOffset(PositionOffset offset) {
        this.offset = offset;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Position [horizontal=" + horizontal + ", offset=" + offset
                + "]";
    }
}
