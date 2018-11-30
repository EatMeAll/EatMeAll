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

   private Double amount;

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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getSpecialUnit() {
        return specialUnit;
    }

    public void setSpecialUnit(String specialUnit) {
        this.specialUnit = specialUnit;
    }

    @Override
    public String toString() {
        return "MealHasProduct{" +
                "idMealHasProduct=" + idMealHasProduct +
                ", meal=" + meal +
                ", product=" + product +
                ", amount=" + amount +
                ", specialUnit='" + specialUnit + '\'' +
                '}';
    }
}
