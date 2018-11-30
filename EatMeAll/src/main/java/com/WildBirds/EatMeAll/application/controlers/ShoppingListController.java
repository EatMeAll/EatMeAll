package com.WildBirds.EatMeAll.application.controlers;


import com.WildBirds.EatMeAll.application.DTO.unit_.ProductUnitDTO;
import com.WildBirds.EatMeAll.application.service.Mapper;
import com.WildBirds.RepositoryJPA.application.RepositoryFacade;
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


            // should remove only testing example meals
            List<Meal> mealList = new ArrayList<>();

            for (int i = 0; i < 4; i++) {

                Meal meal = repo.MEAL().get(i);
                mealList.add(meal);
            }


            List<MealHasProduct> mealHasProductList = repo.MEALHASPRODUCT().getProductsList(fromDate, toDate, mealList);

            List<ProductUnitDTO> productUnitDTOList = mapper.toProductUnitDTOList(mealHasProductList);


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
}
