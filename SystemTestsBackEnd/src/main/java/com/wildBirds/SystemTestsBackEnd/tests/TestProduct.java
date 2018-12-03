package com.wildBirds.SystemTestsBackEnd.tests;


import com.wildBirds.SystemTestsBackEnd.DTO.full_.ProductDTO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class TestProduct {

    @Autowired
    TestRestTemplate testRestTemplate;

    final String serverAddress = "http://localhost:8080/app/products/";

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
        ResponseEntity<ProductDTO> forEntity = testRestTemplate.getForEntity(serverAddress + idProduct, ProductDTO.class);
        ProductDTO productDTOEntity = forEntity.getBody();
        //then
        System.out.println(" >>>>>>>>>>> " + expectedProduct);
        System.out.println(">>>>>>> --->>>>>>>> "  + productDTOEntity);
        Assert.assertEquals(expectedProduct, productDTOEntity);

    }

}
