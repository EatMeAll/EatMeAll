package com.WildBirds.RepositoryJPA.domain.model;


import com.WildBirds.RepositoryJPA.domain.model.baseEntity.BaseEntity;
import com.WildBirds.RepositoryJPA.domain.model.enums.Language;

import javax.persistence.*;
import java.io.File;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Meal extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMeal;

    @Enumerated(EnumType.STRING)
    private Language language;

    private String title;

    private String shortDescription;

    private Integer amountCalories;

    private String authorReceipt;

    private File photo;

    private Boolean isPublic;

    private Instant createdDate;

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    @OneToOne()
    @JoinColumn(name = "idReceipt")
    private Receipt receipt;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "meal")
    private Set<MealHasProduct> mealHasProductSet = new HashSet<>();




    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "meal")
    private Set<MealHasDay> mealHasDaySet = new HashSet<>();




    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "MealHasTypeMeal",
            joinColumns = {@JoinColumn(name = "idMeal")},
            inverseJoinColumns = {@JoinColumn(name = "idTypeMeal")})
    private Set<TypeMeal> typeMealSet = new HashSet<>();


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "Favourites",
            joinColumns = {@JoinColumn(name = "idMeal")},
            inverseJoinColumns = {@JoinColumn(name = "idUser")})
    private Set<User> likedBySet = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User creatorMeal;

    public Meal() {
    }

    public void addMealHasProduct(MealHasProduct mealHasProduct){
        this.getMealHasProductSet().add(mealHasProduct);
        mealHasProduct.setMeal(this);
    }

    public void addLikedByUser(User user){
        this.getLikedBySet().add(user);
        user.getFavouritesMealsSet().add(this);
    }

    public void addMealHasDay(MealHasDay mealHasDay){
        this.getMealHasDaySet().add(mealHasDay);
        mealHasDay.setMeal(this);
    }

    public void addTypeMeal(TypeMeal typeMeal){
        this.getTypeMealSet().add(typeMeal);
        typeMeal.getMealSet().add(this);
    }

    public Integer getIdMeal() {
        return idMeal;
    }

    public void setIdMeal(Integer idMeal) {
        this.idMeal = idMeal;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Integer getAmountCalories() {
        return amountCalories;
    }

    public void setAmountCalories(Integer amountCalories) {
        this.amountCalories = amountCalories;
    }

    public String getAuthorReceipt() {
        return authorReceipt;
    }

    public void setAuthorReceipt(String authorReceipt) {
        this.authorReceipt = authorReceipt;
    }

    public File getPhoto() {
        return photo;
    }

    public void setPhoto(File photo) {
        this.photo = photo;
    }

    public Boolean getPublic() {
        return isPublic;
    }

    public void setPublic(Boolean aPublic) {
        isPublic = aPublic;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public Set<MealHasProduct> getMealHasProductSet() {
        return mealHasProductSet;
    }

    public void setMealHasProductSet(Set<MealHasProduct> mealHasProductSet) {
        this.mealHasProductSet = mealHasProductSet;
    }

    public Set<TypeMeal> getTypeMealSet() {
        return typeMealSet;
    }

    public void setTypeMealSet(Set<TypeMeal> typeMeal) {
        this.typeMealSet = typeMeal;
    }


    public Set<MealHasDay> getMealHasDaySet() {
        return mealHasDaySet;
    }

    public void setMealHasDaySet(Set<MealHasDay> mealHasDaySet) {
        this.mealHasDaySet = mealHasDaySet;
    }

    public Set<User> getLikedBySet() {
        return likedBySet;
    }

    public void setLikedBySet(Set<User> likedBySet) {
        this.likedBySet = likedBySet;
    }

    public User getCreatorMeal() {
        return creatorMeal;
    }

    public void setCreatorMeal(User creatorMeal) {
        this.creatorMeal = creatorMeal;
        creatorMeal.getMealsCreatedSet().add(this);
    }

    @Override
    public String toString() {
        return "Meal{" +
                "idMeal=" + idMeal +
                ", language=" + language +
                ", title='" + title + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", amountCalories=" + amountCalories +
                ", authorReceipt='" + authorReceipt + '\'' +
                ", photo=" + photo +
                ", isPublic=" + isPublic +
                ", createdDate=" + createdDate +
                ", receipt=" + receipt +
//                ", typeMeal=" + typeMeal +
//                ", usedInDays=" + usedInDays +
//                ", likedBySet=" + likedBySet +
                ", creatorMeal=" + creatorMeal +
                '}';
    }
}
