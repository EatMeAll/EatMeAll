package com.WildBirds.EatMeAll.application.service;


import com.WildBirds.EatMeAll.application.modelDTO.*;
import com.WildBirds.RepositoryJPA.application.RepositoryFacade;
import com.WildBirds.RepositoryJPA.domain.model.*;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Stateless
@Local(Mapper.class)
public class MapperMealImpl implements Mapper {


    @EJB
    RepositoryFacade repo;

    @Override
    public List<Meal> toMeal(List<MealDTO> mealDTOList) throws MapperException {

        List<Meal> mealList = null;
        try {
            mealList = new ArrayList<>();
            for (MealDTO mealDTO : mealDTOList) {
                //todo to implementing

            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new MapperException("Invalid value to mapping");
        }

        return mealList;
    }

    @Override
    public List<MealDTO> toMealDTO(List<Meal> mealList) {
        List<MealDTO> mealDTOList = new ArrayList<>();


        for (Meal meal : mealList) {
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

                Set<TypeMeal> typeMealSet = meal.getTypeMeal();

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

    public User toUser(UserDTO userDTO) throws MapperException {
        User user = null;
        try {
            user = new User();

            user.setIdUser(user.getIdUser());
            user.setUserType(user.getUserType());
            user.setEmail(userDTO.getEmail());
            user.setNick(user.getNick());
            //todo HAVE TO SOLVE - DO NOT MAPPING FAVOURITES MEALS
            Set<Meal> mealSet = new HashSet<>();
            for (Integer integer : userDTO.getFavouritesMealsSetId()) {
                Meal meal = repo.MEAL().get(integer);
                mealSet.add(meal);
            }
            user.setFavouritesMealsSet(mealSet);

        } catch (Exception e) {
            e.printStackTrace();
            throw new MapperException("Invalid value to mapping");

        }
        return user;
    }

    public UserDTO toUserDTO(User user) throws MapperException {

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

    public User toUser(NewUserDTO newUserDTO) throws MapperException {

        User user = null;
        try {
            user = new User();

            user.setNick(newUserDTO.getNick());
            user.setEmail(newUserDTO.getEmail());
            user.setUserType(newUserDTO.getUserType());
            user.setPassword(newUserDTO.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
            throw new MapperException("Invalid value to mapping");
        }

        return user;

    }
}
