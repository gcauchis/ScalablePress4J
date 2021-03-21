[![Build Status](https://travis-ci.com/gcauchis/ScalablePress4J.svg?branch=master)](https://travis-ci.com/gcauchis/ScalablePress4J) [![Javadocs](http://www.javadoc.io/badge/com.github.gcauchis/ScalablePress4j.svg)](http://www.javadoc.io/doc/com.github.gcauchis/ScalablePress4j) [![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.gcauchis/ScalablePress4j/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.gcauchis/ScalablePress4j) [![Codacy Badge](https://api.codacy.com/project/badge/Grade/51a70ee3f0f14a949da114e1c717498b)](https://www.codacy.com/app/gcauchis/ScalablePress4J?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=gcauchis/ScalablePress4J&amp;utm_campaign=Badge_Grade) [![SonarQube Coverage](https://sonarcloud.io/api/project_badges/measure?project=com.github.gcauchis%3AScalablePress4j&metric=coverage)](https://sonarcloud.io/dashboard?id=com.github.gcauchis%3AScalablePress4j) 
[![Language grade: Java](https://img.shields.io/lgtm/grade/java/g/gcauchis/ScalablePress4J.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/gcauchis/ScalablePress4J/context:java)
[![Known Vulnerabilities](https://snyk.io//test/github/gcauchis/ScalablePress4j/badge.svg?targetFile=pom.xml)](https://snyk.io//test/github/gcauchis/ScalablePress4j?targetFile=pom.xml)

# Scalable Press java Wrapper

This is a java 8 wrapper for [Scalable Press API](https://scalablepress.com/docs/)

## Beans
- ScalablePress4J is a service provider bean who provide APIs:
  - ProductApi implement [Product API](https://scalablepress.com/docs/#product-api)
  - QuoteApi implement [Quote API](https://scalablepress.com/docs/#quote-api)
  - OrderApi implement [Order API](https://scalablepress.com/docs/#order-api)
  - EventApi implement [Event API](https://scalablepress.com/docs/#event-api)
  - DesignApi implement [Design  API](https://scalablepress.com/docs/#design-api)
  - BillingApi implement [Billing  API](https://scalablepress.com/docs/#billing-api)
  - ReshipApi implement [Reship  API](https://scalablepress.com/docs/#reship-api)
  - MockupApi implement [Mockup  API](https://scalablepress.com/docs/#mockup-api)

## Configuration
- You need an instance of `ScalablePress4J` and set `ScalablePress4J.setBasicAuth` with your API key. You can obtain you API key on [https://scalablepress.com/docs/#authentication](https://scalablepress.com/docs/#authentication).

## Maven configuration

ScalablePress4J is available on [Maven Central](https://search.maven.org/search?q=g:com.github.gcauchis%20AND%20a:ScalablePress4j). You just have to add the following dependency in your `pom.xml` file.

```xml
<dependency>
    <groupId>com.github.gcauchis</groupId>
    <artifactId>ScalablePress4j</artifactId>
    <version>1.0.0</version>
</dependency>
```

For ***snapshots***, add the following repository to your `pom.xml` file.
```xml
<repository>
    <id>sonatype snapshots</id>
    <url>https://oss.sonatype.org/content/repositories/snapshots</url>
</repository>
```
The current snapshot version is `1.0.1-SNAPSHOT`.
