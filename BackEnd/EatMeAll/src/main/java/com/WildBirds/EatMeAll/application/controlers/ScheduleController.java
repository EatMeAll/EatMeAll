package com.WildBirds.EatMeAll.application.controlers;


import com.WildBirds.EatMeAll.application.DTO.full_.DayDTO;
import com.WildBirds.EatMeAll.application.DTO.unit_.MealUnitDTO;
import com.WildBirds.EatMeAll.application.service.Mapper;
import com.WildBirds.RepositoryJPA.application.RepositoryFacade;
import com.WildBirds.RepositoryJPA.domain.model.Day;
import com.WildBirds.RepositoryJPA.domain.model.Meal;
import com.WildBirds.RepositoryJPA.domain.model.enums.Language;
import com.WildBirds.RepositoryJPA.domain.model.enums.MealTime;
import com.authenticateService.api.AuthenticationServiceInterceptor;

import javax.ejb.EJB;
import javax.interceptor.Interceptors;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Path("schedule")
public class ScheduleController {

    @EJB
    RepositoryFacade repo;

    @EJB
    Mapper mapper;

    @GET
    @Produces("application/json; charset=UTF-8")
    @Interceptors(AuthenticationServiceInterceptor.class)
    public Response getWeekSchedule(
            @Context UriInfo uriinfo,
            @Context HttpHeaders headers,
            @Context Integer authUserId) {

        try {
            List<Meal> mealsBreakfastList = repo.MEAL().getShortMealByTypeMeal(MealTime.BREAKFAST, Language.PL, 7);
            List<Meal> mealsLunchList = repo.MEAL().getShortMealByTypeMeal(MealTime.LUNCH, Language.PL, 7);
            List<Meal> mealsDinnerList = repo.MEAL().getShortMealByTypeMeal(MealTime.DINNER, Language.PL, 7);
            List<Meal> mealsSupperList = repo.MEAL().getShortMealByTypeMeal(MealTime.SUPPER, Language.PL, 7);

            List<DayDTO> sevenDaysDTOList = new ArrayList<>();
            for (int i = 0; i < 7; i++) {
                DayDTO dayDTO = new DayDTO();

                MealUnitDTO breakFast = mapper.toMealUnitDTO(mealsBreakfastList.get(i));
                breakFast.setMealTime(MealTime.BREAKFAST);
                dayDTO.getMeals().add(breakFast);


                MealUnitDTO lunch = mapper.toMealUnitDTO(mealsLunchList.get(i));
                lunch.setMealTime(MealTime.LUNCH);
                dayDTO.getMeals().add(lunch);


                MealUnitDTO dinner = mapper.toMealUnitDTO(mealsDinnerList.get(i));
                dinner.setMealTime(MealTime.DINNER);
                dayDTO.getMeals().add(dinner);


                MealUnitDTO supper = mapper.toMealUnitDTO(mealsSupperList.get(i));
                supper.setMealTime(MealTime.SUPPER);
                dayDTO.getMeals().add(supper);

                sevenDaysDTOList.add(dayDTO);
            }
            return Response.status(Response.Status.OK).entity(sevenDaysDTOList).build();
        } catch (java.lang.IndexOutOfBoundsException e) {
            e.printStackTrace();
            return Response.status(Response.Status.EXPECTATION_FAILED).header("Error", "Not enough meals to prepaid full_ schedule").build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.NOT_FOUND).header("Error", "Not found").build();
        }
    }

    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    public Response saveSchedule(@Context UriInfo info, List<DayDTO> approvedWeekSchedule) {

        Integer idUser = 1;

        for (DayDTO dayDTO : approvedWeekSchedule) {
            Day day = mapper.toDay(dayDTO, idUser);


        }


        return Response.status(Response.Status.NO_CONTENT).header("OK", "You save your schedule in history").build();
    }

    @GET
    @Path("{from}/{to}")
    @Produces("application/json; charset=UTF-8")
    public Response getHistory(@Context UriInfo info, @PathParam("from") String fromDateString, @PathParam("to") String toDateString) {

        Integer idUser = 1;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedDate = dateFormat.parse(fromDateString);
            Instant fromDate = parsedDate.toInstant();

            Date parsedDate2 = dateFormat.parse(toDateString);
            Instant toDate = parsedDate2.toInstant();

            List<Day> dayList = repo.DAY().getHistory(fromDate, toDate, idUser);

            List<DayDTO> dayDTOList = mapper.toDayDTO(dayList);


            return Response.status(Response.Status.OK).header("OK", "History meal in period of time").entity(dayDTOList).build();
        } catch (ParseException e) {
            e.printStackTrace();
            return Response.status(Response.Status.NOT_ACCEPTABLE).header("Error", "Invalid syntax on date").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.NOT_FOUND).header("Error", "NOT FOUND").build();
        }


    }
}
