package com.WildBirds.EatMeAll.application.controlers;



import com.WildBirds.EatMeAll.application.controlers.service.handler.ResponseStrategy;
import com.WildBirds.EatMeAll.application.controlers.utils.HttpStatus;
import com.WildBirds.EatMeAll.application.modelDTO.*;
import com.WildBirds.RepositoryJPA.application.RepositoryFacade;
import com.WildBirds.RepositoryJPA.domain.model.Meal;
import com.WildBirds.RepositoryJPA.domain.model.enums.Language;
import com.WildBirds.RepositoryJPA.domain.model.enums.MealTime;
import com.WildBirds.RepositoryJPA.domain.model.enums.UserType;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Path("meals")
public class MealController {


    @EJB
    RepositoryFacade repo;

//    @EJB
//    MealServiceTypeMeal mealServiceTypeMeal;

    @GET
    @Path("all")
    public Response hello(@Context UriInfo info) {

        List<Meal> all = repo.MEAL().getAll();
        return Response.status(200).entity(all.toString()).build();
    }

    @GET
    @Path("find")
    public Response test(@Context UriInfo info, @QueryParam("typeMeal") String typeMeal) {
        System.out.println("method 1");
        if (typeMeal != null) {
            MealTime mealTime = MealTime.valueOf(typeMeal);

            List<Meal> mealsByMealTeam = repo.MEAL().getMealsByMealTeam(mealTime);
            return Response.status(200).entity(mealsByMealTeam.toString()).build();

//                List<Meal> mealsByMealTeam = repo.MEAL().getMealsByMealTeam(MealTime.valueOf(value));

      }
        return Response.status(404).entity("").build();
    }

    @GET
    @Path("typeMeal")
    @Produces("application/json; charset=UTF-8")
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


                    return Response.status(HttpStatus.OK.getCode()).entity(
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

                    return Response.status(HttpStatus.OK.getCode()).entity(
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

                    return Response.status(HttpStatus.OK.getCode()).entity(
                            String.format("RANDOM MEAL ORDER BY: typeMeal, language, amount  " +
                                            "\n typeMeal=%s, language=%s amount=%s ",
                                    typeMeal, languageENUM, amount)).build();
                })
                .when("typeMeal", "language").execute((map) -> {

                    String typeMeal = map.getFirst("typeMeal");
                    MealTime mealTime = MealTime.valueOf(typeMeal);

                    String language = map.getFirst("language");
                    Language languageENUM = Language.valueOf(language);
//                    Language languageENUM = Language.PL;

//                    List<MealDTO> mealDTOList = mealServiceTypeMeal.getMeals
//                            (mealTime, languageENUM);
                    List<Meal> mealsByTypeMeal = repo.MEAL().getMealsByTypeMeal(mealTime, languageENUM);

                    System.out.println(mealsByTypeMeal.toString());
                    return Response.status(HttpStatus.OK.getCode()).entity(mealsByTypeMeal.toString()).build();

//                    return Response.status(HttpStatus.OK.getCode()).entity(
//                            String.format("RANDOM MEAL ORDER BY: Amount language, typeMeal" +
//                                            "\n typeMeal= %s language= %s ",
//                                    mealTime, languageENUM)).build();
                })
                .when("typeMeal").execute((map) -> {

                    String typeMeal = map.getFirst("typeMeal");
                    MealTime mealTime = MealTime.valueOf(typeMeal);


                    List<Meal> mealsByMealTeam = repo.MEAL().getMealsByMealTeam(mealTime);
                    return Response.status(200).entity(mealsByMealTeam.toString()).build();

                })
                .ultimately(params -> {
                    return Response.status(HttpStatus.NOT_FOUND.getCode()).entity("Not match").build();
                });
    }


    @GET
    @Path("sample")
    @Produces("application/json; charset=UTF-8")
    public Response getMeal(@Context UriInfo info) {
        MealDTO mealDTO = new MealDTO();

        StepDTO stepDTO1 = new StepDTO();
        stepDTO1.setHeader("Tresc pierwszego kroku");
        stepDTO1.setNumber(1);

        StepDTO stepDTO2 = new StepDTO();
        stepDTO2.setHeader("Tresc kroku drugiego");
        stepDTO2.setNumber(2);
        List<StepDTO> stepDTOList = new ArrayList<>();
        stepDTOList.add(stepDTO1);
        stepDTOList.add(stepDTO2);

        ReceiptDTO receiptDTO = new ReceiptDTO();
        receiptDTO.setTitle("TytulRecepty");
        receiptDTO.setDescription("Opis recepty");
        receiptDTO.setPrepareTime(15);
        receiptDTO.setSteps(stepDTOList);

        TypeMealDTO typeMealDTO = new TypeMealDTO();
        typeMealDTO.setIdTypeMeal(1);
        typeMealDTO.setMealTime(MealTime.BREAKFAST);

        List<TypeMealDTO> typeMealDTOList = new ArrayList<>();
        typeMealDTOList.add(typeMealDTO);

        UserDTO userDTO = new UserDTO();

        userDTO.setIdUser(1);
        userDTO.setEmail("email@wp.pl");
        userDTO.setNick("TestREST");
        userDTO.setUserType(UserType.ADMIN);


        ProductDTO productDTO1 = new ProductDTO();
        productDTO1.setName("Marchew");
        productDTO1.setAmount(200);
        productDTO1.setUnit("g");
        productDTO1.setSpecialUnit("1/2 łyżki");

        ProductDTO productDTO2 = new ProductDTO();
        productDTO2.setName("Gruszka");
        productDTO2.setAmount(100);
        productDTO2.setUnit("kg");
        productDTO2.setSpecialUnit("1/2 słoja");

        List<ProductDTO> productDTOList = new ArrayList<>();

        productDTOList.add(productDTO1);
        productDTOList.add(productDTO2);

        MealDTO mealDTO1 =
                new MealDTO(1,
                        Language.PL,
                        "Tytul",
                        "ShortMessage",
                        300,
                        "Igor",
                        null,
                        true,
                        Instant.now(),
                        receiptDTO,
                        typeMealDTOList,
                        userDTO,
                        productDTOList,
                        15,
                        "DodatkowyOpis");


        return Response.status(HttpStatus.OK.getCode()).entity(mealDTO1).build();
    }

}
