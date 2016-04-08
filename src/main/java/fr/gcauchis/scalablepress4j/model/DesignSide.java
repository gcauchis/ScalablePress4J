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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The Design Side json object
 * 
 * @author gcauchis
 * @see https://scalablepress.com/docs/#create-design-object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DesignSide {
    /**
     * Artwork file or absolute URL for this side of the design. <a href="https://scalablepress.com/services#artwork_requirements">Artwork requirements</a>
     */
    private String artwork;
    /**
     * Optional proof image file or absolute URL showing position of artwork on
     * the product, used by our artists to make sure the print dimensions and
     * position are as intended
     */
    private String proof;
    /** Aspect ratio */
    private Number aspect;
    /** Boolean checking if design should be resized */
    private Boolean resize;
    /**
     * Screenprint only, list of each named color or PMS color used in design.
     * <a href="https://scalablepress.com/services#artwork_requirements">Artwork requirements</a>
     */
    private List<String> colors;
    /** Screenprint/DTG only, dimension object */
    private Dimension dimensions;
    /** Screenprint/DTG only, position object */
    private Position position;

    public String getArtwork() {
        return artwork;
    }

    public void setArtwork(String artwork) {
        this.artwork = artwork;
    }

    public String getProof() {
        return proof;
    }

    public void setProof(String proof) {
        this.proof = proof;
    }

    public Number getAspect() {
        return aspect;
    }

    public void setAspect(Number aspect) {
        this.aspect = aspect;
    }

    public Boolean getResize() {
        return resize;
    }

    public void setResize(Boolean resize) {
        this.resize = resize;
    }

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    public Dimension getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimension dimensions) {
        this.dimensions = dimensions;
    }

    public Position getPosition() {
        return position;
    }

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
