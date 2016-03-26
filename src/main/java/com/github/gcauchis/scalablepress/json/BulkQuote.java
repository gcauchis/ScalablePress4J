package com.github.gcauchis.scalablepress.json;

import java.util.List;

/**
 * The Bulk Quote json object.
 * @author gcauchis
 * @see https://scalablepress.com/docs/#bulk-quote
 */
public class BulkQuote {
    /** Array of quote objects */
    private List<Quote> items;

    public List<Quote> getItems() {
        return items;
    }

    public void setItems(List<Quote> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "BulkQuote [items=" + items + "]";
    }
}
