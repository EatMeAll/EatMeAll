package com.WildBirds.EatMeAll.application.controlers;


import com.WildBirds.EatMeAll.application.DTO.full_.ProductDTO;
import com.WildBirds.EatMeAll.application.service.Mapper;
import com.WildBirds.RepositoryJPA.application.RepositoryFacade;
import com.WildBirds.RepositoryJPA.domain.model.Product;

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
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

            Set<Product> productSet = repo.PRODUCT().getProductsList(fromDate, toDate, idUser);
            Set<ProductDTO> productDTOSet = new HashSet<>();

            for (Product product : productSet) {
                ProductDTO productDTO = mapper.toProductBasicDTO(product);
                productDTOSet.add(productDTO);
            }

            return Response.status(Response.Status.OK)
                    .header("OK", "Set of products from "
                            + fromDateString + " to " + toDateString)
                    .entity(productDTOSet).build();
        } catch (ParseException e) {
            e.printStackTrace();
            return Response.status(Response.Status.METHOD_NOT_ALLOWED).header("Error", "Invalid syntax on date").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.NOT_FOUND).header("Error", "Not found").build();
        }
    }
}
