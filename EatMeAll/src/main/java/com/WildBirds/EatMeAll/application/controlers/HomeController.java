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
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.*;
import java.nio.file.Files;

@Path("")
public class HomeController {


    @EJB
    Main mainLocal;

    @EJB
    RepositoryFacade repo;

    @EJB
    ExcelReaderApp excelReaderApp;

    @GET
    @Path("excel")
    public Response hello(@Context UriInfo info) {

        mainLocal.HelloWorld();
        System.out.println("in home controller");

        try {
            excelReaderApp.addToDatabase();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Response.status(200).entity("You successfully imported date from Excel").build();
    }

    @GET
    @Path("test")
    @Produces(MediaType.MEDIA_TYPE_WILDCARD)
    public Response test(@Context UriInfo info) throws IOException {

        Meal meal = repo.MEAL().get(5);

        System.out.println(meal);

        File photo = meal.getPhoto();


        BufferedReader br = new BufferedReader(new FileReader(photo));

        StringBuilder sb = new StringBuilder();
        String st;
        while ((st = br.readLine()) != null){
            System.out.println(st);
            sb.append(st);

        }


        return Response.status(200).type(Files.probeContentType(photo.toPath())).entity(sb.toString()).build();
    }
}
