package com.WildBirds.EatMeAll.application.service;


import com.WildBirds.EatMeAll.application.DTO.full_.*;
import com.WildBirds.EatMeAll.application.DTO.new_.UserNewDTO;
import com.WildBirds.EatMeAll.application.DTO.short_.MealShortDTO;
import com.WildBirds.EatMeAll.application.DTO.unit_.MealUnitDTO;
import com.WildBirds.EatMeAll.application.DTO.unit_.ProductUnitDTO;
import com.WildBirds.EatMeAll.application.DTO.unit_.UserUpdateDTO;
import com.WildBirds.EatMeAll.application.service.exception.UserInvalidUpdate;
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

                Set<ProductUnitDTO> productUnitDTOSet = new HashSet<>();
                Set<MealHasProduct> mealHasProductSet = meal.getMealHasProductSet();

                for (MealHasProduct mealHasProduct : mealHasProductSet) {
                    ProductUnitDTO productUnitDTO = new ProductUnitDTO();

                    productUnitDTO.setName(mealHasProduct.getProduct().getName());
                    productUnitDTO.setSpecialUnit(mealHasProduct.getSpecialUnit());
                    productUnitDTO.setAmount(mealHasProduct.getAmount());
                    productUnitDTO.setUnit(mealHasProduct.getProduct().getUnit());

                    productUnitDTOSet.add(productUnitDTO);
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
                        productUnitDTOSet);
                mealDTOList.add(mealDTO);
            } catch (Exception e) {
                e.printStackTrace();
                throw new MapperException("Invalid value to mapping");
            }
        }


        return mealDTOList;
    }

    @Override
    public List<Meal> toMealFromHistory(List<Day> history) {
        List<Meal> mealList = new ArrayList<>();
        for (Day day : history) {
            day = repo.DAY().update(day);

            Iterator<MealHasDay> mealHasDayIterator = day.getMealHasDaySet().iterator();
            while (mealHasDayIterator.hasNext()){
                MealHasDay mealHasDay = mealHasDayIterator.next();
                Meal meal = mealHasDay.getMeal();
                mealList.add(meal);
            }
        }
        return mealList;
    }

    @Override
    public List<Meal> toMealOnlyIdMeal(String[] idMeals) {
        List<Meal> result = new ArrayList<>();
        for (String idMeal : idMeals) {
            Meal meal = new Meal();
            meal.setIdMeal(Integer.valueOf(idMeal));
            result.add(meal);
        }
        return result;
    }
    @Override
    public MealUnitDTO toMealUnitDTO(Meal meal) {

        return new MealUnitDTO(meal.getIdMeal(),
                meal.getLanguage(),
                meal.getTitle(),
                meal.getShortDescription(),
                meal.getPublic(),
                null);
    }

    @Override
    public MealShortDTO toMealShortDTO(Meal meal) {

        meal = repo.MEAL().update(meal);


        Set<MealTime> mealTimeSet = new HashSet<>();
        for (TypeMeal typeMeal : meal.getTypeMealSet()) {
            mealTimeSet.add(typeMeal.getMealTime());
        }

        return new MealShortDTO(
                meal.getIdMeal(),
                meal.getLanguage(),
                meal.getTitle(),
                meal.getShortDescription(),
                meal.getPublic(),
                mealTimeSet);
    }



    @Override
    public ProductDTO toProductDTO(Product product) {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(product.getName());
        productDTO.setIdProduct(product.getIdProduct());
        productDTO.setUnit(product.getUnit());

        return productDTO;
    }

    @Override
    public Product toProduct(ProductDTO productDTO) {

       Product product = repo.PRODUCT().insert(new Product(productDTO.getName(),productDTO.getUnit()));
        return product;
    }

    @Override
    public ProductUnitDTO toProductUnitDTO(MealHasProduct mealHasProduct) {
        ProductUnitDTO productUnitDTO = new ProductUnitDTO(
                mealHasProduct.getProduct().getName(),
                mealHasProduct.getAmount(),
                mealHasProduct.getProduct().getUnit(),
                mealHasProduct.getSpecialUnit()
        );
        return productUnitDTO;
    }

    @Override
    public List<ProductUnitDTO> toShoppingList(List<MealHasProduct> mealHasProductList) {
        List<ProductUnitDTO> shoppingList = new ArrayList<>();
        for (MealHasProduct mealHasProduct : mealHasProductList) {

            ProductUnitDTO currentProduct = toProductUnitDTO(mealHasProduct);

            ProductUnitDTO foundProduct = productInCurrentList(shoppingList, currentProduct);
            if ( foundProduct != null){
                double sum = foundProduct.getAmount() + currentProduct.getAmount();
                shoppingList.remove(foundProduct);
                foundProduct.setAmount(sum);
                foundProduct.setSpecialUnit(null);
                shoppingList.add(foundProduct);
            }else {
                currentProduct.setSpecialUnit(null);
                shoppingList.add(currentProduct);
            }

        }
        return shoppingList;
    }

    private ProductUnitDTO productInCurrentList(List<ProductUnitDTO> list, ProductUnitDTO currentProduct) {

        for (ProductUnitDTO productUnitDTO : list) {
            if (productUnitDTO.getName().equalsIgnoreCase(currentProduct.getName())) {
                return productUnitDTO;
            }
        }
        return null;
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
    public User toUser(UserNewDTO userNewDTO) {

        Integer idUser = userNewDTO.getIdUser();
        User user = null;

        if (idUser != null) {

            user = repo.USER().get(idUser);
            user.setNick(userNewDTO.getNick());
            user.setEmail(userNewDTO.getEmail());

        } else {
            user = repo.USER().insert(new User(userNewDTO.getNick(), userNewDTO.getEmail()));
        }
        user.setUserType(userNewDTO.getUserType());
        user.setPassword(userNewDTO.getPassword());

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
            MealHasDay mealHasDay = it.next();
            Meal meal = mealHasDay.getMeal();

            MealUnitDTO mealUnitDTO = toMealUnitDTO(meal);
            mealUnitDTO.setMealTime(mealHasDay.getMealTime());

            dayDTO.getMeals().add(mealUnitDTO);
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

        List<MealUnitDTO> mealUnitDTOSet = dayDTO.getMeals();
        Instant dateDTO = dayDTO.getDate();

        User user = repo.USER().get(idUser);

        Day day = new Day();
        day = repo.DAY().insert(day);
        day.setDate(dateDTO);
        day.setDayOwner(user);

        for (MealUnitDTO mealUnitDTO : mealUnitDTOSet) {

            MealHasDay mealHasDay = new MealHasDay();
            mealHasDay = repo.MEALHASDAY().insert(mealHasDay);

            Meal meal = repo.MEAL().get(mealUnitDTO.getIdMeal());
            mealHasDay.setMeal(meal);
            mealHasDay.setMealTime(mealUnitDTO.getMealTime());
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

    @Override
    public User toUserUpdate(UserUpdateDTO userUpdateDTO) throws UserInvalidUpdate {

        if ((userUpdateDTO.getEmail() == (null)) || (userUpdateDTO.getPassword() == (null))) {
            throw new UserInvalidUpdate("No password or email");
        }
        User user = repo.USER().get(userUpdateDTO.getIdUser());

        user.setEmail(userUpdateDTO.getEmail());
        user.setPassword(userUpdateDTO.getPassword());

        user = repo.USER().update(user);

        return user;
    }
}
