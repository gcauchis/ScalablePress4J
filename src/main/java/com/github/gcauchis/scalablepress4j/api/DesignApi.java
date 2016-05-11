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
package com.github.gcauchis.scalablepress4j.api;

import com.github.gcauchis.scalablepress4j.ScalablePressBadRequestException;
import com.github.gcauchis.scalablepress4j.model.Design;
import com.github.gcauchis.scalablepress4j.model.DesignResponse;

/**
 * The Design API takes in information about your print design (dimensions,
 * files, position, etc.) and provides you with a designId which can be used to
 * place an order.<br/>
 * 
 * Designs cannot be modified once created.<br/>
 * 
 * @author gcauchis
 * @see https://scalablepress.com/docs/#design-api
 */
public class DesignApi extends AbstractRestApi {

    /**
     * Provide the details on your design in order to receive a designId, which is required to place an order.
     * @param design
     * @return a design response object.
     * @throws ScalablePressBadRequestException for invalid request or error occur during call.
     * @see https://scalablepress.com/docs/#create-design-object
     */
    public DesignResponse create(Design design) throws ScalablePressBadRequestException {
        return post("design", design, DesignResponse.class);
    }
    
    /**
     * Provide the designId in order to receive the details of a previously submitted design.
     * @param designId
     * @return a design response object.
     * @throws ScalablePressBadRequestException for invalid request or error occur during call.
     * @see https://scalablepress.com/docs/#retrieve-design-object
     */
    public DesignResponse retrieve(String designId) throws ScalablePressBadRequestException {
        return get("design/" + designId, DesignResponse.class);
    }
    
    /**
     * Provide the designId in order to delete a previously submitted design.
     * @param designId
     * @return adesign response object with an extra deletedAt number that records the time at which the design was deleted.
     * @throws ScalablePressBadRequestException for invalid request or error occur during call.
     * @see https://scalablepress.com/docs/#delete-design
     */
    public DesignResponse delete(String designId) throws ScalablePressBadRequestException {
        return delete("design/" + designId, DesignResponse.class);
    }
}
