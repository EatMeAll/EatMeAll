package com.WildBirds.EatMeAll.application.controlers;


import com.WildBirds.EatMeAll.application.DTO.short_.MealShortDTO;
import com.WildBirds.EatMeAll.application.service.Mapper;
import com.WildBirds.RepositoryJPA.application.RepositoryFacade;
import com.WildBirds.RepositoryJPA.domain.model.Meal;

import javax.ejb.EJB;
import javax.ejb.EJBTransactionRolledbackException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

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

            MealShortDTO mealShortDTO = mapper.toMealDTOShortFull(meal);


            return Response.status(Response.Status.OK).header("OK", "Meal in short_ view").entity(mealShortDTO).build();
        } catch (EJBTransactionRolledbackException e) {
            e.printStackTrace();
            return Response.status(Response.Status.NOT_FOUND).header("Error", "Meal not found in db").build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).header("Error", "Invalid syntax").build();
        }
    }
}
