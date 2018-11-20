package com.WildBirds.RepositoryJPA.infrastructure;


import com.WildBirds.RepositoryJPA.domain.model.Meal;
import com.WildBirds.RepositoryJPA.domain.model.enums.Language;
import com.WildBirds.RepositoryJPA.domain.model.enums.MealTime;
import com.WildBirds.RepositoryJPA.domain.ports.RepositoryMeal;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RepositoryJPAtest {


//    @Test
//    public void shouldDeleteMessageAndThrowExceptionNotFound() {
//
//        try {
//            //given
//            Message message = new Message();
//            message.setContent("Testing content ");
//            message.setIdReceiver(1L);
//            message.setIdSender(2L);
//            message.setSentDate(Instant.now());
//
//
//            //when
//            messageRepositoryMySQL.saveMessage(message);
//            messageRepositoryMySQL.deleteMessageBy(1L);
//
//            //then
//            Executable code = () -> {
//                messageRepositoryMySQL.fetchMessageBy(1L);
//            };
//            assertThrows(MessagesNotFoundException.class, code);
//            log.info("Success test : shouldDeleteMessageAndThrowExceptionNotFound");
//        } catch (Exception e) {
//            e.printStackTrace();
//            log.error(e.toString());
//        }
//
//    }

    RepositoryMeal repositoryMeal = new RepositoryMealJPA();


    @Test
    public void shouldReturnListMealDividedByMealTimeLanguageAmountIsPublicListProducts() {

        //given
        MealTime mealTime = MealTime.BREAKFAST;
        Language language = Language.PL;
        Integer amount = 7;
        Boolean isPublic = true;

        String product1 = "otreby przenne";
        String product2 = "Jogurt owocowy";

        List<String> listProducts = new ArrayList<>();
        listProducts.add(product1);
        listProducts.add(product2);

        //when
        List<Meal> mealsByTypeMeal = repositoryMeal.getMealsByTypeMeal(mealTime, language, amount, isPublic, listProducts);

        //then
        assertNotNull(mealsByTypeMeal);
    }


    @Test
    public void shouldReturnListMealDividedByMealTimeLanguageAmountIsPublic() {
        //given

        MealTime mealTime = MealTime.BREAKFAST;
        Language language = Language.PL;
        Integer amount = 7;
        Boolean isPublic = true;

        //when
        List<Meal> mealsByTypeMeal = repositoryMeal.getMealsByTypeMeal(mealTime, language, amount, isPublic);

        //then
        assertNotNull(mealsByTypeMeal);
    }

    @Test
    public void shouldReturnListMealDividedByMealTimeLanguageAmount() {
        //given

        MealTime mealTime = MealTime.BREAKFAST;
        Language language = Language.PL;
        Integer amount = 7;


        //when
        List<Meal> mealsByTypeMeal = repositoryMeal.getMealsByTypeMeal(mealTime, language, amount);

        //then

        assertNotNull(mealsByTypeMeal);

    }

    @Test
    public void shouldReturnListMealDividedByMealTimeLanguage() {

        MealTime mealTime = MealTime.BREAKFAST;
        Language language = Language.PL;

        //when
        List<Meal> mealsByTypeMeal = repositoryMeal.getMealsByTypeMeal(mealTime, language);

        //then
                assertNotNull(mealsByTypeMeal);

    }

    @Test
    public void shouldReturnListMealDividedByMealTime() {
        //given
        MealTime mealTime = MealTime.BREAKFAST;

        //when
        List<Meal> mealsByMealTeam = repositoryMeal.getMealsByTypeMeal(mealTime);

        //then
        assertNotNull(mealsByMealTeam);

    }
}
