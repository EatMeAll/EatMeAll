package com.WildBirds.EatMeAll.application.controlers;

import com.WildBirds.EatMeAll.application.controlers.utils.HttpStatus;
import com.WildBirds.EatMeAll.application.modelDTO.NewUserDTO;
import com.WildBirds.EatMeAll.application.modelDTO.UserDTO;
import com.WildBirds.EatMeAll.application.service.Mapper;
import com.WildBirds.RepositoryJPA.application.RepositoryFacade;
import com.WildBirds.RepositoryJPA.domain.model.User;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("users")
public class UserController {


    @EJB
    RepositoryFacade repo;

    @EJB
    Mapper mapper;


    @GET
    @Path("{idUser}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@Context UriInfo info, @PathParam("idUser") Integer idUser) {


        User user = repo.USER().get(idUser);

        UserDTO userDTO = mapper.toUserDTO(user);

        return Response.status(HttpStatus.OK.getCode()).entity(userDTO).build();


    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerUser(NewUserDTO newUserDTO) {
        System.out.println(newUserDTO.toString());

        User user = mapper.toUser(newUserDTO);


        User insertedUser = repo.USER().insert(user);

        UserDTO userDTO = mapper.toUserDTO(insertedUser);

        return Response.status(HttpStatus.OK.getCode()).entity(user).build();
    }

//    @PATCH
//    @Path("")
//    public Response path(@Context UriInfo info) {
//        return null;
//    }
//
//    @DELETE
//    @PATCH()
//    public Response delete(@Context UriInfo info) {
//
//        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
//        return null;
//    }
////
//    @POST
//    public String createCustomer() {
//
//        System.out.println("ABBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
//        return null;
//    }
}
