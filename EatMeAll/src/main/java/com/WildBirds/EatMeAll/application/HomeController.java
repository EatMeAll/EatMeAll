package com.WildBirds.EatMeAll.application;

import com.WildBirds.EatMeAll.domain.services.MainLocal;
import com.WildBirds.EatMeAll.infrastructure.RepositoryMealAdapter;

import javax.ejb.EJB;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.Arrays;

@Path("")
public class HomeController {

    @EJB
    private MainLocal main;

    @EJB
    private RepositoryMealAdapter repositoryMealAdapter;

    @GET
    @Path("home")
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Response hello(@Context UriInfo info) {
        main.HelloWorld();

        System.out.println("in home controller");

        Product milk = new Product();
        milk.setName("Milk");

        MealHasProduct mealHasProduct = new MealHasProduct();
        mealHasProduct.setProduct(milk);
        mealHasProduct.setAmount(100);
        mealHasProduct.setUnit("ml");

        Meal meal = new Meal();
        meal.setMealHasProductList(Arrays.asList(mealHasProduct));
        meal.setLanguage(Language.PL);


        repositoryMealAdapter.insert(meal);
//        repositoryMealAdapter.insert(milk,Product.class);
//        repositoryMealAdapter.insert(mealHasProduct,MealHasProduct.class);

        return Response.status(200).entity("Hello world").build();
    }
    @GET
    @Path("test")
    public Response test(@Context UriInfo info) {
        System.out.println("test2");
        return Response.status(200).entity("test").build();
    }
}
