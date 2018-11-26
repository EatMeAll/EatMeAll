package com.WildBirds.EatMeAll.application.controlers;


import com.WildBirds.EatMeAll.application.DTO.DayDTO;
import com.WildBirds.EatMeAll.application.DTO.MealDTOshort;
import com.WildBirds.EatMeAll.application.controlers.utils.HttpStatus;
import com.WildBirds.EatMeAll.application.service.Mapper;
import com.WildBirds.RepositoryJPA.application.RepositoryFacade;
import com.WildBirds.RepositoryJPA.domain.model.Day;
import com.WildBirds.RepositoryJPA.domain.model.Meal;
import com.WildBirds.RepositoryJPA.domain.model.enums.Language;
import com.WildBirds.RepositoryJPA.domain.model.enums.MealTime;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Path("schedule")
public class ScheduleController {

    @EJB
    RepositoryFacade repo;

    @EJB
    Mapper mapper;

    @GET
    @Produces("application/json; charset=UTF-8")
    public Response getWeekSchedule (@Context UriInfo info) {
        try {
            List<Meal> mealsBreakfastList = repo.MEAL().getShortMealByTypeMeal(MealTime.BREAKFAST, Language.PL, 7);
            List<Meal> mealsLunchList = repo.MEAL().getShortMealByTypeMeal(MealTime.LUNCH, Language.PL, 7);
            List<Meal> mealsDinnerList = repo.MEAL().getShortMealByTypeMeal(MealTime.DINNER, Language.PL, 7);
            List<Meal> mealsSupperList = repo.MEAL().getShortMealByTypeMeal(MealTime.SUPPER, Language.PL, 7);

            List<DayDTO> sevenDaysDTOList = new ArrayList<>();
            for (int i = 0; i < 7; i++) {
                DayDTO dayDTO = new DayDTO();

                MealDTOshort breakFast = mapper.toMealDTOShort(mealsBreakfastList.get(i));
                breakFast.setMealTime(MealTime.BREAKFAST);
                dayDTO.getMealDTOShortList().add(breakFast);


                MealDTOshort lunch = mapper.toMealDTOShort(mealsLunchList.get(i));
                lunch.setMealTime(MealTime.LUNCH);
                dayDTO.getMealDTOShortList().add(lunch);


                MealDTOshort dinner = mapper.toMealDTOShort(mealsDinnerList.get(i));
                dinner.setMealTime(MealTime.DINNER);
                dayDTO.getMealDTOShortList().add(dinner);


                MealDTOshort supper = mapper.toMealDTOShort(mealsSupperList.get(i));
                supper.setMealTime(MealTime.SUPPER);
                dayDTO.getMealDTOShortList().add(supper);

                sevenDaysDTOList.add(dayDTO);
            }
            return Response.status(HttpStatus.OK.getCode()).entity(sevenDaysDTOList).build();
        } catch (java.lang.IndexOutOfBoundsException e) {
            e.printStackTrace();
            return Response.status(HttpStatus.EXPECTATION_FAILED.getCode()).header("Error", "Not enough meals to prepaid full schedule").build();

        } catch (Exception e){
            e.printStackTrace();
            return Response.status(HttpStatus.NOT_FOUND.getCode()).header("Error", "Not found").build();
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


        return Response.status(HttpStatus.OK.getCode()).header("OK", "Working").build();
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

            List<DayDTO> dayDTOList = new ArrayList<>();
            for (Day day : dayList) {
                DayDTO dayDTO = mapper.toDayDTO(day);
                dayDTOList.add(dayDTO);
            }
            return Response.status(HttpStatus.OK.getCode()).header("OK", "History meal in period of time").entity(dayDTOList).build();

        } catch (ParseException e) {
            e.printStackTrace();
            return Response.status(HttpStatus.NOT_ACCEPTABLE.getCode()).header("Error", "Invalid syntax on date").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(HttpStatus.NOT_FOUND.getCode()).header("Error", "NOT FOUND").build();
        }


    }
}
