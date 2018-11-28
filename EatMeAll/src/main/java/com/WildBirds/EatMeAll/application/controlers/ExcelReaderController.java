package com.WildBirds.EatMeAll.application.controlers;


import com.aplication.ExcelReaderApp;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.FileNotFoundException;
import java.io.IOException;

@Path("excel")
public class ExcelReaderController {

    @EJB
    ExcelReaderApp excelReaderApp;

    @GET
    @Path("")
    public Response read(@Context UriInfo info) {

        System.out.println("Read from excel");
        try {
            excelReaderApp.addToDatabase();
        } catch (FileNotFoundException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).header("Error", "FileNotFound").build();
        } catch (IOException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return Response.status(Response.Status.OK).entity("You successfully imported date from Excel").build();
    }

    @GET
    @Path("path")
    public Response readWithBasePath(@Context UriInfo info, @QueryParam("path") String path) {

        System.out.println("Read from excel");
        String lastPath = excelReaderApp.getBasePath();
        try {
            excelReaderApp.setBasePath(path);
            excelReaderApp.addToDatabase();
        } catch (FileNotFoundException e) {

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .header("Error", "FileNotFound - bad path")
                    .header("Example path",lastPath)
                    .build();
        } catch (IOException e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).build();
        } finally {
            excelReaderApp.setBasePath(lastPath);
        }
        return Response.status(Response.Status.OK).entity("You successfully imported date from Excel").build();
    }

}
