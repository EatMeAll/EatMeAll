package com.WildBirds.RepositoryJPA.domain.model;

import com.WildBirds.RepositoryJPA.domain.model.baseEntity.BaseEntity;

import javax.persistence.*;

@Entity
public class MealHasProduct extends BaseEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer idMealHasProduct;
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

    public Integer getIdMealHasProduct() {
        return idMealHasProduct;
    }

    public void setIdMealHasProduct(Integer idMealHasProduct) {
        this.idMealHasProduct = idMealHasProduct;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
        meal.getMealHasProductSet().add(this);
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
