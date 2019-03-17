package com.WildBirds.EatMeAll.application.controlers;


import com.WildBirds.EatMeAll.application.DTO.full_.ShoppingListDTO;
import com.WildBirds.EatMeAll.application.DTO.unit_.ProductUnitDTO;
import com.WildBirds.EatMeAll.application.service.Mapper;
import com.WildBirds.RepositoryJPA.application.RepositoryFacade;
import com.WildBirds.RepositoryJPA.domain.model.Day;
import com.WildBirds.RepositoryJPA.domain.model.Meal;
import com.WildBirds.RepositoryJPA.domain.model.MealHasProduct;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Path("shoppingList")
public class ShoppingListController {


    @EJB
    RepositoryFacade repo;

    @EJB
    Mapper mapper;


    @GET
    @Produces({"application/json; charset=UTF-8"})
    @Path("{from}/{to}")
    public Response getProductsList(@Context UriInfo info, @PathParam("from") String fromDateString, @PathParam("to") String toDateString) {

        Integer idUser = 1;

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedDate = dateFormat.parse(fromDateString);
            Instant fromDate = parsedDate.toInstant();

            Date parsedDate2 = dateFormat.parse(toDateString);
            Instant toDate = parsedDate2.toInstant();

            List<Day> history = repo.DAY().getHistory(fromDate, toDate, idUser);

            List<Meal> mealList = mapper.toMealFromHistory(history);

            List<MealHasProduct> mealHasProductList = repo.MEALHASPRODUCT().getProductsList(mealList);

            List<ProductUnitDTO> productUnitDTOList = mapper.toShoppingList(mealHasProductList);


            return Response.status(Response.Status.OK)
                    .header("OK", "Set of products from "
                            + fromDateString + " to " + toDateString)
                    .entity(productUnitDTOList).build();
        } catch (ParseException e) {
            e.printStackTrace();
            return Response.status(Response.Status.METHOD_NOT_ALLOWED).header("Error", "Invalid syntax on date").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.NOT_FOUND).header("Error", "Not found").build();
        }
    }


    @GET
    @Produces({"application/json; charset=UTF-8"})
    @Path("/id/{idList}")
    public Response getProductListById(@PathParam("idList") String idList) {
        String[] strings = idList.split(",");
        System.out.println(">>>>>>>>>>> ID LIST" + idList);

        List<Meal> mealList = mapper.toMealOnlyIdMeal(strings);

        System.out.println(">>>>>>>>>>> ID MEAL LIST" + mealList);

        List<MealHasProduct> mealHasProductList = repo.MEALHASPRODUCT().getProductsList(mealList);
        System.out.println(">>>>>>>>>>> ID MEAL mealHasProductList" + mealHasProductList);

        List<ProductUnitDTO> productUnitDTOList = mapper.toShoppingList(mealHasProductList);

        return Response.status(Response.Status.OK)
                .header("OK", "List of products by id " + idList)
                .entity(productUnitDTOList).build();

    }

    @GET
    @Produces({"application/json; charset=UTF-8"})
    @Path("/order/id/{idList}")
    public Response getShoppingList(@PathParam("idList") String idList){
        System.out.println(">>>>>>>>>>> ID BEFORE SPLIT" + idList);
        String[] strings = idList.split(",");

        List<String> list = Arrays.asList(strings);
        System.out.println(">>>>>>>>>>> ID MEAL LIST" + list);

        List<MealHasProduct> mealHasProductList = repo.MEALHASPRODUCT().getProductsById(list);
        System.out.println(">>>>>>>>>>> ID MEAL mealHasProductList" + mealHasProductList);

        ShoppingListDTO result = mapper.toOrderShoppingList(mealHasProductList);
        return Response.status(Response.Status.OK)
                .header("OK", "List of products by categories " + idList)
                .entity(result).build();
    }
}
