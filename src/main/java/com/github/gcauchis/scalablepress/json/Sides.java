package com.github.gcauchis.scalablepress.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The Sides json object
 * 
 * @author gcauchis
 * @see https://scalablepress.com/docs/#standard-quote
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sides {
    /**
     * DTG: set to any positive number to indicate printing on this side,
     * Screenprint: the number of colors used on this side
     */
    private Float front;
    /**
     * DTG: set to any positive number to indicate printing on this side,
     * Screenprint: the number of colors used on this side
     */
    private Float back;
    /**
     * DTG: set to any positive number to indicate printing on this side,
     * Screenprint: the number of colors used on this side
     */
    private Float right;
    /**
     * DTG: set to any positive number to indicate printing on this side,
     * Screenprint: the number of colors used on this side
     */
    private Float left;

    public Float getFront() {
        return front;
    }

    public void setFront(Float front) {
        this.front = front;
    }

    public Float getBack() {
        return back;
    }

    public void setBack(Float back) {
        this.back = back;
    }

    public Float getRight() {
        return right;
    }

    public void setRight(Float right) {
        this.right = right;
    }

    public Float getLeft() {
        return left;
    }

    public void setLeft(Float left) {
        this.left = left;
    }

    @Override
    public String toString() {
        return "Sides [front=" + front + ", back=" + back + ", right=" + right
                + ", left=" + left + "]";
    }
}
