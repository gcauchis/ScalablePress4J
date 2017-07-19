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

import com.github.gcauchis.scalablepress4j.ScalablePressBadRequestException;
import com.github.gcauchis.scalablepress4j.model.Mockup;
import com.github.gcauchis.scalablepress4j.model.Url;

/**
 * The Mockup API allows you to generate renderings printed products with your own artwork.
 * 
 * These images can be used in your online store.
 * 
 * @author gcauchis
 * @see <a href= "https://scalablepress.com/docs/#mockup-api">https://scalablepress.com/docs/#mockup-api</a>
 */
public class MockupApi extends AbstractRestApi {

    /** The Constant URL_MOCKUP. */
    private static final String URL_MOCKUP = "mockup";

    /**
     * Provide the details of your design and product in order to receive an URL of rendered mockup image.
     *
     * @param mockup the mockup
     * @return the mockup url
     * @throws ScalablePressBadRequestException for invalid request or error occur during call.
     * @see <a href="https://scalablepress.com/docs/#create-mockup">https://scalablepress.com/docs/#create-mockup</a>
     */
    public String create(Mockup mockup) {
        return post(URL_MOCKUP, mockup, Url.class).getUrl();
    }
}
