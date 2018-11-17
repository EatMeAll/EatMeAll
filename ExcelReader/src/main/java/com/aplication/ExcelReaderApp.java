package com.aplication;

import com.WildBirds.RepositoryJPA.application.RepositoryFacade;
import com.WildBirds.RepositoryJPA.domain.model.*;
import com.WildBirds.RepositoryJPA.domain.model.enums.Language;
import com.WildBirds.RepositoryJPA.domain.model.enums.MealTime;
import com.domain.model.MealExcel;
import com.domain.model.ProductsExcel;
import com.domain.ports.ExcelReader;
import com.infrastructure.XmlReader;


import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
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
        user.setPassword("jakies haslo");

//        repo.USER().insert(user);

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

                case "sniadanie":

                    typeMealEntity.setMealTime(MealTime.BREAKFAST);
                    break;

                case "lunch":

                    typeMealEntity.setMealTime(MealTime.LUNCH);
                    break;

                case "obiad":

                    typeMealEntity.setMealTime(MealTime.DINNER);
                    break;

                case "kolacja":

                    typeMealEntity.setMealTime(MealTime.SUPPER);
                    break;
            }
            repo.TYPEMEAL().insert(typeMealEntity);


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
                mealEntity.getMealHasProductSet().add(mealHasProduct);
            }

            Receipt receipt = new Receipt();

//            Step step = new Step();
//            step.setHeader(receiptExcel);
//            step.setNumber(1);
//            repo.STEP().insert(step);

            receipt.setDescription("Jakis dodatkowy opis");
            receipt.setTitle(titleExcel);
            receipt.setPrepareTime(prepairTimeExcel);
//            receipt.getStepSet().add(step);
            repo.RECEIPT().insert(receipt);



            mealEntity.setLanguage(Language.PL);
            mealEntity.setTitle(titleExcel);
            mealEntity.setShortDescription("Przepis z Excel");
            mealEntity.setAmountCalories((int) Math.round(caloriesExcel));
            mealEntity.setPublic(true);
            mealEntity.setCreatedDate(Instant.now());
            mealEntity.getTypeMeal().add(typeMealEntity);
            mealEntity.setReceipt(receipt);
            mealEntity.setAuthorReceipt(authorExcel);


//            repo.MEAL().insert(mealEntity);

        }


    }
}
