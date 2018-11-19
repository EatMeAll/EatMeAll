package com.WildBirds.EatMeAll.application.modelDTO;


import com.WildBirds.RepositoryJPA.domain.model.enums.Language;

import java.io.File;
import java.time.Instant;
import java.util.List;

public class MealDTO {
    private Integer idMeal;
    private Language language;
    private String title;
    private String shortDescription;
    private Integer amountCalories;
    private String authorReceipt;
    private File photo;
    private Boolean isPublic;
    private Instant createdDate;
    private ReceiptDTO receipt;
    private List<TypeMealDTO> typeMeal;
    private UserDTO creatorMeal;
    private List<ProductDTO> products;
    private Integer prepaidTime;
    private String description;

    public MealDTO(Integer idMeal, Language language, String title, String shortDescription, Integer amountCalories, String authorReceipt, File photo, Boolean isPublic, Instant createdDate, ReceiptDTO receipt, List<TypeMealDTO> typeMeal, UserDTO creatorMeal, List<ProductDTO> products, Integer prepaidTime, String description) {
        this.idMeal = idMeal;
        this.language = language;
        this.title = title;
        this.shortDescription = shortDescription;
        this.amountCalories = amountCalories;
        this.authorReceipt = authorReceipt;
        this.photo = photo;
        this.isPublic = isPublic;
        this.createdDate = createdDate;
        this.receipt = receipt;
        this.typeMeal = typeMeal;
        this.creatorMeal = creatorMeal;
        this.products = products;
        this.prepaidTime = prepaidTime;
        this.description = description;
    }

    public MealDTO() {
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

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public ReceiptDTO getReceipt() {
        return receipt;
    }

    public void setReceipt(ReceiptDTO receipt) {
        this.receipt = receipt;
    }

    public List<TypeMealDTO> getTypeMeal() {
        return typeMeal;
    }

    public void setTypeMeal(List<TypeMealDTO> typeMeal) {
        this.typeMeal = typeMeal;
    }

    public UserDTO getCreatorMeal() {
        return creatorMeal;
    }

    public void setCreatorMeal(UserDTO creatorMeal) {
        this.creatorMeal = creatorMeal;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }

    public Integer getPrepaidTime() {
        return prepaidTime;
    }

    public void setPrepaidTime(Integer prepaidTime) {
        this.prepaidTime = prepaidTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
