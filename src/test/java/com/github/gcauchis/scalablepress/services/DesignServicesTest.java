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
package com.github.gcauchis.scalablepress.services;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.web.client.HttpClientErrorException;

import com.github.gcauchis.scalablepress.model.Design;
import com.github.gcauchis.scalablepress.model.DesignResponse;
import com.github.gcauchis.scalablepress.model.DesignSide;
import com.github.gcauchis.scalablepress.model.DesignSides;
import com.github.gcauchis.scalablepress.model.Dimension;
import com.github.gcauchis.scalablepress.model.Position;
import com.github.gcauchis.scalablepress.model.PositionOffset;
import com.github.gcauchis.scalablepress.test.PropertyTestConfiguration;

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
    
    @Test(expected = HttpClientErrorException.class)//Need to find a good image for test
    public void create() {
        Design design = new Design();
        design.setName("Test");
        design.setType("mug");
        DesignSides designSides = new DesignSides();
        DesignSide front = new DesignSide();
        front.setArtwork("https://upload.wikimedia.org/wikipedia/commons/thumb/4/47/PNG_transparency_demonstration_1.png/300px-PNG_transparency_demonstration_1.png");
//        front.setArtwork("https://avatars0.githubusercontent.com/u/975738?v=3&s=460");
        front.setColors(Arrays.asList("Blue", "Royal", "Pink", "Charity Pink", "White", "Light Blue"));
        Dimension dimension = new Dimension();
        dimension.setWidth(5);
        front.setDimensions(dimension);
        Position position = new Position();
        position.setHorizontal("C");
        PositionOffset positionOffset = new PositionOffset();
        positionOffset.setTop(1);
        position.setOffset(positionOffset);
        front.setPosition(position);
        front.setResize(true);
        designSides.setFront(front);
        design.setSides(designSides);
        DesignResponse response = designServices.create(design);
        Assert.assertNotNull(response);
        log.info(response.toString());
        log.info("*********** designId => " + response.getDesignId());
    }
}
