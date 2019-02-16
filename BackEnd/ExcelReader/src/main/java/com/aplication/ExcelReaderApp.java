package com.aplication;

import com.WildBirds.RepositoryJPA.application.RepositoryFacade;
import com.WildBirds.RepositoryJPA.domain.model.*;
import com.WildBirds.RepositoryJPA.domain.model.enums.Language;
import com.WildBirds.RepositoryJPA.domain.model.enums.MealTime;
import com.WildBirds.RepositoryJPA.domain.model.enums.ProductCategorie;
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
    private Map<String, ProductCategorie> categories = new HashMap<>();
    @EJB
    RepositoryFacade repo;

    public ExcelReaderApp() {
        this.initCategories();
    }

    private void initCategories() {
        categories.put("awokado",ProductCategorie.FRUIT);
        categories.put("banan", ProductCategorie.FRUIT);
        categories.put("batonik zbożowy", ProductCategorie.GRAINS);
        categories.put("biała kapusta", ProductCategorie.VEGETABLE);
        categories.put("boczek wędzony", ProductCategorie.FAT);
        categories.put("brokuły mrożone", ProductCategorie.VEGETABLE);
        categories.put("bułka", ProductCategorie.BAKING);
        categories.put("bułka do hamburgerów", ProductCategorie.BAKING);
        categories.put("bułka grahamka", ProductCategorie.BAKING);
        categories.put("bułka kajzerka", ProductCategorie.BAKING);
        categories.put("bułki grahamki", ProductCategorie.BAKING);
        categories.put("cebula", ProductCategorie.VEGETABLE);
        categories.put("cebula czerwona", ProductCategorie.VEGETABLE);
        categories.put("chleb pełnoziarnisty z żyta", ProductCategorie.BAKING);
        categories.put("chleb żytni razowy", ProductCategorie.BAKING);
        categories.put("chudy twaróg", ProductCategorie.DAIRY);
        categories.put("cukier wanilinowy", ProductCategorie.SPICE);
        categories.put("cukinia", ProductCategorie.VEGETABLE);
        categories.put("curry", ProductCategorie.VEGETABLE);
        categories.put("cynamon", ProductCategorie.SPICE);
        categories.put("czosnek", ProductCategorie.VEGETABLE);
        categories.put("daktyle suszone", ProductCategorie.FRUIT);
        categories.put("dorsz świeży", ProductCategorie.FISH);
        categories.put("dynia pestki łuskane", ProductCategorie.GRAINS);
        categories.put("dżem truskawowy niskosłodzony", ProductCategorie.OTHER);
        categories.put("dżem wiśniowy niskosłodzony", ProductCategorie.OTHER);
        categories.put("fasola czerwona", ProductCategorie.OTHER);
        categories.put("fasolka szparagowa", ProductCategorie.VEGETABLE);
        categories.put("grapefruit", ProductCategorie.FRUIT);
        categories.put("groszek zielony, konserwowy", ProductCategorie.OTHER);
        categories.put("gruszka", ProductCategorie.FRUIT);
        categories.put("grzybki marynowane", ProductCategorie.OTHER);
        categories.put("hummus klasyczny", ProductCategorie.OTHER);
        categories.put("jabłko", ProductCategorie.FRUIT);
        categories.put("jajko", ProductCategorie.OTHER);
        categories.put("jeżyny", ProductCategorie.FRUIT);
        categories.put("jogurt grecki", ProductCategorie.DAIRY);
        categories.put("jogurt naturalny", ProductCategorie.DAIRY);
        categories.put("jogurt owocowy", ProductCategorie.FRUIT);
        categories.put("kakao", ProductCategorie.OTHER);
        categories.put("kaki", ProductCategorie.FRUIT);
        categories.put("kasza bulgur", ProductCategorie.GRAINS);
        categories.put("kasza gryczana", ProductCategorie.GRAINS);
        categories.put("kasza jaglana", ProductCategorie.GRAINS);
        categories.put("kasza jęczmienna pęczak", ProductCategorie.GRAINS);
        categories.put("kefir", ProductCategorie.DAIRY);
        categories.put("ketchup", ProductCategorie.OTHER);
        categories.put("kiwi", ProductCategorie.FRUIT);
        categories.put("koncentrat pomidorowy", ProductCategorie.OTHER);
        categories.put("kukurydza konserwowa", ProductCategorie.OTHER);
        categories.put("majonez", ProductCategorie.OTHER);
        categories.put("majonez light", ProductCategorie.OTHER);
        categories.put("makaron pełnoziarnisty", ProductCategorie.OTHER);
        categories.put("makrela wędzona", ProductCategorie.FISH);
        categories.put("maliny", ProductCategorie.FRUIT);
        categories.put("mandarynki", ProductCategorie.FRUIT);
        categories.put("mango", ProductCategorie.FRUIT);
        categories.put("marchew", ProductCategorie.VEGETABLE);
        categories.put("masło extra", ProductCategorie.DAIRY);
        categories.put("masło orzechowe", ProductCategorie.OTHER);
        categories.put("maślanka", ProductCategorie.DAIRY);
        categories.put("mieszanka studencka", ProductCategorie.OTHER);
        categories.put("migdały", ProductCategorie.OTHER);
        categories.put("miód pszczeli", ProductCategorie.OTHER);
        categories.put("mięso mielone z kurczaka lub indyka", ProductCategorie.MEAT);
        categories.put("mięso wołowe", ProductCategorie.MEAT);
        categories.put("mięso z piersi indyka, bez skóry", ProductCategorie.MEAT);
        categories.put("mięso z piersi kurczaka, bez skóry", ProductCategorie.MEAT);
        categories.put("mięso z piersi z kurczaka", ProductCategorie.MEAT);
        categories.put("mleko", ProductCategorie.DAIRY);
        categories.put("morela suszona", ProductCategorie.OTHER);
        categories.put("musli z rodzynkami i orzechami", ProductCategorie.OTHER);
        categories.put("musztarda", ProductCategorie.OTHER);
        categories.put("mąka pszenna typ 1850", ProductCategorie.GRAINS);
        categories.put("mąka pszenna typ 750", ProductCategorie.GRAINS);
        categories.put("nasiona chia", ProductCategorie.GRAINS);
        categories.put("nektarynka", ProductCategorie.FRUIT);
        categories.put("ogórek", ProductCategorie.VEGETABLE);
        categories.put("ogórek kiszony", ProductCategorie.VEGETABLE);
        categories.put("ogórek kiszony/konserwowy", ProductCategorie.VEGETABLE);
        categories.put("ogórek zielony", ProductCategorie.VEGETABLE);
        categories.put("olej lniany", ProductCategorie.OTHER);
        categories.put("olej rzepakowy", ProductCategorie.OTHER);
        categories.put("oliwa z oliwek", ProductCategorie.OTHER);
        categories.put("oliwki czarne", ProductCategorie.VEGETABLE);
        categories.put("oregano", ProductCategorie.SPICE);
        categories.put("orzechy włoskie", ProductCategorie.GRAINS);
        categories.put("otreby przenne", ProductCategorie.GRAINS);
        categories.put("papryka czerwona", ProductCategorie.VEGETABLE);
        categories.put("papryka słodka", ProductCategorie.VEGETABLE);
        categories.put("pasta pomidorowa", ProductCategorie.SPICE);
        categories.put("pasztet z kurczaka", ProductCategorie.OTHER);
        categories.put("pesto zielone z bazylii", ProductCategorie.OTHER);
        categories.put("pieczarki", ProductCategorie.VEGETABLE);
        categories.put("pieczywo wasa", ProductCategorie.BAKING);
        categories.put("pierś z kurczaka", ProductCategorie.MEAT);
        categories.put("pietruszka liście", ProductCategorie.VEGETABLE);
        categories.put("pietruszka natka", ProductCategorie.VEGETABLE);
        categories.put("pomarańcza", ProductCategorie.FRUIT);
        categories.put("pomidor", ProductCategorie.VEGETABLE);
        categories.put("pomidory koktajlowe", ProductCategorie.VEGETABLE);
        categories.put("pomidory krojone w soku pomidorowym", ProductCategorie.VEGETABLE);
        categories.put("pomidory z puszki, krojone", ProductCategorie.VEGETABLE);
        categories.put("por", ProductCategorie.VEGETABLE);
        categories.put("pumpernikiel", ProductCategorie.BAKING);
        categories.put("płatki kukurydziane", ProductCategorie.GRAINS);
        categories.put("płatki owsiane górskie", ProductCategorie.GRAINS);
        categories.put("rodzynki suszone", ProductCategorie.FRUIT);
        categories.put("rukola", ProductCategorie.VEGETABLE);
        categories.put("ryż", ProductCategorie.GRAINS);
        categories.put("ryż brązowy", ProductCategorie.GRAINS);
        categories.put("rzodkiewka", ProductCategorie.VEGETABLE);
        categories.put("sałata", ProductCategorie.VEGETABLE);
        categories.put("schab bez kości", ProductCategorie.MEAT);
        categories.put("ser feta", ProductCategorie.DAIRY);
        categories.put("ser mozzarella", ProductCategorie.DAIRY);
        categories.put("ser twaróg chudy", ProductCategorie.DAIRY);
        categories.put("ser żółty", ProductCategorie.DAIRY);
        categories.put("serek naturalny do smarowania", ProductCategorie.DAIRY);
        categories.put("serek wiejski",  ProductCategorie.DAIRY);
        categories.put("sok cytrynowy", ProductCategorie.DRINK);
        categories.put("sok jabłkowy", ProductCategorie.DRINK);
        categories.put("sok pomarańczowy", ProductCategorie.DRINK);
        categories.put("sok pomidorowy", ProductCategorie.DRINK);
        categories.put("sok z cytryny", ProductCategorie.DRINK);
        categories.put("sok z czarnej porzeczki", ProductCategorie.DRINK);
        categories.put("sos sojowy ciemny", ProductCategorie.OTHER);
        categories.put("surówka gotowa", ProductCategorie.VEGETABLE);
        categories.put("suszone pomidory", ProductCategorie.VEGETABLE);
        categories.put("szczypiorek", ProductCategorie.VEGETABLE);
        categories.put("szpinak", ProductCategorie.VEGETABLE);
        categories.put("szpinak mrożony", ProductCategorie.VEGETABLE);
        categories.put("szynka", ProductCategorie.MEAT);
        categories.put("szynka z piersi kurczaka", ProductCategorie.MEAT);
        categories.put("słonecznik łuskany", ProductCategorie.GRAINS);
        categories.put("tofu wędzone", ProductCategorie.OTHER);
        categories.put("tortilla pełnoziarnista", ProductCategorie.BAKING);
        categories.put("truskawki mrożone", ProductCategorie.FRUIT);
        categories.put("tuńczyk w sosie własnym", ProductCategorie.FISH);
        categories.put("twaróg chudy", ProductCategorie.DAIRY);
        categories.put("wafle ryżowe", ProductCategorie.BAKING);
        categories.put("wafle ryżowe naturalne", ProductCategorie.BAKING);
        categories.put("woda", ProductCategorie.DRINK);
        categories.put("ziemniaki", ProductCategorie.VEGETABLE);
        categories.put("zioła prowansaldzkie", ProductCategorie.SPICE);
        categories.put("zółty ser", ProductCategorie.DAIRY);
        categories.put("żurawina suszona", ProductCategorie.OTHER);
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
                    ProductCategorie categorie = this.setCategorie(productsExcelName);
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


    private ProductCategorie setCategorie(String productsExcelName) {

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
