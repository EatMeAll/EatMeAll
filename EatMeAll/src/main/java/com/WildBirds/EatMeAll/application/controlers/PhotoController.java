package com.WildBirds.EatMeAll.application.controlers;


import com.WildBirds.EatMeAll.application.DTO.*;
import com.WildBirds.EatMeAll.application.controlers.service.handler.ResponseStrategy;
import com.WildBirds.EatMeAll.application.controlers.utils.HttpStatus;
import com.WildBirds.EatMeAll.application.service.Mapper;
import com.WildBirds.RepositoryJPA.application.RepositoryFacade;
import com.WildBirds.RepositoryJPA.domain.model.Meal;
import com.WildBirds.RepositoryJPA.domain.model.enums.Language;
import com.WildBirds.RepositoryJPA.domain.model.enums.MealTime;
import com.WildBirds.RepositoryJPA.domain.model.enums.UserType;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.File;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Path("meals")
public class PhotoController {


    @EJB
    Mapper mapper;

    @EJB
    RepositoryFacade repo;

    @GET
    @Path("photo/{idPhoto}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response getFile(@Context UriInfo info, @PathParam("idPhoto") Integer idPhoto) {

        File file = repo.MEAL().getFile(idPhoto);
        return Response.ok(file, MediaType.APPLICATION_OCTET_STREAM)
                .header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"" ) //optional
                .build();
    }

}
