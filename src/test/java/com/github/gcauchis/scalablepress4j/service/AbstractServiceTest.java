package com.github.gcauchis.scalablepress4j.service;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.github.gcauchis.scalablepress4j.model.Design;
import com.github.gcauchis.scalablepress4j.model.DesignSide;
import com.github.gcauchis.scalablepress4j.model.DesignSides;
import com.github.gcauchis.scalablepress4j.model.Dimension;
import com.github.gcauchis.scalablepress4j.model.Position;
import com.github.gcauchis.scalablepress4j.model.PositionOffset;
import com.github.gcauchis.scalablepress4j.test.PropertyTestConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {
                ScalablePress4J.class,
                PropertyTestConfiguration.class
                },
        loader = AnnotationConfigContextLoader.class)
public abstract class AbstractServiceTest {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    protected ScalablePress4J scalablePress;
    
    public Design buildTestDesign() {
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
        return design;
    }
}
