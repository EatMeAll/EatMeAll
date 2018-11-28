package com.WildBirds.EatMeAll.application.controlers;


import com.WildBirds.EatMeAll.application.DTO.full_.MealDTO;
import com.WildBirds.EatMeAll.application.controlers.service.handler.ResponseStrategy;
import com.WildBirds.EatMeAll.application.service.Mapper;
import com.WildBirds.RepositoryJPA.application.RepositoryFacade;
import com.WildBirds.RepositoryJPA.domain.model.Meal;
import com.WildBirds.RepositoryJPA.domain.model.enums.Language;
import com.WildBirds.RepositoryJPA.domain.model.enums.MealTime;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.List;

@Path("meals")
public class MealController {


    @EJB
    Mapper mapper;

    @EJB
    RepositoryFacade repo;

    @GET
    @Path("")
    @Produces({"application/json; charset=UTF-8"})
    public Response getMeal(@Context UriInfo info) {
        return new ResponseStrategy().form(info)
                .when("from", "to")
                .execute(params -> {

                    Integer from = Integer.valueOf(params.getFirst("from"));
                    Integer to = Integer.valueOf(params.getFirst("to"));

                    List<Meal> all = repo.MEAL().getAll(from, to - from);
                    List<MealDTO> mealDTOList = mapper.toMealDTO(all);

                    return Response.status(Response.Status.OK).entity(mealDTOList).build();
                }).ultimately(params -> {
                    List<Meal> all = repo.MEAL().getAll();
                    List<MealDTO> mealDTOList = mapper.toMealDTO(all);

                    return Response.status(Response.Status.OK).entity(mealDTOList).build();
                });

    }

    @GET
    @Produces({"application/json; charset=UTF-8"})
    @Path("{idMeal}")
    public Response getId(@Context UriInfo info, @PathParam("idMeal") Integer idMeal) {

        Meal meal = repo.MEAL().get(idMeal);

        List<Meal> mealList = new ArrayList<>();
        mealList.add(meal);

        List<MealDTO> mealDTOList = mapper.toMealDTO(mealList);

        return Response.status(Response.Status.OK).entity(mealDTOList).build();

    }

    @GET
    @Path("find")
    public Response test(@Context UriInfo info, @QueryParam("typeMeal") String typeMeal) {
        System.out.println("method 1");
        if (typeMeal != null) {
            MealTime mealTime = MealTime.valueOf(typeMeal);

            List<Meal> mealsByMealTeam = repo.MEAL().getMealsByTypeMeal(mealTime);
            return Response.status(Response.Status.OK).entity(mealsByMealTeam.toString()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("").build();
    }

    @GET
    @Path("typeMeal")
    @Produces({"application/json; charset=UTF-8"})
    public Response test1(@Context UriInfo info) {

        return new ResponseStrategy().form(info)
                //http://localhost:8080/app/meals/typeMeal?typeMeal=DINNER&language=PL&amount=2&isPublic=true&products=czosnek&products=marchew&products=%C5%9Bmietana
                .when("typeMeal", "language", "amount", "isPublic", "products").execute((map) -> {


                    String typeMeal = map.getFirst("typeMeal");
                    MealTime mealTime = MealTime.valueOf(typeMeal);

                    String language = map.getFirst("language");
                    Language languageENUM = Language.valueOf(language);

                    Integer amount = Integer.valueOf(map.getFirst("amount"));
                    Boolean isPublic = Boolean.getBoolean(map.getFirst("isPublic"));
                    List<String> listProducts = map.get("products");

//                    List<MealDTO> mealDTOList = mealServiceTypeMeal.getMeals
//                            (mealTime, languageENUM, amount, isPublic, listProducts);


                    return Response.status(Response.Status.OK).entity(
                            String.format("RANDOM MEAL ORDER BY: typeMeal, language, amount, isPublic" +
                                            "\n typeMeal=%s language=%s amount=%s isPublic=%s products=%s",
                                    mealTime, languageENUM, amount, isPublic, listProducts)).build();

                })
                .when("typeMeal", "language", "amount", "isPublic").execute((map) -> {

                    String typeMeal = map.getFirst("typeMeal");
                    MealTime mealTime = MealTime.valueOf(typeMeal);

                    String language = map.getFirst("language");
                    Language languageENUM = Language.valueOf(language);

                    Integer amount = Integer.valueOf(map.getFirst("amount"));

                    //todo : return ALWAYS FALSE ?!?!
                    Boolean isPublic = Boolean.getBoolean(map.getFirst("isPublic"));

//                    List<MealDTO> mealDTOList = mealServiceTypeMeal.getMeals
//                            (mealTime, languageENUM, amount, isPublic);

                    return Response.status(Response.Status.OK).entity(
                            String.format("RANDOM MEAL ORDER BY: typeMeal,language,amount ,isPublic" +
                                            "\n typeMeal=%s language=%s amount=%s isPublic= %s",
                                    typeMeal, languageENUM, amount, isPublic)).build();

                })
                .when("typeMeal", "language", "amount").execute((map) -> {

                    String typeMeal = map.getFirst("typeMeal");
                    MealTime mealTime = MealTime.valueOf(typeMeal);

                    String language = map.getFirst("language");
                    Language languageENUM = Language.valueOf(language);

                    Integer amount = Integer.valueOf(map.getFirst("amount"));

//                    List<MealDTO> mealDTOList = mealServiceTypeMeal.getMeals
//                            (mealTime, languageENUM, amount);

                    List<Meal> mealsByTypeMeal = repo.MEAL().getMealsByTypeMeal(mealTime, languageENUM, amount);

                    System.out.println(mealsByTypeMeal.toString());
                    List<MealDTO> mealDTOList = mapper.toMealDTO(mealsByTypeMeal);

                    System.out.println(mealDTOList.toString());

                    return Response.status(Response.Status.OK).entity(mealDTOList).build();
                })
                .when("typeMeal", "language").execute((map) -> {

                    String typeMeal = map.getFirst("typeMeal");
                    MealTime mealTime = MealTime.valueOf(typeMeal);

                    String language = map.getFirst("language");
                    Language languageENUM = Language.valueOf(language);

                    List<Meal> mealsByTypeMeal = repo.MEAL().getMealsByTypeMeal(mealTime, languageENUM);

                    List<MealDTO> mealDTOList = mapper.toMealDTO(mealsByTypeMeal);
                    return Response.status(Response.Status.OK).entity(mealDTOList).build();

//                    return Response.status(HttpStatus.OK.getCode()).entity(
//                            String.format("RANDOM MEAL ORDER BY: Amount language, typeMeal" +
//                                            "\n typeMeal= %s language= %s ",
//                                    mealTime, languageENUM)).build();
                })
                .when("typeMeal").execute((map) -> {

                    String typeMeal = map.getFirst("typeMeal");
                    MealTime mealTime = MealTime.valueOf(typeMeal);

                    List<Meal> mealsByMealTeam = repo.MEAL().getMealsByTypeMeal(mealTime);
                    List<MealDTO> mealDTOList = mapper.toMealDTO(mealsByMealTeam);

                    return Response.status(Response.Status.OK).entity(mealDTOList).build();
                })
                .ultimately(params -> {
                    return Response.status(Response.Status.NOT_FOUND).header("Error", "Not match - you have to pass param").build();
                });
    }


}
