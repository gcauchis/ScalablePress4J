/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016-2023 Gabriel Cauchis
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

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The Event json object.
 *
 * @author gcauchis
 * @see <a href="https://scalablepress.com/docs/#event-object">https://scalablepress.com/docs/#event-object</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Event {
    /** Name of the event (quote, order, etc.) */
    private String name;
    /** Description of the event. */
    private String description;
    /** Optional additional data. <a href="https://scalablepress.com/docs/#order-status">Event examples</a> */
    private Map<String, Object> meta;
    /** Time at which the event occurred. */
    private String createdAt;

    /**
     * Gets the Name of the event (quote, order, etc.).
     *
     * @return the Name of the event
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the Name of the event (quote, order, etc.).
     *
     * @param name the new Name of the event
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the Description of the event.
     *
     * @return the Description of the event
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the Description of the event.
     *
     * @param description the new Description of the event
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the Optional additional data. <a href="https://scalablepress.com/docs/#order-status">Event examples</a>.
     *
     * @return the Optional additional data
     */
    public Map<String, Object> getMeta() {
        return meta;
    }

    /**
     * Sets the Optional additional data. <a href="https://scalablepress.com/docs/#order-status">Event examples</a>.
     *
     * @param meta the Optional additional data
     */
    public void setMeta(Map<String, Object> meta) {
        this.meta = meta;
    }

    /**
     * Gets the Time at which the event occurred.
     *
     * @return the Time at which the event occurred
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the Time at which the event occurred.
     *
     * @param createdAt the new Time at which the event occurred
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Event [name=" + name + ", description=" + description
                + ", meta=" + meta + ", createdAt=" + createdAt + "]";
    }
}
