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
import org.junit.Ignore;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.gcauchis.scalablepress4j.model.Design;
import com.github.gcauchis.scalablepress4j.model.DesignSide;
import com.github.gcauchis.scalablepress4j.model.DesignSides;
import com.github.gcauchis.scalablepress4j.model.Dimension;
import com.github.gcauchis.scalablepress4j.model.Mockup;
import com.github.gcauchis.scalablepress4j.model.MockupOutput;
import com.github.gcauchis.scalablepress4j.model.MockupProduct;
import com.github.gcauchis.scalablepress4j.model.Position;
import com.github.gcauchis.scalablepress4j.model.PositionOffset;
import com.github.gcauchis.scalablepress4j.model.Product;
import com.github.gcauchis.scalablepress4j.model.Template;

/**
 * The Class MockupApiTest.
 *
 * @author gcauchis
 */
public class MockupApiTest extends AbstractApiTest {
    /** The design api. */
    private MockupApi mockupApi;
    
    private ProductApi productApi;

    /**
     * Inits the test.
     */
    @Before
    public void init() {
        mockupApi = scalablePress.mockupApi();
        productApi = scalablePress.productApi();
    }

    /**
     * Test context.
     */
    @Test
    public void context() {
        Assert.assertNotNull(mockupApi);
    }

    @Test
    @Ignore
    public void create() throws JsonProcessingException {
        
        // create Mockup 
        // {"template":{"name":"tshirt-front"},
        // "product":{"id":"gildan-cotton-t-shirt","color":"Navy"},
        // "design":{"type":"dtg","sides":{"front":{"artwork":"https://raw.githubusercontent.com/gcauchis/ScalablePressWrapper/master/src/test/resources/lena_150dpi.png",
        //                                "dimensions":{"width":5},"position":{"horizontal":"C","offset":{"top":2.5}}}}},
        // "output":{"width":1000,"height":1000,"padding":10,"format":"png"}}
        // ...
        // Response error object: ErrorResponse [statusCode=400, issues=null, path=null, message=Template unisex-tshirt-front is not available for Gildan Cotton T-Shirt]
        // getProductInformation of gildan-cotton-t-shirt return unisex-tshirt-front for front... WHY ???????????
        
        
//        curl "https://api.scalablepress.com/v3/mockup" \
//        -u ":YOURAPIKEY"
//        -F "template[name]=tshirt-front"
//        -F "product[id]=gildan-cotton-t-shirt"
//        -F "product[color]=Navy"
//        -F "design[type]=dtg"
//        -F "design[sides][front][artwork]=@image.png"
//        -F "design[sides][front][dimensions][width]=5" \
//        -F "design[sides][front][position][horizontal]=C" \
//        -F "design[sides][front][position][offset][top]=2.5" \
//        -F "output[width]=1000"
//        -F "output[height]=1000"
//        -F "padding[height]=10"
//        -F "output[format]=png"
        Product product = productApi.getProductInformation("gildan-cotton-t-shirt");
        log.info("product {}", toJsonString(product));
        Assert.assertNotNull(product);
        Assert.assertNotNull(product.getTemplates());
        Assert.assertNotNull(product.getTemplates().getFront());
        
//        Mockup mockup = new Mockup();
//        Design design = new Design();
//        design.setType("dtg");
//        DesignSides designSides = new DesignSides();
//        DesignSide front = new DesignSide();
//        front.setArtwork("https://raw.githubusercontent.com/gcauchis/ScalablePressWrapper/master/src/test/resources/lena_150dpi.png");
//        Dimension dimension = new Dimension();
//        dimension.setWidth(5);
//        front.setDimensions(dimension);
//        Position position = new Position();
//        position.setHorizontal("C");
//        PositionOffset positionOffset = new PositionOffset();
//        positionOffset.setTop(2.5);
//        position.setOffset(positionOffset);
//        front.setPosition(position);
//        designSides.setFront(front);
//        design.setSides(designSides);
//        mockup.setDesign(design);
//        Template template = new Template();
//        template.setName(product.getTemplates().getFront());
//        mockup.setTemplate(template);
//        MockupProduct mockupProduct = new MockupProduct();
//        mockupProduct.setId(product.getProductId());
//        mockupProduct.setColor("Navy");
//        mockup.setProduct(mockupProduct);
//        MockupOutput output = new MockupOutput();
//        output.setWidth(1000);
//        output.setHeight(1000);
//        output.setPadding(10);
//        output.setFormat("png");
//        mockup.setOutput(output);
        
//
        Mockup mockup = new Mockup();
        Design design = buildTestDesign();
        mockup.setDesign(design);
        Template template = new Template();
//        template.setName("tshirt-front");
        template.setName(product.getTemplates().getFront());
//        template.setName("gildan-cotton-t-shirt");
//        template.setBackground("dark-wood");
        mockup.setTemplate(template);
        MockupProduct mockupProduct = new MockupProduct();
        mockupProduct.setId(product.getProductId());
        mockupProduct.setColor(product.getColors().get(0).getName());
        mockup.setProduct(mockupProduct);
        MockupOutput output = new MockupOutput();
        output.setWidth(1000);
        output.setHeight(1000);
        output.setPadding(10);
        output.setFormat("png");
        mockup.setOutput(output);

        log.info("create Mockup {}", toJsonString(mockup));
        String url = mockupApi.create(mockup);
        Assert.assertNotNull(url);
        log.info("Mockup url {}", url);
    }
}
