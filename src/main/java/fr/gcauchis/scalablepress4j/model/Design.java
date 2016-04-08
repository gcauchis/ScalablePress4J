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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The Design json object
 * 
 * @author gcauchis
 * @see https://scalablepress.com/docs/#create-design-object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Design {
    /** Optional reference name for design */
    private String name;
    /** Type of product this design is for. screenprint, dtg, case, or mug */
    private String type;
    /** Design sides object */
    private DesignSides sides;
    /** Design validation object */
    private DesignValidation validation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public DesignSides getSides() {
        return sides;
    }

    public void setSides(DesignSides sides) {
        this.sides = sides;
    }

    public DesignValidation getValidation() {
        return validation;
    }

    public void setValidation(DesignValidation validation) {
        this.validation = validation;
    }

    @Override
    public String toString() {
        return "Design [name=" + name + ", type=" + type + ", sides=" + sides
                + ", validation=" + validation + "]";
    }
}
