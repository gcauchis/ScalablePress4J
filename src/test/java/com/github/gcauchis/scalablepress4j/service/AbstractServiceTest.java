package com.github.gcauchis.scalablepress4j.service;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

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
}
