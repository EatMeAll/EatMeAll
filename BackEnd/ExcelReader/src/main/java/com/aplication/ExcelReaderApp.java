package com.aplication;

import com.WildBirds.RepositoryJPA.application.RepositoryFacade;
import com.WildBirds.RepositoryJPA.domain.model.*;
import com.WildBirds.RepositoryJPA.domain.model.enums.Language;
import com.WildBirds.RepositoryJPA.domain.model.enums.MealTime;
import com.WildBirds.RepositoryJPA.domain.model.enums.ProductCategory;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Stateless
@LocalBean
public class ExcelReaderApp {
    private String basePath = "/opt/jboss/excel";
    private Map<String, ProductCategory> categories = new HashMap<>();
    @EJB
    RepositoryFacade repo;

    public ExcelReaderApp() {
        this.initCategories();
    }

    private void initCategories() {
        categories.put("awokado", ProductCategory.FRUIT);
        categories.put("banan", ProductCategory.FRUIT);
        categories.put("batonik zbożowy", ProductCategory.GRAINS);
        categories.put("biała kapusta", ProductCategory.VEGETABLE);
        categories.put("boczek wędzony", ProductCategory.MEAT);
        categories.put("brokuły mrożone", ProductCategory.VEGETABLE);
        categories.put("bułka", ProductCategory.BAKING);
        categories.put("bułka do hamburgerów", ProductCategory.BAKING);
        categories.put("bułka grahamka", ProductCategory.BAKING);
        categories.put("bułka kajzerka", ProductCategory.BAKING);
        categories.put("bułki grahamki", ProductCategory.BAKING);
        categories.put("cebula", ProductCategory.VEGETABLE);
        categories.put("cebula czerwona", ProductCategory.VEGETABLE);
        categories.put("chleb pełnoziarnisty z żyta", ProductCategory.BAKING);
        categories.put("chleb żytni razowy", ProductCategory.BAKING);
        categories.put("chudy twaróg", ProductCategory.DAIRY);
        categories.put("cukier wanilinowy", ProductCategory.SPICE);
        categories.put("cukinia", ProductCategory.VEGETABLE);
        categories.put("curry", ProductCategory.VEGETABLE);
        categories.put("cynamon", ProductCategory.SPICE);
        categories.put("czosnek", ProductCategory.VEGETABLE);
        categories.put("daktyle suszone", ProductCategory.FRUIT);
        categories.put("dorsz świeży", ProductCategory.FISH);
        categories.put("dynia pestki łuskane", ProductCategory.GRAINS);
        categories.put("dżem truskawowy niskosłodzony", ProductCategory.OTHER);
        categories.put("dżem wiśniowy niskosłodzony", ProductCategory.OTHER);
        categories.put("fasola czerwona", ProductCategory.OTHER);
        categories.put("fasolka szparagowa", ProductCategory.VEGETABLE);
        categories.put("grapefruit", ProductCategory.FRUIT);
        categories.put("groszek zielony, konserwowy", ProductCategory.OTHER);
        categories.put("gruszka", ProductCategory.FRUIT);
        categories.put("grzybki marynowane", ProductCategory.OTHER);
        categories.put("hummus klasyczny", ProductCategory.OTHER);
        categories.put("jabłko", ProductCategory.FRUIT);
        categories.put("jajko", ProductCategory.OTHER);
        categories.put("jeżyny", ProductCategory.FRUIT);
        categories.put("jogurt grecki", ProductCategory.DAIRY);
        categories.put("jogurt naturalny", ProductCategory.DAIRY);
        categories.put("jogurt owocowy", ProductCategory.FRUIT);
        categories.put("kakao", ProductCategory.OTHER);
        categories.put("kaki", ProductCategory.FRUIT);
        categories.put("kasza bulgur", ProductCategory.GRAINS);
        categories.put("kasza gryczana", ProductCategory.GRAINS);
        categories.put("kasza jaglana", ProductCategory.GRAINS);
        categories.put("kasza jęczmienna pęczak", ProductCategory.GRAINS);
        categories.put("kefir", ProductCategory.DAIRY);
        categories.put("ketchup", ProductCategory.OTHER);
        categories.put("kiwi", ProductCategory.FRUIT);
        categories.put("koncentrat pomidorowy", ProductCategory.OTHER);
        categories.put("kukurydza konserwowa", ProductCategory.OTHER);
        categories.put("kuskus", ProductCategory.GRAINS);
        categories.put("majonez", ProductCategory.OTHER);
        categories.put("majonez light", ProductCategory.OTHER);
        categories.put("makaron pełnoziarnisty", ProductCategory.OTHER);
        categories.put("makrela wędzona", ProductCategory.FISH);
        categories.put("maliny", ProductCategory.FRUIT);
        categories.put("mandarynki", ProductCategory.FRUIT);
        categories.put("mango", ProductCategory.FRUIT);
        categories.put("marchew", ProductCategory.VEGETABLE);
        categories.put("masło extra", ProductCategory.DAIRY);
        categories.put("masło orzechowe", ProductCategory.OTHER);
        categories.put("maślanka", ProductCategory.DAIRY);
        categories.put("mieszanka studencka", ProductCategory.OTHER);
        categories.put("migdały", ProductCategory.OTHER);
        categories.put("miód pszczeli", ProductCategory.OTHER);
        categories.put("mięso mielone z kurczaka lub indyka", ProductCategory.MEAT);
        categories.put("mięso wołowe", ProductCategory.MEAT);
        categories.put("mięso z piersi indyka, bez skóry", ProductCategory.MEAT);
        categories.put("mięso z piersi kurczaka, bez skóry", ProductCategory.MEAT);
        categories.put("mięso z piersi z kurczaka", ProductCategory.MEAT);
        categories.put("mleko", ProductCategory.DAIRY);
        categories.put("morela suszona", ProductCategory.OTHER);
        categories.put("musli z rodzynkami i orzechami", ProductCategory.OTHER);
        categories.put("musztarda", ProductCategory.OTHER);
        categories.put("mąka pszenna typ 1850", ProductCategory.GRAINS);
        categories.put("mąka pszenna typ 750", ProductCategory.GRAINS);
        categories.put("nasiona chia", ProductCategory.GRAINS);
        categories.put("nektarynka", ProductCategory.FRUIT);
        categories.put("ogórek", ProductCategory.VEGETABLE);
        categories.put("ogórek kiszony", ProductCategory.VEGETABLE);
        categories.put("ogórek kiszony/konserwowy", ProductCategory.VEGETABLE);
        categories.put("ogórek zielony", ProductCategory.VEGETABLE);
        categories.put("olej lniany", ProductCategory.OTHER);
        categories.put("olej rzepakowy", ProductCategory.OTHER);
        categories.put("oliwa z oliwek", ProductCategory.OTHER);
        categories.put("oliwki czarne", ProductCategory.VEGETABLE);
        categories.put("oregano", ProductCategory.SPICE);
        categories.put("orzechy włoskie", ProductCategory.GRAINS);
        categories.put("otreby przenne", ProductCategory.GRAINS);
        categories.put("papryka czerwona", ProductCategory.VEGETABLE);
        categories.put("papryka słodka", ProductCategory.VEGETABLE);
        categories.put("pasta pomidorowa", ProductCategory.SPICE);
        categories.put("pasztet z kurczaka", ProductCategory.OTHER);
        categories.put("pesto zielone z bazylii", ProductCategory.OTHER);
        categories.put("pieczarki", ProductCategory.VEGETABLE);
        categories.put("pieczywo wasa", ProductCategory.BAKING);
        categories.put("pierś z kurczaka", ProductCategory.MEAT);
        categories.put("pietruszka liście", ProductCategory.VEGETABLE);
        categories.put("pietruszka natka", ProductCategory.VEGETABLE);
        categories.put("pomarańcza", ProductCategory.FRUIT);
        categories.put("pomidor", ProductCategory.VEGETABLE);
        categories.put("pomidory koktajlowe", ProductCategory.VEGETABLE);
        categories.put("pomidory krojone w soku pomidorowym", ProductCategory.VEGETABLE);
        categories.put("pomidory z puszki, krojone", ProductCategory.VEGETABLE);
        categories.put("por", ProductCategory.VEGETABLE);
        categories.put("pumpernikiel", ProductCategory.BAKING);
        categories.put("płatki kukurydziane", ProductCategory.GRAINS);
        categories.put("płatki owsiane górskie", ProductCategory.GRAINS);
        categories.put("rodzynki suszone", ProductCategory.FRUIT);
        categories.put("rukola", ProductCategory.VEGETABLE);
        categories.put("ryż", ProductCategory.GRAINS);
        categories.put("ryż brązowy", ProductCategory.GRAINS);
        categories.put("rzodkiewka", ProductCategory.VEGETABLE);
        categories.put("sałata", ProductCategory.VEGETABLE);
        categories.put("schab bez kości", ProductCategory.MEAT);
        categories.put("ser feta", ProductCategory.DAIRY);
        categories.put("ser mozzarella", ProductCategory.DAIRY);
        categories.put("ser twaróg chudy", ProductCategory.DAIRY);
        categories.put("ser żółty", ProductCategory.DAIRY);
        categories.put("serek naturalny do smarowania", ProductCategory.DAIRY);
        categories.put("serek wiejski",  ProductCategory.DAIRY);
        categories.put("sok cytrynowy", ProductCategory.DRINK);
        categories.put("sok jabłkowy", ProductCategory.DRINK);
        categories.put("sok pomarańczowy", ProductCategory.DRINK);
        categories.put("sok pomidorowy", ProductCategory.DRINK);
        categories.put("sok z cytryny", ProductCategory.DRINK);
        categories.put("sok z czarnej porzeczki", ProductCategory.DRINK);
        categories.put("sos sojowy ciemny", ProductCategory.OTHER);
        categories.put("surówka gotowa", ProductCategory.VEGETABLE);
        categories.put("suszone pomidory", ProductCategory.VEGETABLE);
        categories.put("szczypiorek", ProductCategory.VEGETABLE);
        categories.put("szpinak", ProductCategory.VEGETABLE);
        categories.put("szpinak mrożony", ProductCategory.VEGETABLE);
        categories.put("szynka", ProductCategory.MEAT);
        categories.put("szynka z piersi kurczaka", ProductCategory.MEAT);
        categories.put("słonecznik łuskany", ProductCategory.GRAINS);
        categories.put("tofu wędzone", ProductCategory.OTHER);
        categories.put("tortilla pełnoziarnista", ProductCategory.BAKING);
        categories.put("truskawki mrożone", ProductCategory.FRUIT);
        categories.put("tuńczyk w sosie własnym", ProductCategory.FISH);
        categories.put("twaróg chudy", ProductCategory.DAIRY);
        categories.put("wafle ryżowe", ProductCategory.BAKING);
        categories.put("wafle ryżowe naturalne", ProductCategory.BAKING);
        categories.put("woda", ProductCategory.DRINK);
        categories.put("ziemniaki", ProductCategory.VEGETABLE);
        categories.put("zioła prowansaldzkie", ProductCategory.SPICE);
        categories.put("zółty ser", ProductCategory.DAIRY);
        categories.put("żurawina suszona", ProductCategory.OTHER);
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public void addToDatabase() throws IOException {
// "\\ExcelReader\\src\\main\\resources\\data

        int counter = 0;

        ExcelReader excelReader = new XmlReader();
        String filePath = basePath + "/jadlospis2.xlsx";
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
            File photo = new File(basePath + "/jadlospis2.xlsx");

            switch (typeMealExcel) {

                case "śniadanie":
                    mealTime = MealTime.BREAKFAST;
                    photo = new File(basePath + "/breakfast.jpg");
                    break;

                case "lunch":
                    mealTime = MealTime.LUNCH;
                    photo = new File(basePath + "/lunch.jpg");
                    break;

                case "obiad":
                    mealTime = MealTime.DINNER;
                    photo = new File(basePath + "/dinner.jpg");
                    break;
                case "przekąska":
                    mealTime = MealTime.SNACK;
                    photo = new File(basePath + "/snack.jpg");
                    break;

                case "kolacja":
                    mealTime = MealTime.SUPPER;
                    photo = new File(basePath + "/supper.jpg");
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
                    ProductCategory categorie = this.setCategory(productsExcelName);
                    product = repo.PRODUCT().insert(new Product(productsExcelName, productsExcelUnit, categorie));
                }


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


    private ProductCategory setCategory(String productsExcelName) {
        if (categories.get(productsExcelName) != null){
            return categories.get(productsExcelName);
        }else {
            return ProductCategory.UNKNOWN;
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
