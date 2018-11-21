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


        try {
            User user = repo.USER().get(idUser);

            UserDTO userDTO = mapper.toUserDTO(user);

            return Response.status(HttpStatus.OK.getCode()).entity(userDTO).build();
        } catch (Exception e) {
            e.printStackTrace();

            return Response.status(HttpStatus.NOT_FOUND.getCode()).entity("NOT FOUND USER").build();
        }


    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(NewUserDTO newUserDTO) {


        try {
            User user = mapper.toUser(newUserDTO);


            User insertedUser = repo.USER().insert(user);

            UserDTO userDTO = mapper.toUserDTO(insertedUser);

            return Response.status(HttpStatus.CREATED.getCode()).entity(userDTO).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(HttpStatus.NOT_FOUND.getCode()).entity(newUserDTO).build();

        }
    }

    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginUser(NewUserDTO newUserDTO) {
        try {
            String nick = newUserDTO.getNick();
            String password = newUserDTO.getPassword();

            User userByNickPass = repo.USER().getUserByNickPass(nick, password);
            UserDTO loggedUser = mapper.toUserDTO(userByNickPass);

            return Response.status(HttpStatus.ACCEPTED.getCode()).entity(loggedUser).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(HttpStatus.NOT_FOUND.getCode()).entity(newUserDTO).build();
        }
    }

    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response upDateUser(NewUserDTO newUserDTO) {
        try {
            User user = mapper.toUser(newUserDTO);
            User updatedUser = repo.USER().update(user);
            UserDTO updatedUserDTO = mapper.toUserDTO(updatedUser);

            return Response.status(HttpStatus.OK.getCode()).entity(updatedUserDTO).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(HttpStatus.NOT_FOUND.getCode()).entity(newUserDTO).build();

        }
    }

    @DELETE
    @Path("{idUser}")
    public Response delete(@Context UriInfo info, @PathParam("idUser") Integer idUser) {

        try {
            repo.USER().delete(idUser);

            return Response.status(HttpStatus.ACCEPTED.getCode()).build();
        } catch (Exception e) {
            e.printStackTrace();

            return Response.status(HttpStatus.NOT_FOUND.getCode()).build();
        }
    }

}
