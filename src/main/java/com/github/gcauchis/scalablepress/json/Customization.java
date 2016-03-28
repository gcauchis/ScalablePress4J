package com.github.gcauchis.scalablepress.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The Customization json object
 * @author gcauchis
 * @see https://scalablepress.com/docs/#create-design-object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customization {
    /** Name of the desired customization */
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customization [id=" + id + "]";
    }
}
