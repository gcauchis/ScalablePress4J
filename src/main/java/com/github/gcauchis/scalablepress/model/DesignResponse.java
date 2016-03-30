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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The Design Response json object
 * 
 * @author gcauchis
 * @see https://scalablepress.com/docs/#retrieve-design-object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DesignResponse {
    /** the type of product this design is for. screenprint, dtg, case, or mug */
    private String type;
    /** Time when design was created */
    private String createdAt;
    /** Design validation object */
    private DesignValidation validation;
    /** Array of customization objects */
    private List<Customization> customization;
    /** Design sides object */
    private DesignSides sides;
    /** test or live */
    private String mode;
    /** unique design identifier */
    private String designId;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public DesignValidation getValidation() {
        return validation;
    }

    public void setValidation(DesignValidation validation) {
        this.validation = validation;
    }

    public List<Customization> getCustomization() {
        return customization;
    }

    public void setCustomization(List<Customization> customization) {
        this.customization = customization;
    }

    public DesignSides getSides() {
        return sides;
    }

    public void setSides(DesignSides sides) {
        this.sides = sides;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getDesignId() {
        return designId;
    }

    public void setDesignId(String designId) {
        this.designId = designId;
    }

    @Override
    public String toString() {
        return "DesignResponse [type=" + type + ", createdAt=" + createdAt
                + ", validation=" + validation + ", customization="
                + customization + ", sides=" + sides + ", mode=" + mode
                + ", designId=" + designId + "]";
    }
}
