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
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "meal", fetch = FetchType.EAGER)
    private Set<MealHasProduct> mealHasProductSet = new HashSet<>();


    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(name = "MealHasTypeMeal",
            joinColumns = {@JoinColumn(name = "idMeal")},
            inverseJoinColumns = {@JoinColumn(name = "idTypeMeal")})
    private Set<TypeMeal> typeMealSet = new HashSet<>();


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "MealHasDay",
            joinColumns = {@JoinColumn(name = "idMeal")},
            inverseJoinColumns = {@JoinColumn(name = "idDay")})
    private Set<Day> usedInDaysSet = new HashSet<>();


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
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

    public void addDayWhichUse(Day day){
        this.getUsedInDaysSet().add(day);
        day.getMealsSet().add(this);
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

    public Set<Day> getUsedInDaysSet() {
        return usedInDaysSet;
    }

    public void setUsedInDaysSet(Set<Day> usedInDays) {
        this.usedInDaysSet = usedInDays;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Meal meal = (Meal) o;

        if (idMeal != null ? !idMeal.equals(meal.idMeal) : meal.idMeal != null) return false;
        if (language != meal.language) return false;
        if (title != null ? !title.equals(meal.title) : meal.title != null) return false;
        if (shortDescription != null ? !shortDescription.equals(meal.shortDescription) : meal.shortDescription != null)
            return false;
        if (amountCalories != null ? !amountCalories.equals(meal.amountCalories) : meal.amountCalories != null)
            return false;
        if (authorReceipt != null ? !authorReceipt.equals(meal.authorReceipt) : meal.authorReceipt != null)
            return false;
        if (photo != null ? !photo.equals(meal.photo) : meal.photo != null) return false;
        if (isPublic != null ? !isPublic.equals(meal.isPublic) : meal.isPublic != null) return false;
        if (createdDate != null ? !createdDate.equals(meal.createdDate) : meal.createdDate != null) return false;
        if (receipt != null ? !receipt.equals(meal.receipt) : meal.receipt != null) return false;
        if (mealHasProductSet != null ? !mealHasProductSet.equals(meal.mealHasProductSet) : meal.mealHasProductSet != null)
            return false;
        if (typeMealSet != null ? !typeMealSet.equals(meal.typeMealSet) : meal.typeMealSet != null) return false;
        if (usedInDaysSet != null ? !usedInDaysSet.equals(meal.usedInDaysSet) : meal.usedInDaysSet != null)
            return false;
        if (likedBySet != null ? !likedBySet.equals(meal.likedBySet) : meal.likedBySet != null) return false;
        return creatorMeal != null ? creatorMeal.equals(meal.creatorMeal) : meal.creatorMeal == null;
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
