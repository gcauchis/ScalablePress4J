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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The Design Response json object
 * 
 * @author gcauchis
 * @see https://scalablepress.com/docs/#retrieve-design-object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DesignResponse {
    /** the type of product this design is for. <code>screenprint</code>, <code>dtg</code>, <code>case</code>, <code>mug</code>, or <code>poster</code> */
    private String type;
    /** Time when design was created */
    private String createdAt;
    /** Time when design was deleted */
    private String deletedAt;
    /** {@link DesignValidation Design validation object} */
    private DesignValidation validation;
    /** Array of {@link Customization customization objects} */
    private List<Customization> customization;
    /** {@link DesignSides Design sides object} */
    private DesignSides sides;
    /** <code>test</code> or <code>live</code> */
    private String mode;
    /** unique design identifier */
    private String designId;

    /**
     * Gets the type of product this design is for. <code>screenprint</code>, <code>dtg</code>, <code>case</code>, <code>mug</code>, or <code>poster</code>.
     *
     * @return the type of product this design is for. <code>screenprint</code>, <code>dtg</code>, <code>case</code>, <code>mug</code>, or <code>poster</code>
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of product this design is for. <code>screenprint</code>, <code>dtg</code>, <code>case</code>, <code>mug</code>, or <code>poster</code>.
     *
     * @param type the new type of product this design is for. <code>screenprint</code>, <code>dtg</code>, <code>case</code>, <code>mug</code>, or <code>poster</code>
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the Time when design was created.
     *
     * @return the Time when design was created
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the Time when design was created.
     *
     * @param createdAt the new Time when design was created
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets the Time when design was deleted.
     *
     * @return the Time when design was deleted
     */
    public String getDeletedAt() {
        return deletedAt;
    }

    /**
     * Sets the Time when design was deleted.
     *
     * @param deletedAt the new Time when design was deleted
     */
    public void setDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt;
    }

    /**
     * Gets the {@link DesignValidation Design validation object}.
     *
     * @return the {@link DesignValidation Design validation object}
     */
    public DesignValidation getValidation() {
        return validation;
    }

    /**
     * Sets the {@link DesignValidation Design validation object}.
     *
     * @param validation the new {@link DesignValidation Design validation object}
     */
    public void setValidation(DesignValidation validation) {
        this.validation = validation;
    }

    /**
     * Gets the Array of {@link Customization customization objects}.
     *
     * @return the Array of {@link Customization customization objects}
     */
    public List<Customization> getCustomization() {
        return customization;
    }

    /**
     * Sets the Array of {@link Customization customization objects}.
     *
     * @param customization the new Array of {@link Customization customization objects}
     */
    public void setCustomization(List<Customization> customization) {
        this.customization = customization;
    }

    /**
     * Gets the {@link DesignSides Design sides object}.
     *
     * @return the {@link DesignSides Design sides object}
     */
    public DesignSides getSides() {
        return sides;
    }

    /**
     * Sets the {@link DesignSides Design sides object}.
     *
     * @param sides the new {@link DesignSides Design sides object}
     */
    public void setSides(DesignSides sides) {
        this.sides = sides;
    }

    /**
     * Gets the mode <code>test</code> or <code>live</code>.
     *
     * @return the mode <code>test</code> or <code>live</code>
     */
    public String getMode() {
        return mode;
    }

    /**
     * Sets the mode <code>test</code> or <code>live</code>.
     *
     * @param mode the new mode <code>test</code> or <code>live</code>
     */
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * Gets the unique design identifier.
     *
     * @return the unique design identifier
     */
    public String getDesignId() {
        return designId;
    }

    /**
     * Sets the unique design identifier
     *
     * @param designId the new unique design identifier
     */
    public void setDesignId(String designId) {
        this.designId = designId;
    }

    @Override
    public String toString() {
        return "DesignResponse [type=" + type + ", createdAt=" + createdAt
                + ", deletedAt=" + deletedAt + ", validation=" + validation
                + ", customization=" + customization + ", sides=" + sides
                + ", mode=" + mode + ", designId=" + designId + "]";
    }
}
