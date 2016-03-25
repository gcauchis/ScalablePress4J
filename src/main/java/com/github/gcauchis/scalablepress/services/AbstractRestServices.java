package com.github.gcauchis.scalablepress.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public abstract class AbstractRestServices {

    protected final Logger log = LoggerFactory.getLogger(getClass());
    
    private RestTemplate restTemplate = new RestTemplate();
    
    protected <T> T getForObject(String url, Class<T> responseType) throws RestClientException {
       log.trace("Call for object {} url {}", responseType.toString(), url);
        return restTemplate.getForObject(url, responseType);
    }
    
    protected <T> T getForObjectArray(String url, Class<T> responseType) throws RestClientException {
        log.trace("Call for object array {} url {}", responseType.toString(), url);
        return ((ResponseEntity<T>) restTemplate.getForEntity(url, responseType)).getBody();
    }
}
