package com.wildBirds.SystemTestsBackEnd.tests;


import com.wildBirds.SystemTestsBackEnd.domain.model.full_.ProductDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class ProductTest {

    RestTemplate restTemplate = new RestTemplate();


    // TODO: 04.12.2018 should import address

    @Value("${eatmeall.server.address.url}")
    private String serverAddress = "http://localhost:8080/app";

    private String subDomain = "/products/";

    ProductDTO currentProduct;

    @Before
    public void getProduct() {
        currentProduct = new ProductDTO();
    }

    @Test
    public void shouldGetProductById() {
        //given
        final Integer idProduct = 1;
        currentProduct.setName("mleko");
        currentProduct.setUnit("ml");

        //when
        ResponseEntity<ProductDTO> entity = restTemplate.getForEntity(serverAddress + subDomain + idProduct, ProductDTO.class);
        ProductDTO productDTOEntity = entity.getBody();

        //then
        Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());
        Assert.assertEquals(currentProduct, productDTOEntity);

    }
    @Test
    public void shouldGetProductByName() {
        //given
        final String productName = "jajko";
        currentProduct.setName("jajko");
        currentProduct.setUnit("g");

        //when
        ResponseEntity<ProductDTO> entity = restTemplate.getForEntity(serverAddress + subDomain + "/name/" + productName, ProductDTO.class);
        ProductDTO productDTOEntity = entity.getBody();

        HttpStatus statusCode = entity.getStatusCode();
        //then
        Assert.assertEquals(HttpStatus.OK, statusCode);
        Assert.assertEquals(currentProduct, productDTOEntity);
    }

    @Test
    public void shouldThrowDuplicateEntity() {
        //given

        currentProduct.setName("jajko");
        currentProduct.setUnit("g");
        //when
        ResponseEntity<ProductDTO> entity = null;
        try {
            entity = restTemplate.postForEntity(serverAddress + subDomain, currentProduct, ProductDTO.class);

            //then
        } catch (RestClientException e) {
            Assert.assertEquals(HttpStatus.CONFLICT.toString(), e.getMessage().toUpperCase());
        }
    }

    @Test
    public void shouldPostProductByNameAndRemoveIt() {

        //given
        currentProduct.setName("productTest");
        currentProduct.setUnit("kg");
        //when
        ResponseEntity<ProductDTO> entity = restTemplate.postForEntity(serverAddress + subDomain, currentProduct, ProductDTO.class);
        ProductDTO responseProduct = entity.getBody();
        //then
        Assert.assertEquals(HttpStatus.CREATED, entity.getStatusCode());
        Assert.assertEquals(currentProduct, responseProduct);

        //remove product from db

        //given
        Integer idProduct = responseProduct.getIdProduct();
        //when
        restTemplate.delete(serverAddress + subDomain + idProduct);
        try {
            entity = restTemplate.getForEntity(serverAddress + subDomain + idProduct, ProductDTO.class);

            //then
        } catch (RestClientException e) {
            Assert.assertEquals(HttpStatus.NOT_FOUND.toString().substring(0,3), e.getMessage().toUpperCase().substring(0,3));
        }

    }

}
