package com.github.gcauchis.scalablepress4j.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The Class ProductTemplate json object.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductTemplate {

    /** The front template name. */
    private String front;
    
    /** The back template name. */
    private String back;
    
    /** The left template name. */
    private String left;
    
    /** The right template name. */
    private String right;

    /**
     * Gets the front template name.
     *
     * @return the front template name
     */
    public String getFront() {
        return front;
    }

    /**
     * Sets the front template name.
     *
     * @param front the new front template name
     */
    public void setFront(String front) {
        this.front = front;
    }

    /**
     * Gets the back template name.
     *
     * @return the back template name
     */
    public String getBack() {
        return back;
    }

    /**
     * Sets the back template name.
     *
     * @param back the new back template name
     */
    public void setBack(String back) {
        this.back = back;
    }

    /**
     * Gets the left template name.
     *
     * @return the left template name
     */
    public String getLeft() {
        return left;
    }

    /**
     * Sets the left template name.
     *
     * @param left the new left template name
     */
    public void setLeft(String left) {
        this.left = left;
    }

    /**
     * Gets the right template name.
     *
     * @return the right template name
     */
    public String getRight() {
        return right;
    }

    /**
     * Sets the right template name.
     *
     * @param right the new right template name
     */
    public void setRight(String right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "ProductTemplate [front=" + front + ", back=" + back + ", left="
                + left + ", right=" + right + "]";
    }
}
