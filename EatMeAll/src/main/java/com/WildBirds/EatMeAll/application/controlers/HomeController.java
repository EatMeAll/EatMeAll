package com.WildBirds.EatMeAll.application.controlers;


import com.WildBirds.EatMeAll.domain.services.Main;
import com.WildBirds.RepositoryJPA.application.RepositoryFacade;
import com.WildBirds.RepositoryJPA.domain.model.Meal;
import com.WildBirds.RepositoryJPA.domain.model.MealHasProduct;
import com.WildBirds.RepositoryJPA.domain.model.Product;
import com.WildBirds.RepositoryJPA.domain.model.enums.Language;
import com.aplication.ExcelReaderApp;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;

@Path("")
public class HomeController {


    @EJB
    Main mainLocal;

    @EJB
    RepositoryFacade repo;

    @EJB
    ExcelReaderApp excelReaderApp;

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

        mealsToRepository();

        return Response.status(200).entity("Hello world").build();
    }
    @GET
    @Path("test")
    public Response test(@Context UriInfo info) {
        System.out.println("test2");

        Meal meal = repo.MEAL().get(1);
        return Response.status(200).entity(meal.toString()).build();
    }


    private void mealsToRepository(){
        try {
            excelReaderApp.addToDatabase();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
