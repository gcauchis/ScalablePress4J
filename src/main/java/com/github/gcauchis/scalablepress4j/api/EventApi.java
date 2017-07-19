/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2016-2017 Gabriel Cauchis
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
package com.github.gcauchis.scalablepress4j.api;

import org.apache.commons.lang3.StringUtils;

import com.github.gcauchis.scalablepress4j.ScalablePressBadRequestException;
import com.github.gcauchis.scalablepress4j.model.Event;
import com.github.gcauchis.scalablepress4j.model.PaginatedResultList;
import com.github.gcauchis.scalablepress4j.model.QueryEvent;

/**
 * The Event API helps you keep track of event of your orders.
 * 
 * @author gcauchis
 * @see <a href="https://scalablepress.com/docs/#event-api">https://scalablepress.com/docs/#event-api</a>
 */
public class EventApi extends AbstractRestApi {

    /** The Constant URL_EVENT. */
    private static final String URL_EVENT = "event";

    /**
     * Events contain useful information about the state of your order.
     *
     * @param query the query
     * @param page the page to view
     * @return Returns an array of event objects.
     * @throws ScalablePressBadRequestException for invalid request or error occur during call.
     * @see <a href="https://scalablepress.com/docs/#query-events">https://scalablepress.com/docs/#query-events</a>
     */
    public PaginatedResultList<Event> queryEvents(QueryEvent query, int page) {
        StringBuilder args = new StringBuilder();
        if (query != null) {
            appendArg(args, "orderId", query.getOrderId());
            appendArg(args, "name", query.getName());
            appendArg(args, "start", query.getStart());
            appendArg(args, "end", query.getEnd());
            appendArg(args, "itemIndex", query.getItemIndex());
            appendArg(args, "itemName", query.getItemName());
            appendArg(args, "sort", query.getSort());
        }
        return new PaginatedResultList<>( get(URL_EVENT + "?" + args.toString(), page, Event[].class));
    }

    protected void appendArg(StringBuilder args, String argName,
            String argValue) {
        if (StringUtils.isNotBlank(argValue)) {
            if (args.length() > 0) {
                args.append("&");
            }
            args.append(argName).append("=").append(argValue);
        }
    }

    /**
     * Provide the eventId in order to receive the details of an event.
     * 
     * @return event object.
     * @throws ScalablePressBadRequestException for invalid request or error occur during call.
     * @see <a href="https://scalablepress.com/docs/#retrieve-single-event">https://scalablepress.com/docs/#retrieve-single-event</a>
     */
    public Event retrieve(String eventId) {
        return get(buildUrl(URL_EVENT, eventId), Event.class);
    }
}
