package com.WildBirds.EatMeAll.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MealHasProduct {
   private Meal meal;
   private Product product;
   private Integer amount;
   private String unit;
   private String specialUnit;

}
