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
 * The Design json object
 * 
 * @author gcauchis
 * @see <a href="https://scalablepress.com/docs/#design-object">https://scalablepress.com/docs/#design-object</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Design {
    /** Optional reference name for design */
    private String name;
    /** Type of product this design is for. <code>screenprint</code>, <code>dtg</code>, <code>case</code>, <code>mug</code>, or <code>poster</code> */
    private String type;
    /** {@link DesignSides Design sides object} */
    private DesignSides sides;
    /** {@link DesignValidation Design validation object} */
    private DesignValidation validation;

    /**
     * Gets the Optional reference name for design.
     *
     * @return the Optional reference name for design
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the Optional reference name for design.
     *
     * @param name the new Optional reference name for design
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the Type of product this design is for. <code>screenprint</code>, <code>dtg</code>, <code>case</code>, <code>mug</code>, or <code>poster</code>.
     *
     * @return the Type of product this design is for. <code>screenprint</code>, <code>dtg</code>, <code>case</code>, <code>mug</code>, or <code>poster</code>
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the Type of product this design is for. <code>screenprint</code>, <code>dtg</code>, <code>case</code>, <code>mug</code>, or <code>poster</code>.
     *
     * @param type the new Type of product this design is for. <code>screenprint</code>, <code>dtg</code>, <code>case</code>, <code>mug</code>, or <code>poster</code>
     */
    public void setType(String type) {
        this.type = type;
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

    @Override
    public String toString() {
        return "Design [name=" + name + ", type=" + type + ", sides=" + sides
                + ", validation=" + validation + "]";
    }
}
