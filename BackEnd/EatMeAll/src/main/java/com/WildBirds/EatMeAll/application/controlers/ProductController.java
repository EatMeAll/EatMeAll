package com.WildBirds.EatMeAll.application.controlers;

import com.WildBirds.EatMeAll.application.DTO.full_.ProductDTO;
import com.WildBirds.EatMeAll.application.service.Mapper;
import com.WildBirds.RepositoryJPA.application.RepositoryFacade;
import com.WildBirds.RepositoryJPA.domain.model.Product;
import lombok.var;

import javax.ejb.EJB;
import javax.ws.rs.*;
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
            ProductDTO productDTO = mapper.toProductDTO(product);

            return Response.status(Response.Status.OK).entity(productDTO).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.NOT_FOUND).header("Error", "Product is not excise in db").build();
        }
    }

    @GET
    @Path("all")
    public Response getAll(@Context UriInfo info) {

        List<Product> all = repo.PRODUCT().getAll();
        return Response.status(Response.Status.OK).entity(all.toString()).build();
    }

    @GET
    @Path("name/{name}")
    public Response getByName(@Context UriInfo info, @PathParam("name") String name){

        try {
            Product productName = repo.PRODUCT().getProductByName(name);

            if (productName == null){
                return Response.status(Response.Status.NOT_FOUND).header("Error", "Product not found").build();
            }
            return Response.status(Response.Status.OK).header("OK", "Got product by name").entity(productName).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.NOT_FOUND).header("Error", "NOT FOUND").build();
        }
    }

    @POST
    @Path("")
    @Consumes({"application/json; charset=UTF-8"})
    public Response saveNew(@Context UriInfo info, ProductDTO productDTO){

        String productDTOName = productDTO.getName();

        Product productByName = repo.PRODUCT().getProductByName(productDTOName);

        if (productByName == null){
            mapper.toProduct(productDTO);
            return Response.status(Response.Status.CREATED).header("OK", "Created new product").build();
        }else {
            return Response.status(Response.Status.CONFLICT).header("Error", "Product already exist").build();
        }

    }
}
