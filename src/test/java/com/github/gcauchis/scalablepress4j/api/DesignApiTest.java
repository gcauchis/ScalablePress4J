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

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.gcauchis.scalablepress4j.ScalablePressBadRequestException;
import com.github.gcauchis.scalablepress4j.model.Design;
import com.github.gcauchis.scalablepress4j.model.DesignResponse;

/**
 * The Class DesignApiTest.
 */
public class DesignApiTest extends AbstractApiTest {

    /** The design api. */
    private DesignApi designApi;

    /**
     * Inits the test.
     */
    @Before
    public void init() {
        designApi = scalablePress.designApi();
    }

    /**
     * Test context.
     */
    @Test
    public void context() {
        Assert.assertNotNull(designApi);
    }
    
    /**
     * Test design work flow.
     * @throws JsonProcessingException 
     */
    @Test
    public void designWorkFlow() throws JsonProcessingException {
        Design design = buildTestDesign();
        log.info("Create design: {}", toJsonString(design));
        DesignResponse response = designApi.create(design);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getDesignId());
        log.info("Returned design: {} ", response);
        log.info("Design created with designId = {}", response.getDesignId());
        String designId = response.getDesignId();
        
        log.info("Retreive design: {} ", designId);
        DesignResponse retieveDesign = designApi.retrieve(designId);
        Assert.assertNotNull(retieveDesign);
        Assert.assertEquals(designId, retieveDesign.getDesignId());
        log.info("Returned design: {} ", retieveDesign);
        
        log.info("Delete design: {} ", designId);
        DesignResponse deleted = designApi.delete(designId);
        Assert.assertNotNull(deleted);
        Assert.assertEquals(designId, deleted.getDesignId());
        log.info("Returned design: {} ", deleted);
        
        try {
            log.info("Retreive deleted design: {}", designId);
            designApi.retrieve(designId);
            Assert.fail("Error 404 must occur, the desing doesn't exist anymore");
        } catch (ScalablePressBadRequestException e) {
            Assert.assertEquals("404", e.getErrorResponse().getStatusCode());
            log.info("Design deleted successfully");
        }
    }
}
