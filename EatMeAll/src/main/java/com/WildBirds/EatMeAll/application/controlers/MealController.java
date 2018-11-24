package com.WildBirds.EatMeAll.application.controlers;


import com.WildBirds.EatMeAll.application.controlers.service.handler.ResponseStrategy;
import com.WildBirds.EatMeAll.application.controlers.utils.HttpStatus;
import com.WildBirds.EatMeAll.application.DTO.*;
import com.WildBirds.EatMeAll.application.service.Mapper;
import com.WildBirds.RepositoryJPA.application.RepositoryFacade;
import com.WildBirds.RepositoryJPA.domain.model.Meal;
import com.WildBirds.RepositoryJPA.domain.model.enums.Language;
import com.WildBirds.RepositoryJPA.domain.model.enums.MealTime;
import com.WildBirds.RepositoryJPA.domain.model.enums.UserType;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.File;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Path("meals")
public class MealController {


    @EJB
    Mapper mapper;

    @EJB
    RepositoryFacade repo;

    @GET
    @Path("")
    public Response hello(@Context UriInfo info) {
        return  new ResponseStrategy().form(info)
                .when("from","to")
                .execute(params -> {

                    Integer from = Integer.valueOf(params.getFirst("from"));
                    Integer to = Integer.valueOf(params.getFirst("to"));
                    List<Meal> all = repo.MEAL().getAll(from,to-from);
                    return Response.status(HttpStatus.OK.getCode()).entity(all.toString()).build();

                }).ultimately(params -> {
                    List<Meal> all = repo.MEAL().getAll();
                    return Response.status(HttpStatus.OK.getCode()).entity(all.toString()).build();
                });

    }

    @GET
    @Produces({"application/json; charset=UTF-8"})
    @Path("{idMeal}")
    public Response getId(@Context UriInfo info, @PathParam("idMeal") Integer idMeal){

        Meal meal = repo.MEAL().get(idMeal);

        List<Meal> mealList = new ArrayList<>();
        mealList.add(meal);

        List<MealDTO> mealDTOList = mapper.toMealDTO(mealList);

        return Response.status(HttpStatus.OK.getCode()).entity(mealDTOList).build();

    }

    @GET
    @Path("find")
    public Response test(@Context UriInfo info, @QueryParam("typeMeal") String typeMeal) {
        System.out.println("method 1");
        if (typeMeal != null) {
            MealTime mealTime = MealTime.valueOf(typeMeal);

            List<Meal> mealsByMealTeam = repo.MEAL().getMealsByTypeMeal(mealTime);
            return Response.status(HttpStatus.OK.getCode()).entity(mealsByMealTeam.toString()).build();



        }
        return Response.status(HttpStatus.NOT_FOUND.getCode()).entity("").build();
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

                    List<Meal> mealsByTypeMeal = repo.MEAL().getMealsByTypeMeal(mealTime, languageENUM, amount);

                    System.out.println(mealsByTypeMeal.toString());
                    List<MealDTO> mealDTOList = mapper.toMealDTO(mealsByTypeMeal);

                    System.out.println(mealDTOList.toString());

                    return Response.status(HttpStatus.OK.getCode()).entity(mealDTOList).build();
                })
                .when("typeMeal", "language").execute((map) -> {

                    String typeMeal = map.getFirst("typeMeal");
                    MealTime mealTime = MealTime.valueOf(typeMeal);

                    String language = map.getFirst("language");
                    Language languageENUM = Language.valueOf(language);

                    List<Meal> mealsByTypeMeal = repo.MEAL().getMealsByTypeMeal(mealTime, languageENUM);

                    List<MealDTO> mealDTOList = mapper.toMealDTO(mealsByTypeMeal);
                    return Response.status(HttpStatus.OK.getCode()).entity(mealDTOList).build();

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


//                    MealDTO mealDTO = mealDTOList.get(1);
//                    System.out.println(mealDTO.toString());
                    return Response.status(HttpStatus.OK.getCode()).entity(mealDTOList).build();

                })
                .ultimately(params -> {
                    return Response.status(HttpStatus.NOT_FOUND.getCode()).entity("Not match").build();
                });
    }


    @GET
    @Path("photo/{idPhoto}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response getFile(@Context UriInfo info, @PathParam("idPhoto") Integer idPhoto) {

        File file = repo.MEAL().getFile(idPhoto);
        return Response.ok(file, MediaType.APPLICATION_OCTET_STREAM)
                .header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"" ) //optional
                .build();
    }


    @GET
    @Path("sample")
    @Produces("application/json; charset=UTF-8")
    public Response getMeal(@Context UriInfo info) {

        StepDTO stepDTO1 = new StepDTO();
        stepDTO1.setHeader("Tresc pierwszego kroku");
        stepDTO1.setNumber(1);

        StepDTO stepDTO2 = new StepDTO();
        stepDTO2.setHeader("Tresc kroku drugiego");
        stepDTO2.setNumber(2);
        Set<StepDTO> stepDTOList = new HashSet<>();
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

        Set<TypeMealDTO> typeMealDTOSet = new HashSet<>();
        typeMealDTOSet.add(typeMealDTO);

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

        Set<ProductDTO> productDTOSet = new HashSet<>();

        productDTOSet.add(productDTO1);
        productDTOSet.add(productDTO2);

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
                        typeMealDTOSet,
                        userDTO,
                        productDTOSet);


        return Response.status(HttpStatus.OK.getCode()).entity(mealDTO1).build();
    }




}
