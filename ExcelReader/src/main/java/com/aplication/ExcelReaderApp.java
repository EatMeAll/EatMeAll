package com.aplication;

import com.WildBirds.RepositoryJPA.application.RepositoryFacade;
import com.WildBirds.RepositoryJPA.domain.model.*;
import com.WildBirds.RepositoryJPA.domain.model.enums.Language;
import com.WildBirds.RepositoryJPA.domain.model.enums.MealTime;
import com.WildBirds.RepositoryJPA.domain.model.enums.UserType;
import com.domain.model.MealExcel;
import com.domain.model.ProductsExcel;
import com.domain.ports.ExcelReader;
import com.infrastructure.XmlReader;


import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.transaction.UserTransaction;
import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Stateless
@LocalBean
public class ExcelReaderApp {

    @EJB
    RepositoryFacade repo;

    public ExcelReaderApp() {
    }

    public void addToDatabase() throws IOException{

        ExcelReader excelReader = new XmlReader();
        String filePath = "D:\\PROGRAMOWANIE\\etmeall2\\eatmeall\\ExcelReader\\src\\main\\resource\\jadlospis2.xlsx";
        List<MealExcel> mealExcelList = excelReader.read(filePath);

        User user = new User();

        user.setNick("EXCEL");
        user.setEmail("excel@wp.pl");
        user.setPassword("jakieshaslo");
        user.setUserType(UserType.ADMIN);

        repo.USER().insert(user);

        for (MealExcel mealExcel : mealExcelList) {

            Meal mealEntity = new Meal();

            String typeMealExcel = mealExcel.getTypeMeal();
            Integer prepairTimeExcel = mealExcel.getPrepaidTime();
            String titleExcel = mealExcel.getTitle();
            List<ProductsExcel> productsExcels = mealExcel.getProducts();
            String receiptExcel = mealExcel.getReceipt();
            Double caloriesExcel = mealExcel.getCalories();
            String authorExcel = mealExcel.getAuthor();


            TypeMeal typeMealEntity = new TypeMeal();


            switch (typeMealExcel) {

                case "śniadanie":

                    typeMealEntity.setMealTime(MealTime.BREAKFAST);
                    File breakfastPhoto = new File("D:\\PROGRAMOWANIE\\etmeall2\\eatmeall\\ExcelReader\\src\\main\\resource\\breakfast.jpg");
                    mealEntity.setPhoto(breakfastPhoto);
                    break;

                case "lunch":

                    typeMealEntity.setMealTime(MealTime.LUNCH);
                    File lunchPhoto = new File("D:\\PROGRAMOWANIE\\etmeall2\\eatmeall\\ExcelReader\\src\\main\\resource\\lunch.jpg");
                    mealEntity.setPhoto(lunchPhoto);
                    break;

                case "obiad":

                    typeMealEntity.setMealTime(MealTime.DINNER);
                    File dinnerPhoto = new File("D:\\PROGRAMOWANIE\\etmeall2\\eatmeall\\ExcelReader\\src\\main\\resource\\dinner.jpg");
                    mealEntity.setPhoto(dinnerPhoto);
                    break;

                case "kolacja":

                    typeMealEntity.setMealTime(MealTime.SUPPER);
                    File supperPhoto = new File("D:\\PROGRAMOWANIE\\etmeall2\\eatmeall\\ExcelReader\\src\\main\\resource\\supper.jpg");
                    mealEntity.setPhoto(supperPhoto);
                    break;
            }
            repo.TYPEMEAL().insert(typeMealEntity);
            Set<TypeMeal> typeMealSet = new HashSet<>();

            typeMealSet.add(typeMealEntity);


            for (ProductsExcel productsExcel : productsExcels) {
                MealHasProduct mealHasProduct = new MealHasProduct();
                Product product = new Product();

                String productsExcelName = productsExcel.getName();
                Double productsExcelAmount = productsExcel.getAmount();
                String productsExcelUnit = productsExcel.getUnit();
                String productsExcelSpecialUnit = productsExcel.getSpecialUnit();

                product.setName(productsExcelName);

                mealHasProduct.setAmount((int) Math.round(productsExcelAmount));
                mealHasProduct.setUnit(productsExcelUnit);
                mealHasProduct.setSpecialUnit(productsExcelSpecialUnit);
                mealHasProduct.setProduct(product);
                repo.PRODUCT().insert(product);
                repo.MEALHASPRODUCT().insert(mealHasProduct);
//                mealEntity.getMealHasProductSet().add(mealHasProduct);
            }

            Receipt receipt = new Receipt();


            receipt.setDescription("Jakis dodatkowy opis");
            receipt.setTitle(titleExcel);
            receipt.setPrepareTime(prepairTimeExcel);
//            receipt.getStepSet().add(step);
            repo.RECEIPT().insert(receipt);


            addSteps(receipt,receiptExcel);



            mealEntity.setLanguage(Language.PL);
            mealEntity.setTitle(titleExcel);
            mealEntity.setShortDescription("Przepis z Excel");
            mealEntity.setAmountCalories((int) Math.round(caloriesExcel));
            mealEntity.setPublic(true);
            mealEntity.setCreatedDate(Instant.now());
//            mealEntity.setTypeMeal(typeMealSet);
//            mealEntity.getTypeMeal().add(typeMealEntity);
            mealEntity.setReceipt(receipt);
            mealEntity.setAuthorReceipt(authorExcel);
            mealEntity.setCreatorMeal(user);


            repo.MEAL().insert(mealEntity);

        }


    }

    private void addSteps(Receipt receipt, String receiptExcel) {

        String[] splitedHeader = receiptExcel.split(";");

        for (int i = 0; i < splitedHeader.length; i++) {
            Step step = new Step();

            step.setHeader(splitedHeader[i]);
            step.setNumber(i +1);
            step.setReceipt(receipt);
            repo.STEP().insert(step);

        }
    }

}
