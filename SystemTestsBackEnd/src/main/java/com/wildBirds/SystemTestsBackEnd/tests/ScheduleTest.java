package com.wildBirds.SystemTestsBackEnd.tests;


import com.wildBirds.SystemTestsBackEnd.domain.model.enums.MealTime;
import com.wildBirds.SystemTestsBackEnd.domain.model.full_.DayDTO;
import com.wildBirds.SystemTestsBackEnd.domain.model.unit_.MealUnitDTO;
import com.wildBirds.SystemTestsBackEnd.domain.model.unit_.ProductUnitDTO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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

    public void shouldSaveSchuldeFrom26_11_to_02_12(){

        //given
        String excampleJson = "[\n" +
                "    {\n" +
                "    \t\"date\": \"2018-11-26T09:30:33.156Z\",    \t\n" +
                "        \"meals\": [\n" +
                "            {\n" +
                "                \"idMeal\": 15,\n" +
                "                \"language\": \"PL\",\n" +
                "                \"mealTime\": \"DINNER\",\n" +
                "                \"public\": true,\n" +
                "                \"shortDescription\": \"Przepis z Excel\",\n" +
                "                \"title\": \"Roladki schabowe z ziemniakami z pietruszką, Surówka ulubiona\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"idMeal\": 63,\n" +
                "                \"language\": \"PL\",\n" +
                "                \"mealTime\": \"SNACK\",\n" +
                "                \"public\": true,\n" +
                "                \"shortDescription\": \"Przepis z Excel\",\n" +
                "                \"title\": \"Sałatka z pomidora i ogórka kiszonego \"\n" +
                "            },\n" +
                "            {\n" +
                "                \"idMeal\": 86,\n" +
                "                \"language\": \"PL\",\n" +
                "                \"mealTime\": \"SUPPER\",\n" +
                "                \"public\": true,\n" +
                "                \"shortDescription\": \"Przepis z Excel\",\n" +
                "                \"title\": \"Papryka faszerowana\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"idMeal\": 73,\n" +
                "                \"language\": \"PL\",\n" +
                "                \"mealTime\": \"BREAKFAST\",\n" +
                "                \"public\": true,\n" +
                "                \"shortDescription\": \"Przepis z Excel\",\n" +
                "                \"title\": \"Owocowo-orzechowa owsianka bez gotowania\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"idMeal\": 9,\n" +
                "                \"language\": \"PL\",\n" +
                "                \"mealTime\": \"LUNCH\",\n" +
                "                \"public\": true,\n" +
                "                \"shortDescription\": \"Przepis z Excel\",\n" +
                "                \"title\": \"Kanapki z serkiem topionym\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "    \t\"date\": \"2018-11-27T09:30:33.156Z\",    \n" +
                "        \"meals\": [\n" +
                "            {\n" +
                "                \"idMeal\": 67,\n" +
                "                \"language\": \"PL\",\n" +
                "                \"mealTime\": \"DINNER\",\n" +
                "                \"public\": true,\n" +
                "                \"shortDescription\": \"Przepis z Excel\",\n" +
                "                \"title\": \"LECZO Z KURCZAKIEM I RYŻEM\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"idMeal\": 96,\n" +
                "                \"language\": \"PL\",\n" +
                "                \"mealTime\": \"SNACK\",\n" +
                "                \"public\": true,\n" +
                "                \"shortDescription\": \"Przepis z Excel\",\n" +
                "                \"title\": \"Ryż na mleku z owocami:\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"idMeal\": 78,\n" +
                "                \"language\": \"PL\",\n" +
                "                \"mealTime\": \"LUNCH\",\n" +
                "                \"public\": true,\n" +
                "                \"shortDescription\": \"Przepis z Excel\",\n" +
                "                \"title\": \"Sałatka z pomidora, ogórka kiszonego  i cebulki\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"idMeal\": 52,\n" +
                "                \"language\": \"PL\",\n" +
                "                \"mealTime\": \"SUPPER\",\n" +
                "                \"public\": true,\n" +
                "                \"shortDescription\": \"Przepis z Excel\",\n" +
                "                \"title\": \"Papryka faszerowana\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"idMeal\": 69,\n" +
                "                \"language\": \"PL\",\n" +
                "                \"mealTime\": \"BREAKFAST\",\n" +
                "                \"public\": true,\n" +
                "                \"shortDescription\": \"Przepis z Excel\",\n" +
                "                \"title\": \"Koktajl mleczny z otrębami\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "    \t\"date\": \"2018-11-28T09:30:33.156Z\",        \t\n" +
                "        \"meals\": [\n" +
                "            {\n" +
                "                \"idMeal\": 102,\n" +
                "                \"language\": \"PL\",\n" +
                "                \"mealTime\": \"SUPPER\",\n" +
                "                \"public\": true,\n" +
                "                \"shortDescription\": \"Przepis z Excel\",\n" +
                "                \"title\": \"SAŁATKA CESAR ( Z KURCZAKIEM)\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"idMeal\": 82,\n" +
                "                \"language\": \"PL\",\n" +
                "                \"mealTime\": \"DINNER\",\n" +
                "                \"public\": true,\n" +
                "                \"shortDescription\": \"Przepis z Excel\",\n" +
                "                \"title\": \"Hamburgery drobiowe, Surówka z białej kapusty\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"idMeal\": 6,\n" +
                "                \"language\": \"PL\",\n" +
                "                \"mealTime\": \"BREAKFAST\",\n" +
                "                \"public\": true,\n" +
                "                \"shortDescription\": \"Przepis z Excel\",\n" +
                "                \"title\": \"Jajecznica na masełku, pumpernikiel\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"idMeal\": 7,\n" +
                "                \"language\": \"PL\",\n" +
                "                \"mealTime\": \"LUNCH\",\n" +
                "                \"public\": true,\n" +
                "                \"shortDescription\": \"Przepis z Excel\",\n" +
                "                \"title\": \"Chleb żytni razowy Do przegryzania wafle ryżowe\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"idMeal\": 95,\n" +
                "                \"language\": \"PL\",\n" +
                "                \"mealTime\": \"SNACK\",\n" +
                "                \"public\": true,\n" +
                "                \"shortDescription\": \"Przepis z Excel\",\n" +
                "                \"title\": \"Twarożek ze szczypiorkiem\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "    \t\"date\": \"2018-11-29T09:30:33.156Z\",        \t\n" +
                "        \"meals\": [\n" +
                "            {\n" +
                "                \"idMeal\": 2,\n" +
                "                \"language\": \"PL\",\n" +
                "                \"mealTime\": \"BREAKFAST\",\n" +
                "                \"public\": true,\n" +
                "                \"shortDescription\": \"Przepis z Excel\",\n" +
                "                \"title\": \"Jogurt owocowy z suszonymi owocami\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"idMeal\": 54,\n" +
                "                \"language\": \"PL\",\n" +
                "                \"mealTime\": \"SNACK\",\n" +
                "                \"public\": true,\n" +
                "                \"shortDescription\": \"Przepis z Excel\",\n" +
                "                \"title\": \"Pomidorki koktajlowe \"\n" +
                "            },\n" +
                "            {\n" +
                "                \"idMeal\": 84,\n" +
                "                \"language\": \"PL\",\n" +
                "                \"mealTime\": \"SUPPER\",\n" +
                "                \"public\": true,\n" +
                "                \"shortDescription\": \"Przepis z Excel\",\n" +
                "                \"title\": \"Bułka pełnoziarnistaz twarożkiem ze szczypiorkiem\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"idMeal\": 41,\n" +
                "                \"language\": \"PL\",\n" +
                "                \"mealTime\": \"LUNCH\",\n" +
                "                \"public\": true,\n" +
                "                \"shortDescription\": \"Przepis z Excel\",\n" +
                "                \"title\": \"Chleb żytni razowy Do przegryzania wafle ryżowe\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"idMeal\": 13,\n" +
                "                \"language\": \"PL\",\n" +
                "                \"mealTime\": \"DINNER\",\n" +
                "                \"public\": true,\n" +
                "                \"shortDescription\": \"Przepis z Excel\",\n" +
                "                \"title\": \"Gulasz z kurczakiem i fasolką szparagową\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "    \t\"date\": \"2018-11-30T09:30:33.156Z\",        \t\n" +
                "        \"meals\": [\n" +
                "            {\n" +
                "                \"idMeal\": 21,\n" +
                "                \"language\": \"PL\",\n" +
                "                \"mealTime\": \"SNACK\",\n" +
                "                \"public\": true,\n" +
                "                \"shortDescription\": \"Przepis z Excel\",\n" +
                "                \"title\": \"Deser mleczny\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"idMeal\": 34,\n" +
                "                \"language\": \"PL\",\n" +
                "                \"mealTime\": \"SUPPER\",\n" +
                "                \"public\": true,\n" +
                "                \"shortDescription\": \"Przepis z Excel\",\n" +
                "                \"title\": \"SAŁATKA CESAR ( Z KURCZAKIEM)\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"idMeal\": 36,\n" +
                "                \"language\": \"PL\",\n" +
                "                \"mealTime\": \"BREAKFAST\",\n" +
                "                \"public\": true,\n" +
                "                \"shortDescription\": \"Przepis z Excel\",\n" +
                "                \"title\": \"Jogurt owocowy z suszonymi owocami\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"idMeal\": 14,\n" +
                "                \"language\": \"PL\",\n" +
                "                \"mealTime\": \"DINNER\",\n" +
                "                \"public\": true,\n" +
                "                \"shortDescription\": \"Przepis z Excel\",\n" +
                "                \"title\": \"Hamburgery drobiowe, Surówka z białej kapusty\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"idMeal\": 77,\n" +
                "                \"language\": \"PL\",\n" +
                "                \"mealTime\": \"LUNCH\",\n" +
                "                \"public\": true,\n" +
                "                \"shortDescription\": \"Przepis z Excel\",\n" +
                "                \"title\": \"Kanapki z serkiem topionym\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "    \t\"date\": \"2018-12-01T09:30:33.156Z\",        \t\n" +
                "        \"meals\": [\n" +
                "            {\n" +
                "                \"idMeal\": 49,\n" +
                "                \"language\": \"PL\",\n" +
                "                \"mealTime\": \"DINNER\",\n" +
                "                \"public\": true,\n" +
                "                \"shortDescription\": \"Przepis z Excel\",\n" +
                "                \"title\": \"Roladki schabowe z ziemniakami z pietruszką, Surówka ulubiona\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"idMeal\": 64,\n" +
                "                \"language\": \"PL\",\n" +
                "                \"mealTime\": \"BREAKFAST\",\n" +
                "                \"public\": true,\n" +
                "                \"shortDescription\": \"Przepis z Excel\",\n" +
                "                \"title\": \"KANAPKI Z SZYNKĄ, SAŁATĄ, POMIDOREM I AWOKADO\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"idMeal\": 99,\n" +
                "                \"language\": \"PL\",\n" +
                "                \"mealTime\": \"LUNCH\",\n" +
                "                \"public\": true,\n" +
                "                \"shortDescription\": \"Przepis z Excel\",\n" +
                "                \"title\": \"KANAPKI Z MASŁEM ORZECHOWYM I BANANEM\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"idMeal\": 97,\n" +
                "                \"language\": \"PL\",\n" +
                "                \"mealTime\": \"SNACK\",\n" +
                "                \"public\": true,\n" +
                "                \"shortDescription\": \"Przepis z Excel\",\n" +
                "                \"title\": \"Sałatka z pomidora i ogórka kiszonego \"\n" +
                "            },\n" +
                "            {\n" +
                "                \"idMeal\": 16,\n" +
                "                \"language\": \"PL\",\n" +
                "                \"mealTime\": \"SUPPER\",\n" +
                "                \"public\": true,\n" +
                "                \"shortDescription\": \"Przepis z Excel\",\n" +
                "                \"title\": \"Bułka pełnoziarnistaz twarożkiem ze szczypiorkiem\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "    \t\"date\": \"2018-01-02T09:30:33.156Z\",        \t\n" +
                "        \"meals\": [\n" +
                "            {\n" +
                "                \"idMeal\": 43,\n" +
                "                \"language\": \"PL\",\n" +
                "                \"mealTime\": \"LUNCH\",\n" +
                "                \"public\": true,\n" +
                "                \"shortDescription\": \"Przepis z Excel\",\n" +
                "                \"title\": \"Kanapki z serkiem topionym\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"idMeal\": 51,\n" +
                "                \"language\": \"PL\",\n" +
                "                \"mealTime\": \"SUPPER\",\n" +
                "                \"public\": true,\n" +
                "                \"shortDescription\": \"Przepis z Excel\",\n" +
                "                \"title\": \"Kanapki z pasztetem i serem\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"idMeal\": 70,\n" +
                "                \"language\": \"PL\",\n" +
                "                \"mealTime\": \"BREAKFAST\",\n" +
                "                \"public\": true,\n" +
                "                \"shortDescription\": \"Przepis z Excel\",\n" +
                "                \"title\": \"Jogurt owocowy z suszonymi owocami\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"idMeal\": 88,\n" +
                "                \"language\": \"PL\",\n" +
                "                \"mealTime\": \"SNACK\",\n" +
                "                \"public\": true,\n" +
                "                \"shortDescription\": \"Przepis z Excel\",\n" +
                "                \"title\": \"Pomidorki koktajlowe \"\n" +
                "            },\n" +
                "            {\n" +
                "                \"idMeal\": 101,\n" +
                "                \"language\": \"PL\",\n" +
                "                \"mealTime\": \"DINNER\",\n" +
                "                \"public\": true,\n" +
                "                \"shortDescription\": \"Przepis z Excel\",\n" +
                "                \"title\": \"LECZO Z KURCZAKIEM I RYŻEM\"\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "]";

        //when

        ResponseEntity<DayDTO> dayDTOResponseEntity = restTemplate.postForEntity(serverAddress + subDomain, excampleJson, DayDTO.class);

        //then
        Assert.assertEquals(HttpStatus.NO_CONTENT.value(), dayDTOResponseEntity.getStatusCode().value());

    }
}
