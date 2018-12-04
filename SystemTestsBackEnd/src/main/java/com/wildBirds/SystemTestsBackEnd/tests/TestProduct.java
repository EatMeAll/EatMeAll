package com.wildBirds.SystemTestsBackEnd.tests;


import com.wildBirds.SystemTestsBackEnd.domain.model.full_.ProductDTO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;

import org.springframework.web.client.RestTemplate;

public class TestProduct {

    RestTemplate testRestTemplate = new RestTemplate();


    // TODO: 04.12.2018 should import address

    @Value("${eatmeall.server.address.url}")
    private String serverAddress = "http://localhost:8080/app";

    private String subDomain = "/products/";

    @Test
    public void shouldGetProductById() {
        System.out.println("product");

        //given
        final Integer idProduct = 1;
        ProductDTO expectedProduct = new ProductDTO();
        expectedProduct.setIdProduct(1);
        expectedProduct.setName("mleko");
        expectedProduct.setUnit("g");

        //when
        ResponseEntity<ProductDTO> forEntity = testRestTemplate.getForEntity(serverAddress + subDomain +idProduct, ProductDTO.class);
        ProductDTO productDTOEntity = forEntity.getBody();

        //then
        Assert.assertEquals(expectedProduct, productDTOEntity);

    }
    @Test
    public void shouldGet() {
        System.out.println("product33");

//        Assert.assertEquals(2, 3);
    }

}
