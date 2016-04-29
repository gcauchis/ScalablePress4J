package com.github.gcauchis.scalablepress4j.service;

import org.junit.Assert;
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
import com.github.gcauchis.scalablepress4j.service.EventService;
import com.github.gcauchis.scalablepress4j.test.PropertyTestConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { EventService.class, PropertyTestConfiguration.class }, loader = AnnotationConfigContextLoader.class)
public class EventServiceTest {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private EventService eventServices;
    
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
