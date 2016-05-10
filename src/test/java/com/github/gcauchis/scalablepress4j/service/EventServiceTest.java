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
package com.github.gcauchis.scalablepress4j.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.github.gcauchis.scalablepress4j.model.Event;
import com.github.gcauchis.scalablepress4j.model.PaginatedResultList;
import com.github.gcauchis.scalablepress4j.test.PropertyTestConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ScalablePress4J.class, PropertyTestConfiguration.class }, loader = AnnotationConfigContextLoader.class)
public class EventServiceTest {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ScalablePress4J scalablePress;
    
    private EventService eventServices;
    
    @Before
    public void init()
    {
        eventServices = scalablePress.event();
    }
    
    @Test
    public void context() {
        Assert.assertNotNull(eventServices);
    }
    
    @Test
    public void retrieve() {
        PaginatedResultList<Event> paginatedEventsList = eventServices.queryEvents(null, 1);
        Assert.assertNotNull(paginatedEventsList);
        Assert.assertNotNull(paginatedEventsList.getResult());
        log.info("Result: {}", paginatedEventsList);
    }
}
