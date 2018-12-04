package com.wildBirds.SystemTestsBackEnd.tests;

import com.wildBirds.SystemTestsBackEnd.domain.model.unit_.ProductUnitDTO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class ShoppingListTest {
    RestTemplate restTemplate = new RestTemplate();

    @Value("${eatmeall.server.address.url}")
    private String serverAddress = "http://localhost:8080/app";

    private String subDomain = "/shoppingList/";

    @Test
    public void shouldReturn12ProductsFromTwoDayHistoryMeal(){
        //given
        String fromDate = "/2018-11-30/";
        String toDate ="/2018-11-30";

        //when

        ResponseEntity<ProductUnitDTO[]> forEntity = restTemplate.getForEntity(serverAddress + subDomain + fromDate +toDate, ProductUnitDTO[].class);

        ProductUnitDTO[] productUnitDTOS = forEntity.getBody();
        for (int i = 0; i <productUnitDTOS.length ; i++) {

            System.out.println(productUnitDTOS[i].toString());
        }

        Assert.assertEquals(12, productUnitDTOS.length);
        //then
    }
}
