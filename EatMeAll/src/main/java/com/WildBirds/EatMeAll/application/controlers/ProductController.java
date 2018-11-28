package com.WildBirds.EatMeAll.application.controlers;

import com.WildBirds.EatMeAll.application.DTO.full_.ProductDTO;
import com.WildBirds.EatMeAll.application.controlers.utils.HttpStatus;
import com.WildBirds.EatMeAll.application.service.Mapper;
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

    @EJB
    Mapper mapper;

    @GET
    @Path("{id}")
    public Response getOne(@Context UriInfo info, @PathParam("id") Integer id) {

        try {
            Product product = repo.PRODUCT().get(id);

            ProductDTO productDTO = mapper.toProductBasicDTO(product);

            return Response.status(HttpStatus.OK.getCode()).entity(productDTO).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(HttpStatus.NOT_FOUND.getCode()).header("Error", "Product is not excise in db").build();
        }


    }

    @GET
    @Path("all")
    public Response getAll(@Context UriInfo info) {

        List<Product> all = repo.PRODUCT().getAll();
        return Response.status(200).entity(all.toString()).build();
    }



}
