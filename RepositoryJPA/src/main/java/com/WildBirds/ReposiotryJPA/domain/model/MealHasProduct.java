package com.WildBirds.ReposiotryJPA.domain.model;

import javax.persistence.*;

@Entity
public class MealHasProduct {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   @ManyToOne
   @JoinColumn(name = "idMeal")
   private Meal meal;
   @ManyToOne
   @JoinColumn(name = "idProduct")
   private Product product;

   private Integer amount;

   private String unit;

   private String specialUnit;

   public MealHasProduct() {
   }

   public Meal getMeal() {
      return meal;
   }

   public void setMeal(Meal meal) {
      this.meal = meal;
   }

   public Product getProduct() {
      return product;
   }

   public void setProduct(Product product) {
      this.product = product;
   }

   public Integer getAmount() {
      return amount;
   }

   public void setAmount(Integer amount) {
      this.amount = amount;
   }

   public String getUnit() {
      return unit;
   }

   public void setUnit(String unit) {
      this.unit = unit;
   }

   public String getSpecialUnit() {
      return specialUnit;
   }

   public void setSpecialUnit(String specialUnit) {
      this.specialUnit = specialUnit;
   }
}
