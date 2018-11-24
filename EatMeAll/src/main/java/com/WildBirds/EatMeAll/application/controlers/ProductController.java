package com.WildBirds.EatMeAll.application.controlers;

import com.WildBirds.RepositoryJPA.application.RepositoryFacade;
import com.WildBirds.RepositoryJPA.domain.model.Product;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Path("products")
public class ProductController {

    @EJB
    RepositoryFacade repo;

    @GET
    @Path("{id}")
    public Response getOne(@Context UriInfo info, @PathParam("id") Integer id) {

        Product product = repo.PRODUCT().get(id);
        return Response.status(200).entity(product.toString()).build();
    }

    @GET
    @Path("all")
    public Response getAll(@Context UriInfo info) {

        List<Product> all = repo.PRODUCT().getAll();
        return Response.status(200).entity(all.toString()).build();
    }



}
