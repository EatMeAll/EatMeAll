package com.WildBirds.EatMeAll.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.List;

@Data
@NoArgsConstructor
public class Meal {
    private Integer idMeal;
    private Language language;
    private List<TypeMeal> typeMeal;
    private Integer prepareTime;
    private String title;
    private List<Product> products;
    private String receipt;
    private String description;
    private Integer amountCalories;
    private String authorReceipt;
    private File photo;
}
