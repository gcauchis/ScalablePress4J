/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2016-2017 Gabriel Cauchis
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
 * The Design Side json object
 * 
 * @author gcauchis
 * @see <a href="https://scalablepress.com/docs/#design-side-object">https://scalablepress.com/docs/#design-side-object</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DesignSide {
    /** Artwork file or absolute URL for this side of the design. <a href="https://scalablepress.com/services#artwork_requirements">Artwork requirements</a> */
    private String artwork;
    /** Optional proof image file or absolute URL showing position of artwork on the product, used by our artists to make sure the print dimensions and position are as intended */
    private String proof;
    /** Aspect ratio */
    private Number aspect;
    /** Boolean checking if design should be resized */
    private Boolean resize;
    /** <b>Screenprint only</b>, list of each named color or PMS color used in design. <a href="https://scalablepress.com/services#artwork_requirements">Artwork requirements</a> */
    private List<String> colors;
    /** <b>Screenprint/DTG/poster only</b>, {@link Dimension dimension object} */
    private Dimension dimensions;
    /** <b>Screenprint/DTG only</b>, {@link Position position object} */
    private Position position;

    /**
     * Gets the Artwork file or absolute URL for this side of the design. <a href="https://scalablepress.com/services#artwork_requirements">Artwork requirements</a>.
     *
     * @return the Artwork file or absolute URL for this side of the design
     */
    public String getArtwork() {
        return artwork;
    }

    /**
     * Sets the Artwork file or absolute URL for this side of the design. <a href="https://scalablepress.com/services#artwork_requirements">Artwork requirements</a>.
     *
     * @param artwork the new Artwork file or absolute URL for this side of the design
     */
    public void setArtwork(String artwork) {
        this.artwork = artwork;
    }

    /**
     * Gets the Optional proof image file or absolute URL showing position of artwork on the product, used by our artists to make sure the print dimensions and position are as intended.
     *
     * @return the Optional proof image file or absolute
     */
    public String getProof() {
        return proof;
    }

    /**
     * Sets the Optional proof image file or absolute URL showing position of artwork on the product, used by our artists to make sure the print dimensions and position are as intended.
     *
     * @param proof the new Optional proof image file or absolute
     */
    public void setProof(String proof) {
        this.proof = proof;
    }

    /**
     * Gets the Aspect ratio.
     *
     * @return the Aspect ratio
     */
    public Number getAspect() {
        return aspect;
    }

    /**
     * Sets the Aspect ratio.
     *
     * @param aspect the new Aspect ratio
     */
    public void setAspect(Number aspect) {
        this.aspect = aspect;
    }

    /**
     * Gets the Boolean checking if design should be resized.
     *
     * @return the Boolean checking if design should be resized
     */
    public Boolean getResize() {
        return resize;
    }

    /**
     * Sets the Boolean checking if design should be resized.
     *
     * @param resize the new Boolean checking if design should be resized
     */
    public void setResize(Boolean resize) {
        this.resize = resize;
    }

    /**
     * Gets the <b>Screenprint only</b>, list of each named color or PMS color used in design. <a href="https://scalablepress.com/services#artwork_requirements">Artwork requirements</a>.
     *
     * @return the list of each named color or PMS color used in design
     */
    public List<String> getColors() {
        return colors;
    }

    /**
     * Sets the <b>Screenprint only</b>, list of each named color or PMS color used in design. <a href="https://scalablepress.com/services#artwork_requirements">Artwork requirements</a>.
     *
     * @param colors the new list of each named color or PMS color used in design
     */
    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    /**
     * Gets the <b>Screenprint/DTG/poster only</b>, {@link Dimension dimension object}.
     *
     * @return the {@link Dimension dimension object}
     */
    public Dimension getDimensions() {
        return dimensions;
    }

    /**
     * Sets the <b>Screenprint/DTG/poster only</b>, {@link Dimension dimension object}.
     *
     * @param dimensions the new {@link Dimension dimension object}
     */
    public void setDimensions(Dimension dimensions) {
        this.dimensions = dimensions;
    }

    /**
     * Gets the <b>Screenprint/DTG only</b>, {@link Position position object}.
     *
     * @return the {@link Position position object}
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Sets the <b>Screenprint/DTG only</b>, {@link Position position object}.
     *
     * @param position the new {@link Position position object}
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "DesignSide [artwork=" + artwork + ", proof=" + proof
                + ", aspect=" + aspect + ", resize=" + resize + ", colors="
                + colors + ", dimensions=" + dimensions + ", position="
                + position + "]";
    }
}
