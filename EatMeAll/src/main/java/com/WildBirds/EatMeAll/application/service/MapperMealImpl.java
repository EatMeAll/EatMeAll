package com.WildBirds.EatMeAll.application.service;


import com.WildBirds.EatMeAll.application.DTO.*;
import com.WildBirds.RepositoryJPA.application.RepositoryFacade;
import com.WildBirds.RepositoryJPA.domain.model.*;
import com.WildBirds.RepositoryJPA.domain.model.enums.MealTime;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.time.Instant;
import java.util.*;

@Stateless
@Local(Mapper.class)
public class MapperMealImpl implements Mapper {


    @EJB
    RepositoryFacade repo;

    @Override
    public List<Meal> toMeal(List<MealDTO> mealDTOList) throws MapperException {

        List<Meal> mealList = new ArrayList<>();


            for (MealDTO mealDTO : mealDTOList) {
                Meal meal = new Meal();


//todo DOES'nt WORK :/

                meal.setIdMeal(mealDTO.getIdMeal());
                meal.setLanguage(mealDTO.getLanguage());
                meal.setTitle(mealDTO.getTitle());
                meal.setAmountCalories(mealDTO.getAmountCalories());
                meal.setAuthorReceipt(mealDTO.getAuthorReceipt());
            }
        return mealList;
    }

    @Override
    public List<MealDTO> toMealDTO(List<Meal> mealList) {
        List<MealDTO> mealDTOList = new ArrayList<>();


        for (Meal meal : mealList) {
            meal = repo.MEAL().update(meal);
            try {
                Set<StepDTO> stepDTOSet = new HashSet<>();
                Set<Step> stepList = meal.getReceipt().getStepSet();

                for (Step step : stepList) {
                    StepDTO stepDTO = new StepDTO();


                    stepDTO.setNumber(step.getNumber());
                    stepDTO.setHeader(step.getHeader());
                    stepDTO.setIdStep(step.getIdStep());

                    stepDTOSet.add(stepDTO);

                }

                ReceiptDTO receiptDTO = new ReceiptDTO();
                receiptDTO.setTitle(meal.getReceipt().getTitle());
                receiptDTO.setPrepareTime(meal.getReceipt().getPrepareTime());
                receiptDTO.setDescription(meal.getReceipt().getDescription());
                receiptDTO.setIdReceipt(meal.getReceipt().getIdReceipt());
                receiptDTO.setSteps(stepDTOSet);

                Set<TypeMealDTO> typeMealDTOList = new HashSet<>();

                Set<TypeMeal> typeMealSet = meal.getTypeMealSet();

                for (TypeMeal typeMeal : typeMealSet) {
                    TypeMealDTO typeMealDTO = new TypeMealDTO();

                    typeMealDTO.setIdTypeMeal(typeMeal.getIdTypeMeal());
                    typeMealDTO.setMealTime(typeMeal.getMealTime());

                    typeMealDTOList.add(typeMealDTO);
                }

                Set<ProductDTO> productDTOSet = new HashSet<>();
                Set<MealHasProduct> mealHasProductSet = meal.getMealHasProductSet();

                for (MealHasProduct mealHasProduct : mealHasProductSet) {
                    ProductDTO productDTO = new ProductDTO();

                    productDTO.setName(mealHasProduct.getProduct().getName());
                    productDTO.setSpecialUnit(mealHasProduct.getSpecialUnit());
                    productDTO.setAmount(mealHasProduct.getAmount());
                    productDTO.setUnit(mealHasProduct.getUnit());

                    productDTOSet.add(productDTO);
                }

                MealDTO mealDTO = new MealDTO(
                        meal.getIdMeal(),
                        meal.getLanguage(),
                        meal.getTitle(),
                        meal.getShortDescription(),
                        meal.getAmountCalories(),
                        meal.getAuthorReceipt(),
                        meal.getIdMeal(),
                        meal.getPublic(),
                        meal.getCreatedDate(),
                        receiptDTO,
                        typeMealDTOList,
                        toUserDTO(meal.getCreatorMeal()),
                        productDTOSet);
                mealDTOList.add(mealDTO);
            } catch (Exception e) {
                e.printStackTrace();
                throw new MapperException("Invalid value to mapping");
            }
        }


        return mealDTOList;
    }


    @Override
    public MealDTOshort toMealDTOShort(Meal meal) {

        return new MealDTOshort(meal.getIdMeal(),
                meal.getLanguage(),
                meal.getTitle(),
                meal.getShortDescription(),
                meal.getPublic(),
                null);
    }

    @Override
    public MealDTOshortFull toMealDTOShortFull(Meal meal) {

        meal = repo.MEAL().update(meal);


        Set<MealTime> mealTimeSet = new HashSet<>();
        for (TypeMeal typeMeal : meal.getTypeMealSet()) {
            mealTimeSet.add(typeMeal.getMealTime());
        }

        return new MealDTOshortFull(
                meal.getIdMeal(),
                meal.getLanguage(),
                meal.getTitle(),
                meal.getShortDescription(),
                meal.getPublic(),
                mealTimeSet);
    }

    @Override
    public ProductBasicDTO toProductBasicDTO(Product product) {

        ProductBasicDTO productBasicDTO = new ProductBasicDTO();
        productBasicDTO.setName(product.getName());
        productBasicDTO.setIdProduct(product.getIdProduct());

        return productBasicDTO;
    }

    @Override
    public User toUser(UserDTO userDTO) {
        User user = null;

        user = repo.USER().get(userDTO.getIdUser());
        user.setIdUser(user.getIdUser());
        user.setUserType(user.getUserType());
        user.setEmail(userDTO.getEmail());
        user.setNick(user.getNick());

        return user;
    }

    @Override
    public UserDTO toUserDTO(User user) {

        user = repo.USER().update(user);
        Set<Integer> favouritesMealsSetId = new HashSet<>();
        Set<Meal> favouritesMealsSet = user.getFavouritesMealsSet();

        for (Meal meal : favouritesMealsSet) {
            favouritesMealsSetId.add(meal.getIdMeal());
        }
        UserDTO userDTO = new UserDTO();

        userDTO.setIdUser(user.getIdUser());
        userDTO.setUserType(user.getUserType());
        userDTO.setNick(user.getNick());
        userDTO.setEmail(user.getEmail());
        userDTO.setFavouritesMealsSetId(favouritesMealsSetId);

        return userDTO;
    }

    @Override
    public User toUser(NewUserDTO newUserDTO) {

        Integer idUser = newUserDTO.getIdUser();
        User user = null;

        if (idUser != null) {

            user = repo.USER().get(idUser);
            user.setNick(newUserDTO.getNick());
            user.setEmail(newUserDTO.getEmail());

        } else {
            user = repo.USER().insert(new User(newUserDTO.getNick(), newUserDTO.getEmail()));
        }
        user.setUserType(newUserDTO.getUserType());
        user.setPassword(newUserDTO.getPassword());

        user = repo.USER().update(user);
        return user;
    }


    @Override
    public DayDTO toDayDTO(Day day) {

        day = repo.DAY().update(day);
        DayDTO dayDTO = new DayDTO();

        dayDTO.setIdDay(day.getIdDay());
        dayDTO.setDate(day.getDate());

        Set<MealHasDay> mealHasDaySet = day.getMealHasDaySet();
        Iterator<MealHasDay> it = mealHasDaySet.iterator();

        while (it.hasNext()) {
            Meal meal = it.next().getMeal();
            dayDTO.getMealDTOshortSet().add(toMealDTOShort(meal));
        }
        return dayDTO;
    }

    @Override
    public List<DayDTO> toDayDTO(List<Day> dayList) {

        List<DayDTO> dayDTOList = new ArrayList<>();
        for (Day day : dayList) {
            dayDTOList.add(toDayDTO(day));
        }
        return dayDTOList;
    }

    @Override
    public Day toDay(DayDTO dayDTO, Integer idUser) {

        Set<MealDTOshort> mealDTOshortSet = dayDTO.getMealDTOshortSet();
        Instant dateDTO = dayDTO.getDate();

        User user = repo.USER().get(idUser);

        Day day = new Day();
        day = repo.DAY().insert(day);
        day.setDate(dateDTO);
        day.setDayOwner(user);

        for (MealDTOshort mealDTOshort : mealDTOshortSet) {

            MealHasDay mealHasDay = new MealHasDay();
            mealHasDay = repo.MEALHASDAY().insert(mealHasDay);

            Meal meal = repo.MEAL().get(mealDTOshort.getIdMeal());
            mealHasDay.setMeal(meal);
            mealHasDay.setMealTime(mealDTOshort.getMealTime());
            day.addMealHasDay(mealHasDay);

            repo.MEAL().update(meal);
            repo.MEALHASDAY().update(mealHasDay);

        }
        day = repo.DAY().update(day);
        return day;
    }

    @Override
    public List<Day> toDay(List<DayDTO> dayDTOList, Integer idUser) {

        List<Day> dayList = new ArrayList<>();

        for (DayDTO dayDTO : dayDTOList) {
            dayList.add(toDay(dayDTO, idUser));
        }
        return dayList;

    }
}
