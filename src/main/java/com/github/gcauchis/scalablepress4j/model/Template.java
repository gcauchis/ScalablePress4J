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
 * The Template json object.
 * 
 * @author gcauchis
 * @see <a href= "https://scalablepress.com/docs/#template-object">https://scalablepress.com/docs/#template-object</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Template {

    /**
     * Name of the mockup template. <a href="https://scalablepress.com/docs/#available-products">See available products</a> for possible templates
     * 
     * @see <a href="https://scalablepress.com/docs/#available-products">See available products</a>
     */
    private String name;

    /**
     * Name of the background. <a href="https://scalablepress.com/docs/#available-backgrounds">See available backgrounds</a>
     * 
     * @see <a href="https://scalablepress.com/docs/#available-backgrounds">See available backgrounds</a>
     */
    private String background;

    /**
     * Gets the Name of the mockup template.
     *
     * @return the Name of the mockup template
     * 
     * @see <a href="https://scalablepress.com/docs/#available-products">See available products</a>
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the Name of the mockup template.
     *
     * @param name the new Name of the mockup template
     * 
     * @see <a href="https://scalablepress.com/docs/#available-products">See available products</a>
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the Name of the background.
     *
     * @return the Name of the background
     * 
     * @see <a href="https://scalablepress.com/docs/#available-backgrounds">See available backgrounds</a>
     */
    public String getBackground() {
        return background;
    }

    /**
     * Sets the Name of the background.
     *
     * @param background the new Name of the background
     * 
     * @see <a href="https://scalablepress.com/docs/#available-backgrounds">See available backgrounds</a>
     */
    public void setBackground(String background) {
        this.background = background;
    }

    @Override
    public String toString() {
        return "Template [name=" + name + ", background=" + background + "]";
    }

}
