package com.WildBirds.EatMeAll.application.controlers;


import com.WildBirds.EatMeAll.application.DTO.DayDTO;
import com.WildBirds.EatMeAll.application.DTO.MealDTOshort;
import com.WildBirds.EatMeAll.application.controlers.utils.HttpStatus;
import com.WildBirds.EatMeAll.application.service.Mapper;
import com.WildBirds.RepositoryJPA.application.RepositoryFacade;
import com.WildBirds.RepositoryJPA.domain.model.Meal;
import com.WildBirds.RepositoryJPA.domain.model.enums.Language;
import com.WildBirds.RepositoryJPA.domain.model.enums.MealTime;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
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

        List<Meal> mealsBreakfastList = repo.MEAL().getShortMealByTypeMeal(MealTime.BREAKFAST, Language.PL, 7);
        List<Meal> mealsLunchList = repo.MEAL().getShortMealByTypeMeal(MealTime.LUNCH, Language.PL, 7);
        List<Meal> mealsDinnerList = repo.MEAL().getShortMealByTypeMeal(MealTime.DINNER, Language.PL, 7);
        List<Meal> mealsSupperList = repo.MEAL().getShortMealByTypeMeal(MealTime.SUPPER, Language.PL, 7);

        List<DayDTO> sevenDaysDTOList = new ArrayList<>();

        for (int i = 0; i < 6; i++) {

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

    }

}
