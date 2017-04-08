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
 * The Mockup json object.
 *
 * @author gcauchis
 * @see <a href="https://scalablepress.com/docs/#mockup-object">https://scalablepress.com/docs/#mockup-object</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Mockup {

    /** {@link Template Template object}. */
    private Template template;

    /** {@link MockupProduct Mockup product object}. */
    private MockupProduct product;

    /** {@link Design Design object}. */
    private Design design;

    /** {@link MockupOutput Mockup output object}. */
    private MockupOutput output;

    /**
     * Gets the {@link Template Template object}.
     *
     * @return the {@link Template Template object}
     */
    public Template getTemplate() {
        return template;
    }

    /**
     * Sets the {@link Template Template object}.
     *
     * @param template the new {@link Template Template object}
     */
    public void setTemplate(Template template) {
        this.template = template;
    }

    /**
     * Gets the {@link MockupProduct Mockup product object}.
     *
     * @return the {@link MockupProduct Mockup product object}
     */
    public MockupProduct getProduct() {
        return product;
    }

    /**
     * Sets the {@link MockupProduct Mockup product object}.
     *
     * @param product the new {@link MockupProduct Mockup product object}
     */
    public void setProduct(MockupProduct product) {
        this.product = product;
    }

    /**
     * Gets the {@link Design Design object}.
     *
     * @return the {@link Design Design object}
     */
    public Design getDesign() {
        return design;
    }

    /**
     * Sets the {@link Design Design object}.
     *
     * @param design the new {@link Design Design object}
     */
    public void setDesign(Design design) {
        this.design = design;
    }

    /**
     * Gets the {@link MockupOutput Mockup output object}.
     *
     * @return the {@link MockupOutput Mockup output object}
     */
    public MockupOutput getOutput() {
        return output;
    }

    /**
     * Sets the {@link MockupOutput Mockup output object}.
     *
     * @param output the new {@link MockupOutput Mockup output object}
     */
    public void setOutput(MockupOutput output) {
        this.output = output;
    }

    @Override
    public String toString() {
        return "Mockup [template=" + template + ", product=" + product + ", design=" + design + ", output=" + output + "]";
    }
}
