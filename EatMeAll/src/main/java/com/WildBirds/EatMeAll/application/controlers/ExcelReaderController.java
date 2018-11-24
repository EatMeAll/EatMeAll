package com.WildBirds.EatMeAll.application.controlers;


import com.aplication.ExcelReaderApp;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;

@Path("")
public class ExcelReaderController {

    @EJB
    ExcelReaderApp excelReaderApp;

    @GET
    @Path("excel")
    public Response hello(@Context UriInfo info) {

        System.out.println("Read from excel");
        try {
            excelReaderApp.addToDatabase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Response.status(200).entity("You successfully imported date from Excel").build();
    }

}
