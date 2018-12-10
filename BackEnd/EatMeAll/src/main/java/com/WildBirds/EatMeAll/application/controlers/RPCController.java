package com.WildBirds.EatMeAll.application.controlers;

import com.WildBirds.EatMeAll.application.DTO.full_.UserDTO;
import com.WildBirds.EatMeAll.application.DTO.new_.UserNewDTO;
import com.WildBirds.EatMeAll.application.service.Mapper;
import com.WildBirds.RepositoryJPA.application.RepositoryFacade;
import com.WildBirds.RepositoryJPA.domain.model.User;
import com.authenticateService.api.AuthenticationServiceFacade;
import com.authenticateService.api.TokenDTO;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

@Path("")
public class RPCController {

    @EJB
    RepositoryFacade repo;

    @EJB
    Mapper mapper;

    @EJB
    AuthenticationServiceFacade<Integer> authenticationServiceFacade;

    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({"application/json; charset=UTF-8"})
    public Response loginUser(UserNewDTO userNewDTO) {
        try {
            String nick = userNewDTO.getNick();
            String password = userNewDTO.getPassword();

            User userByNickPass = repo.USER().getUserByNickPass(nick, password);
            UserDTO loggedUser = mapper.toUserDTO(userByNickPass);

            TokenDTO userToken = authenticationServiceFacade.assignToken(loggedUser.getIdUser());
            NewCookie token = new NewCookie("Token", userToken.getValue());

            return Response.status(Response.Status.ACCEPTED).cookie(token).entity(loggedUser).build();
        } catch (EJBException e) {
            e.printStackTrace();
            return Response.status(Response.Status.UNAUTHORIZED).header("Error", "Unauthorized " + userNewDTO.getNick() + " invalid nick or password").build();
        }
    }


}
