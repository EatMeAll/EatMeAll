package com.WildBirds.EatMeAll.application;

import com.WildBirds.EatMeAll.domain.model.Meal;
import com.WildBirds.EatMeAll.domain.services.MainLocal;
import com.WildBirds.EatMeAll.infrastructure.RepositoryMealAdapterLocal;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("")
public class HomeController {

    @EJB
    private MainLocal main;

    @EJB
    private RepositoryMealAdapterLocal repositoryMealAdapter;

    @GET
    @Path("home")
    public Response hello(@Context UriInfo info) {
        main.HelloWorld();

        System.out.println("in home controller");
        repositoryMealAdapter.insert(new Meal());

        return Response.status(200).entity("Hello world").build();
    }
    @GET
    @Path("test")
    public Response test(@Context UriInfo info) {
        System.out.println("test2");
        return Response.status(200).entity("test").build();
    }
}
