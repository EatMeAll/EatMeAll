package com.WildBirds.EatMeAll.application.modelDTO;

import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.List;

@NoArgsConstructor
@Builder
public class MealDTO {
    private Integer idMeal;
    private Language language;
    private List<TypeMeal> typeMeal;
    private Integer prepaidTime;
    private String title;
    private List<ProductDTO> products;
    private String receipt;
    private String description;
    private Integer amountCalories;
    private String authorReceipt;
    private File photo;

}
