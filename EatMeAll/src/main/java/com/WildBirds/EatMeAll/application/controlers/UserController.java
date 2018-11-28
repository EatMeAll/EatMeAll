package com.WildBirds.EatMeAll.application.controlers;

import com.WildBirds.EatMeAll.application.DTO.new_.UserNewDTO;
import com.WildBirds.EatMeAll.application.DTO.full_.UserDTO;
import com.WildBirds.EatMeAll.application.controlers.utils.HttpStatus;
import com.WildBirds.EatMeAll.application.service.Mapper;
import com.WildBirds.RepositoryJPA.application.RepositoryFacade;
import com.WildBirds.RepositoryJPA.domain.model.User;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.EJBTransactionRolledbackException;
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
    @Produces({"application/json; charset=UTF-8"})
    public Response getUser(@Context UriInfo info, @PathParam("idUser") Integer idUser) {
        try {
            User user = repo.USER().get(idUser);
            UserDTO userDTO = mapper.toUserDTO(user);
            return Response.status(HttpStatus.OK.getCode()).entity(userDTO).build();
        } catch (EJBTransactionRolledbackException e) {
            e.printStackTrace();
            return Response.status(HttpStatus.NOT_FOUND.getCode()).header("Error", "NOT FOUND USER").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({"application/json; charset=UTF-8"})
    public Response addUser(UserNewDTO userNewDTO) {
        try {
            User user = mapper.toUser(userNewDTO);
            UserDTO userDTO = mapper.toUserDTO(user);
            return Response.status(HttpStatus.CREATED.getCode()).entity(userDTO).build();
        //todo: doesn't catch this exception -- should repair
        } catch (javax.validation.ConstraintViolationException e) {
            e.printStackTrace();
            return Response.status(HttpStatus.NOT_ACCEPTABLE.getCode()).header("Error", "Invalid email syntax").build();
        } catch (EJBTransactionRolledbackException e) {
            e.printStackTrace();
            return Response.status(HttpStatus.CONFLICT.getCode()).header("Error", "Duplicate email or nick").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(HttpStatus.NOT_FOUND.getCode()).header("Error", "NOT FOUND").build();
        }
    }


    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response upDateUser(UserNewDTO userNewDTO) {

        // TODO: 28.11.2018 change UserNeDTO to UserUpdateDTO
        try {
            User user = mapper.toUser(userNewDTO);
            UserDTO updatedUserDTO = mapper.toUserDTO(user);

            return Response.status(HttpStatus.OK.getCode()).entity(updatedUserDTO).build();
        } catch (EJBException e) {
            e.printStackTrace();
            return Response.status(HttpStatus.BAD_REQUEST.getCode()).entity(userNewDTO).build();

        }
    }

    @DELETE
    @Path("{idUser}")
    public Response delete(@Context UriInfo info, @PathParam("idUser") Integer idUser) {

        try {
            repo.USER().delete(idUser);

            return Response.status(HttpStatus.ACCEPTED.getCode()).build();
        } catch (EJBException e) {
            e.printStackTrace();

            return Response.status(HttpStatus.NOT_FOUND.getCode()).header("Error", "NOT FOUND USER").build();
        }
    }

}
