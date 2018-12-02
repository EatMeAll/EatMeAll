package com.WildBirds.EatMeAll.application.controlers;


import com.WildBirds.EatMeAll.application.DTO.full_.MealDTO;
import com.WildBirds.EatMeAll.application.DTO.short_.MealShortDTO;
import com.WildBirds.EatMeAll.application.DTO.unit_.MealUnitDTO;
import com.WildBirds.EatMeAll.application.controlers.service.handler.ResponseStrategy;
import com.WildBirds.EatMeAll.application.service.Mapper;
import com.WildBirds.RepositoryJPA.application.RepositoryFacade;
import com.WildBirds.RepositoryJPA.domain.model.Meal;
import com.WildBirds.RepositoryJPA.domain.model.enums.Language;
import com.WildBirds.RepositoryJPA.domain.model.enums.MealTime;

import javax.ejb.EJB;
import javax.ejb.EJBTransactionRolledbackException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.List;

@Path("meals/short")
public class MealShortController {


    @EJB
    Mapper mapper;

    @EJB
    RepositoryFacade repo;


    @GET
    @Path("{id}")
    @Produces({"application/json; charset=UTF-8"})
    public Response getShortMeal(@Context UriInfo info, @PathParam("id") Integer id){

        try {
            Meal meal = repo.MEAL().get(id);

            MealShortDTO mealShortDTO = mapper.toMealShortDTO(meal);


            return Response.status(Response.Status.OK).header("OK", "Meal in short_ view").entity(mealShortDTO).build();
        } catch (EJBTransactionRolledbackException e) {
            e.printStackTrace();
            return Response.status(Response.Status.NOT_FOUND).header("Error", "Meal not found in db").build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).header("Error", "Invalid syntax").build();
        }
    }

    @GET
    @Path("mealTime")
    @Produces({"application/json; charset=UTF-8"})
    public Response getByType(@Context UriInfo info) {

        return new ResponseStrategy().form(info)
                .when("mealTime", "language", "amount", "isPublic", "products").execute((map) -> {
                    String mealTimeMap = map.getFirst("mealTime");
                    MealTime mealTime = MealTime.valueOf(mealTimeMap);

                    String languageMap = map.getFirst("language");
                    Language language = Language.valueOf(languageMap);


                    String amountMap = map.getFirst("amount");
                    Integer amount = Integer.valueOf(amountMap);


                    String isPublicMap = map.getFirst("isPublic");
                    Boolean isPublic = Boolean.valueOf(isPublicMap);

                    List<String> productsList = map.get("products");


                    List<Meal> mealsByTypeMeal = repo.MEAL().getMealsByTypeMeal(mealTime, language, amount, isPublic, productsList);
                    List<MealDTO> mealDTOList = mapper.toMealDTO(mealsByTypeMeal);

                    return Response.status(Response.Status.OK)
                            .header("OK", "List meals order by mealTime, language and amount")
                            .entity(mealDTOList)
                            .build();
                })
                .when("mealTime", "language", "amount", "isPublic").execute((map) -> {
                    String mealTimeMap = map.getFirst("mealTime");
                    MealTime mealTime = MealTime.valueOf(mealTimeMap);

                    String languageMap = map.getFirst("language");
                    Language language = Language.valueOf(languageMap);


                    String amountMap = map.getFirst("amount");
                    Integer amount = Integer.valueOf(amountMap);


                    String isPublicMap = map.getFirst("isPublic");
                    Boolean isPublic = Boolean.valueOf(isPublicMap);


                    List<Meal> mealsByTypeMeal = repo.MEAL().getMealsByTypeMeal(mealTime, language, amount, isPublic);
                    List<MealDTO> mealDTOList = mapper.toMealDTO(mealsByTypeMeal);

                    return Response.status(Response.Status.OK)
                            .header("OK", "List meals order by mealTime, language and amount")
                            .entity(mealDTOList)
                            .build();
                })
                .when("mealTime", "language", "amount").execute((map) -> {
                    String mealTimeMap = map.getFirst("mealTime");
                    MealTime mealTime = MealTime.valueOf(mealTimeMap);

                    String languageMap = map.getFirst("language");
                    Language language = Language.valueOf(languageMap);


                    String amountMap = map.getFirst("amount");
                    Integer amount = Integer.valueOf(amountMap);
                    System.out.println(amount.toString());

                    List<Meal> mealsByTypeMeal = repo.MEAL().getMealsByTypeMeal(mealTime, language, amount);

                    List<MealShortDTO> mealShortDTOList = new ArrayList<>();
                    for (Meal meal : mealsByTypeMeal) {

                        MealShortDTO mealShortDTO = mapper.toMealShortDTO(meal);
                        mealShortDTOList.add(mealShortDTO);
                    }

                    return Response.status(Response.Status.OK)
                            .header("OK", "List meals SHORT order by mealTime, language and amount")
                            .entity(mealShortDTOList)
                            .build();
                })
                .when("mealTime", "language").execute((map) -> {

                    String mealTimeMap = map.getFirst("mealTime");
                    MealTime mealTime = MealTime.valueOf(mealTimeMap);

                    String languageMap = map.getFirst("language");
                    Language language = Language.valueOf(languageMap);

                    List<Meal> mealsByTypeMeal = repo.MEAL().getMealsByTypeMeal(mealTime, language);
                    List<MealDTO> mealDTOList = mapper.toMealDTO(mealsByTypeMeal);

                    return Response.status(Response.Status.OK)
                            .header("OK", "List meals order by MealTime and Language")
                            .entity(mealDTOList).build();
                })
                .when("mealTime").execute((map) -> {

                    String mealTimeMap = map.getFirst("mealTime");

                    MealTime mealTime = MealTime.valueOf(mealTimeMap);

                    List<Meal> mealsByTypeMeal = repo.MEAL().getMealsByTypeMeal(mealTime);

                    List<MealDTO> mealDTOList = mapper.toMealDTO(mealsByTypeMeal);

                    return Response.status(Response.Status.OK)
                            .header("OK", "List meals short order by MealTime").entity(mealDTOList).build();

                }).ultimately(map -> {
                    return Response.status(Response.Status.NOT_FOUND).header("Error", "NOT FOUND").build();
                });


    }
}
