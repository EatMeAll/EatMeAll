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
import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.List;
import java.util.Random;

@Stateless
@LocalBean
public class ExcelReaderApp {
    private String basePath = "D:\\PROGRAMOWANIE\\etmeall2\\eatmeall";

    @EJB
    RepositoryFacade repo;

    public ExcelReaderApp() {
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public void addToDatabase() throws IOException {


        int counter = 0;

        ExcelReader excelReader = new XmlReader();
        String filePath = basePath + "\\ExcelReader\\src\\main\\resources\\data\\jadlospis2.xlsx";
        List<MealExcel> mealExcelList = excelReader.read(filePath);

        int random = new Random().nextInt(100);

        User userEntity = repo.USER().insert(new User("EXCEL" + random, random + "excel@wp.pl"));


        userEntity.setPassword("jakieshaslo");
        userEntity.setUserType(UserType.ADMIN);

        for (MealExcel mealExcel : mealExcelList) {

            Meal mealEntity = repo.MEAL().insert(new Meal());


            String typeMealExcel = mealExcel.getTypeMeal();
            Integer prepairTimeExcel = mealExcel.getPrepaidTime();
            String titleExcel = mealExcel.getTitle();
            List<ProductsExcel> productsExcels = mealExcel.getProducts();
            String receiptExcel = mealExcel.getReceipt();
            Double caloriesExcel = mealExcel.getCalories();
            String authorExcel = mealExcel.getAuthor();


            MealTime mealTime = MealTime.LUNCH;
            File photo = new File(basePath + "\\ExcelReader\\src\\main\\resources\\data\\jadlospis2.xlsx");

            switch (typeMealExcel) {

                case "śniadanie":
                    mealTime = MealTime.BREAKFAST;
                    photo = new File(basePath + "\\ExcelReader\\src\\main\\resources\\data\\breakfast.jpg");
                    break;

                case "lunch":
                    mealTime = MealTime.LUNCH;
                    photo = new File(basePath + "\\ExcelReader\\src\\main\\resources\\data\\lunch.jpg");
                    break;

                case "obiad":
                    mealTime = MealTime.DINNER;
                    photo = new File(basePath + "\\ExcelReader\\src\\main\\resources\\data\\dinner.jpg");
                    break;

                case "kolacja":
                    mealTime = MealTime.SUPPER;
                    photo = new File(basePath + "\\ExcelReader\\src\\main\\resources\\data\\supper.jpg");
                    break;
            }


            // Avoid duplicate in DB
            TypeMeal typeMealEntity = repo.TYPEMEAL().findByMealTime(mealTime);
            if(typeMealEntity == null){
                typeMealEntity = repo.TYPEMEAL().insert(new TypeMeal(mealTime));
            }



            mealEntity.setPhoto(photo);

            typeMealEntity = repo.TYPEMEAL().update(typeMealEntity);
            mealEntity.addTypeMeal(typeMealEntity);

//            TypeMeal typeMealFromDatabase = repo.TYPEMEAL().update(typeMealEntity);


            for (ProductsExcel productsExcel : productsExcels) {

                MealHasProduct mealHasProduct = repo.MEALHASPRODUCT().insert(new MealHasProduct());

                String productsExcelName = productsExcel.getName();
                Double productsExcelAmount = productsExcel.getAmount();
                String productsExcelUnit = productsExcel.getUnit();
                String productsExcelSpecialUnit = productsExcel.getSpecialUnit();

                Product product = repo.PRODUCT().getProductByName(productsExcelName);
                if ( product == null){

                product = repo.PRODUCT().insert(new Product(productsExcelName,productsExcelUnit));
                };


                mealHasProduct.setAmount(productsExcelAmount);
                mealHasProduct.setSpecialUnit(productsExcelSpecialUnit);
                mealHasProduct.setMeal(mealEntity);
                product = repo.PRODUCT().update(product);
                mealHasProduct.setProduct(product);
                mealHasProduct = repo.MEALHASPRODUCT().update(mealHasProduct);
                mealEntity.addMealHasProduct(mealHasProduct);

            }

            Receipt receipt = repo.RECEIPT().insert(new Receipt());

            receipt.setDescription("Jakis dodatkowy opis");
            receipt.setTitle(titleExcel);
            receipt.setPrepareTime(prepairTimeExcel);

            // method
            addStepsToReceipt(receipt, receiptExcel);

            receipt = repo.RECEIPT().update(receipt);
            mealEntity.setReceipt(receipt);


            mealEntity.setLanguage(Language.PL);
            mealEntity.setTitle(titleExcel);
            mealEntity.setShortDescription("Przepis z Excel");
            mealEntity.setAmountCalories((int) Math.round(caloriesExcel));
            mealEntity.setPublic(true);
            mealEntity.setCreatedDate(Instant.now());
            mealEntity.setAuthorReceipt(authorExcel);
            mealEntity.setCreatorMeal(userEntity);


            repo.MEAL().update(mealEntity);

            System.out.println();
            System.out.println();
            System.out.println("MEAL >>>>>" + counter);
            System.out.println(mealEntity.getIdMeal());
            System.out.println();
            System.out.println();
            counter++;

        }


    }

    private void addStepsToReceipt(Receipt receipt, String receiptExcel) {

        String[] spitedHeader = receiptExcel.split(";");

        for (int i = 0; i < spitedHeader.length; i++) {
            Step step = repo.STEP().insert(new Step());

            step.setHeader(spitedHeader[i]);
            step.setNumber(i + 1);
            step = repo.STEP().update(step);
            receipt.addStep(step);
        }
    }

}
