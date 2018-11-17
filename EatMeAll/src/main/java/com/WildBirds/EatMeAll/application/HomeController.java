package com.WildBirds.EatMeAll.application;

import com.WildBirds.EatMeAll.domain.services.Main;
import com.WildBirds.RepositoryJPA.application.RepositoryFacade;
import com.WildBirds.RepositoryJPA.domain.model.Meal;
import com.WildBirds.RepositoryJPA.domain.model.MealHasProduct;
import com.WildBirds.RepositoryJPA.domain.model.Product;
import com.WildBirds.RepositoryJPA.domain.model.enums.Language;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("")
public class HomeController {


    @EJB
    Main mainLocal;

    @EJB
    RepositoryFacade repo;

    @GET
    @Path("home")
    public Response hello(@Context UriInfo info) {

        mainLocal.HelloWorld();
        System.out.println("in home controller");

        Product milk = new Product();
        milk.setName("Milk");

        MealHasProduct mealHasProduct = new MealHasProduct();
        mealHasProduct.setProduct(milk);
        mealHasProduct.setAmount(100);
        mealHasProduct.setUnit("ml");

        Meal meal = new Meal();
        meal.setLanguage(Language.PL);

        repo.PRODUCT().insert(milk);
        repo.MEALHASPRODUCT().insert(mealHasProduct);
        repo.MEAL().insert(meal);


        return Response.status(200).entity("Hello world").build();
    }
    @GET
    @Path("test")
    public Response test(@Context UriInfo info) {
        System.out.println("test2");
        return Response.status(200).entity("test").build();
    }
}
