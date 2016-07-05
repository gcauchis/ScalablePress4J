# Scalable Press java Wrapper [![Build Status](https://travis-ci.org/gcauchis/ScalablePress4J.svg?branch=master)](https://travis-ci.org/gcauchis/ScalablePress4J) [![Javadocs](http://www.javadoc.io/badge/com.github.gcauchis/ScalablePress4j.svg)](http://www.javadoc.io/doc/com.github.gcauchis/ScalablePress4j)

This is a java 8 wrapper for [Scalable Press API](https://scalablepress.com/docs/)

## Spring Beans:
- ScalablePress4J is a service provider bean who provide APIs:
  - ProductService implement [Product API](https://scalablepress.com/docs/#product-api)
  - QuoteService implement [Quote API](https://scalablepress.com/docs/#quote-api)
  - OrderService implement [Order API](https://scalablepress.com/docs/#order-api)
  - EventService implement [Event API](https://scalablepress.com/docs/#event-api)
  - DesignService implement [Design  API](https://scalablepress.com/docs/#design-api)
  - BillingService implement [Billing  API](https://scalablepress.com/docs/#billing-api)
  - ReshipService implement [Reship  API](https://scalablepress.com/docs/#reship-api)

## Configuration
- You need an application.properties with the property `scalablepress.api.basicauth` who contain your API key. You can obtain you API key on [https://scalablepress.com/docs/#authentication](https://scalablepress.com/docs/#authentication).

## Maven configuration

ScalablePress4J is available on [Maven Central](http://search.maven.org/#search|ga|1|a%3A%22ScalablePress4j%22). You just have to add the following dependency in your `pom.xml` file.

```xml
<dependency>
    <groupId>com.github.gcauchis</groupId>
    <artifactId>ScalablePress4j</artifactId>
    <version>0.1.0</version>
</dependency>
```

For ***snapshots***, add the following repository to your `pom.xml` file.
```xml
<repository>
    <id>sonatype snapshots</id>
    <url>https://oss.sonatype.org/content/repositories/snapshots</url>
</repository>
```
The current snapshot version is `0.1.1-SNAPSHOT`.
