package com.WildBirds.EatMeAll.application.service;


import com.WildBirds.EatMeAll.application.DTO.*;
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

        List<Meal> mealList = new ArrayList<>();
        try {

            for (MealDTO mealDTO : mealDTOList) {
                Meal meal = new Meal();


//todo DOES'nt WORK :/

                meal.setIdMeal(mealDTO.getIdMeal());
                meal.setLanguage(mealDTO.getLanguage());
                meal.setTitle(mealDTO.getTitle());
                meal.setAmountCalories(mealDTO.getAmountCalories());
                meal.setAuthorReceipt(mealDTO.getAuthorReceipt());
//
//                meal.setPhoto(mealDTO.getPhoto());


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

    public User toUser(UserDTO userDTO) throws MapperException {
        User user = null;
        try {
            user = repo.USER().get(userDTO.getIdUser());

            user.setIdUser(user.getIdUser());
            user.setUserType(user.getUserType());
            user.setEmail(userDTO.getEmail());
            user.setNick(user.getNick());


//            user.setIdUser(newUserDTO.getIdUser());
//            List<Meal> mealList = repo.MEAL().getIn(newUserDTO.getFavouritesMealsSetId());
//
//            for (Meal meal : mealList) {
//                user.getFavouritesMealsSet().add(repo.MEAL().update(meal));
//            }


            for (Integer integer : userDTO.getFavouritesMealsSetId()) {
                Meal meal = repo.MEAL().get(integer);
                user.addFavoriteMeal(meal);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new MapperException("Invalid value to mapping");

        }
        return user;
    }

    public UserDTO toUserDTO(User user) throws MapperException {

        System.out.println("MAPP TO NEW USERDTO");

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
            user.setIdUser(newUserDTO.getIdUser());

            repo.USER().insert(user);

            // TODO: 21.11.2018 IT DOESN'T WORK :(
            for (Integer integer : newUserDTO.getFavouritesMealsSetId()) {
                Meal meal = repo.MEAL().get(integer);
                meal.addLikedByUser(user);
            }
            repo.USER().update(user);

        } catch (Exception e) {
            e.printStackTrace();
            throw new MapperException("Invalid value to mapping");
        }

        return user;

    }
}
