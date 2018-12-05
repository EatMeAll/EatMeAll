package com.wildBirds.SystemTestsBackEnd.tests;


import com.wildBirds.SystemTestsBackEnd.domain.model.enums.MealTime;
import com.wildBirds.SystemTestsBackEnd.domain.model.full_.DayDTO;
import com.wildBirds.SystemTestsBackEnd.domain.model.unit_.MealUnitDTO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Iterator;

public class ScheduleTest {

    RestTemplate restTemplate = new RestTemplate();

    @Value("${eatmeall.server.address.url}")
    private String serverAddress = "http://localhost:8080/app";

    private String subDomain = "/schedule/";


    @Test
    public void shouldReturn4mealsFor7Days() {
        //given

        MealUnitDTO breakfast = new MealUnitDTO(MealTime.BREAKFAST);
        MealUnitDTO lunch = new MealUnitDTO(MealTime.LUNCH);
        MealUnitDTO snack = new MealUnitDTO(MealTime.SNACK);
        MealUnitDTO dinner = new MealUnitDTO(MealTime.DINNER);
        MealUnitDTO supper = new MealUnitDTO(MealTime.SUPPER);

        //when
        ResponseEntity<DayDTO[]> responseEntity = restTemplate.getForEntity(serverAddress + subDomain, DayDTO[].class);
        DayDTO[] dayDTOTable = responseEntity.getBody();


        //then
        Assert.assertEquals(7, dayDTOTable.length);

        for (int i = 0; i < 7; i++) {
            int breakfastCounter = 0;
            int lunchCounter = 0;
            int snackCounter = 0;
            int dinnerCounter = 0;
            int supperCounter = 0;

            Iterator<MealUnitDTO> mealUnitDTOIterator = dayDTOTable[i].getMeals().iterator();
            while(mealUnitDTOIterator.hasNext()){

                MealUnitDTO mealUnitDTO = mealUnitDTOIterator.next();
                if (mealUnitDTO.getMealTime().equals(breakfast.getMealTime())) {
                    breakfastCounter++;
                    Assert.assertTrue(true);

                } else if(mealUnitDTO.getMealTime().equals(lunch.getMealTime())){
                    lunchCounter++;
                    Assert.assertTrue(true);

                }else if (mealUnitDTO.getMealTime().equals(dinner.getMealTime())){
                    dinnerCounter++;
                    Assert.assertTrue(true);

                } else if (mealUnitDTO.getMealTime().equals(snack.getMealTime())) {
                    snackCounter++;
                    Assert.assertTrue(true);

                }else if (mealUnitDTO.getMealTime().equals(supper.getMealTime())){
                    supperCounter++;
                    Assert.assertTrue(true);

                }else {
                    System.out.println(mealUnitDTOIterator.next().getMealTime().toString());
                    Assert.assertTrue("unknown meal in schedule" , false);
                }
            }
            Assert.assertEquals(1,breakfastCounter);
            Assert.assertEquals(1,lunchCounter);
            Assert.assertEquals(1,snackCounter);
            Assert.assertEquals(1,dinnerCounter);
            Assert.assertEquals(1,supperCounter);
        }

    }

    @Test
    public void shouldReturn2daysContains4DailyMeals() {

        //given
        String fromDate = "/2018-11-26/";
        String toDate = "/2018-11-30";

        MealUnitDTO breakfast = new MealUnitDTO(MealTime.BREAKFAST);
        MealUnitDTO lunch = new MealUnitDTO(MealTime.LUNCH);
        MealUnitDTO snack = new MealUnitDTO(MealTime.SNACK);
        MealUnitDTO dinner = new MealUnitDTO(MealTime.DINNER);
        MealUnitDTO supper = new MealUnitDTO(MealTime.SUPPER);

        //when
        ResponseEntity<DayDTO[]> responseEntity = restTemplate.getForEntity(serverAddress + subDomain + fromDate + toDate, DayDTO[].class);
        DayDTO[] dayDTOTable = responseEntity.getBody();


        //then
        Assert.assertEquals(5, dayDTOTable.length);

        for (int i = 0; i < 5; i++) {
            int breakfastCounter = 0;
            int lunchCounter = 0;
            int snackCounter = 0;
            int dinnerCounter = 0;
            int supperCounter = 0;

            Iterator<MealUnitDTO> mealUnitDTOIterator = dayDTOTable[i].getMeals().iterator();
            while (mealUnitDTOIterator.hasNext()) {

                MealUnitDTO mealUnitDTO = mealUnitDTOIterator.next();
                if (mealUnitDTO.getMealTime().equals(breakfast.getMealTime())) {
                    breakfastCounter++;
                    Assert.assertTrue(true);

                } else if (mealUnitDTO.getMealTime().equals(lunch.getMealTime())) {
                    lunchCounter++;
                    Assert.assertTrue(true);

                } else if (mealUnitDTO.getMealTime().equals(dinner.getMealTime())) {
                    dinnerCounter++;
                    Assert.assertTrue(true);

                } else if (mealUnitDTO.getMealTime().equals(snack.getMealTime())) {
                    snackCounter++;
                    Assert.assertTrue(true);

                } else if (mealUnitDTO.getMealTime().equals(supper.getMealTime())) {
                    supperCounter++;
                    Assert.assertTrue(true);

                } else {
                    System.out.println(mealUnitDTOIterator.next().getMealTime().toString());
                    Assert.assertTrue("unknown meal in schedule", false);
                }
            }
            Assert.assertEquals(1, breakfastCounter);
            Assert.assertEquals(1, lunchCounter);
            Assert.assertEquals(1, snackCounter);
            Assert.assertEquals(1, dinnerCounter);
            Assert.assertEquals(1, supperCounter);
        }
    }
}
