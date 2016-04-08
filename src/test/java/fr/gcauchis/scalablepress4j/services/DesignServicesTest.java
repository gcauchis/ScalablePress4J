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
package fr.gcauchis.scalablepress4j.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import fr.gcauchis.scalablepress4j.ScalablePressBadRequestException;
import fr.gcauchis.scalablepress4j.model.Design;
import fr.gcauchis.scalablepress4j.model.DesignResponse;
import fr.gcauchis.scalablepress4j.model.DesignSide;
import fr.gcauchis.scalablepress4j.model.DesignSides;
import fr.gcauchis.scalablepress4j.model.Dimension;
import fr.gcauchis.scalablepress4j.model.Position;
import fr.gcauchis.scalablepress4j.model.PositionOffset;
import fr.gcauchis.scalablepress4j.services.DesignServices;
import fr.gcauchis.scalablepress4j.test.PropertyTestConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DesignServices.class, PropertyTestConfiguration.class}, loader = AnnotationConfigContextLoader.class)
public class DesignServicesTest {

    private final Logger log = LoggerFactory.getLogger(getClass());
    
    @Autowired
    private DesignServices designServices;

    @Test
    public void context() {
        Assert.assertNotNull(designServices);
    }
    
    @Test//(expected = ScalablePressBadRequestException.class)//Need to find a good image for test
    public void design() {
        Design design = new Design();
        design.setName("Test");
        design.setType("dtg");
        DesignSides designSides = new DesignSides();
        DesignSide front = new DesignSide();
        front.setArtwork("https://raw.githubusercontent.com/gcauchis/ScalablePressWrapper/master/src/test/resources/lena_150dpi.png");
        Dimension dimension = new Dimension();
        dimension.setWidth(5);
        front.setDimensions(dimension);
        Position position = new Position();
        position.setHorizontal("C");
        PositionOffset positionOffset = new PositionOffset();
        positionOffset.setTop(2.5);
        position.setOffset(positionOffset);
        front.setPosition(position);
        front.setResize(true);
        designSides.setFront(front);
        design.setSides(designSides);
        log.info("Create design");
        DesignResponse response = designServices.create(design);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getDesignId());
        log.info("Returned design: {} ",response.toString());
        log.info("Design created with designId = {}", response.getDesignId());
        String designId = response.getDesignId();
        
        log.info("Retreive design: {} ", designId);
        DesignResponse retieveDesign = designServices.retrieve(designId);
        Assert.assertNotNull(retieveDesign);
        Assert.assertEquals(designId, retieveDesign.getDesignId());
        log.info("Returned design: {} ", retieveDesign.toString());
        
        log.info("Delete design: {} ", designId);
        DesignResponse deleted = designServices.delete(designId);
        Assert.assertNotNull(deleted);
        Assert.assertEquals(designId, deleted.getDesignId());
        log.info("Returned design: {} ", deleted.toString());
        
        try {
            log.info("Retreive deleted design: {}", designId);
            designServices.retrieve(designId);
            Assert.fail("Error 404 must occur, the desing doesn't exist anymore");
        } catch (ScalablePressBadRequestException e) {
            Assert.assertEquals("404", e.getErrorResponse().getStatusCode());
            log.info("Design deleted successfully");
        }
    }
}
