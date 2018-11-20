package com.WildBirds.EatMeAll.application.modelDTO;


import com.WildBirds.RepositoryJPA.domain.model.enums.Language;


import java.time.Instant;
import java.util.List;
import java.util.Set;

public class MealDTO {
    private Integer idMeal;
    private Language language;
    private String title;
    private String shortDescription;
    private Integer amountCalories;
    private String authorReceipt;
    private Integer idPhoto;
    private Boolean isPublic;
    private Instant createdDate;
    private ReceiptDTO receiptDTO;
    private Set<TypeMealDTO> typeMeal;
    private UserDTO creatorMeal;
    private Set<ProductDTO> products;


    public MealDTO() {
    }

    public MealDTO(Integer idMeal, Language language, String title, String shortDescription, Integer amountCalories, String authorReceipt, Integer idPhoto, Boolean isPublic, Instant createdDate, ReceiptDTO receiptDTO, Set<TypeMealDTO> typeMeal, UserDTO creatorMeal, Set<ProductDTO> products) {
        this.idMeal = idMeal;
        this.language = language;
        this.title = title;
        this.shortDescription = shortDescription;
        this.amountCalories = amountCalories;
        this.authorReceipt = authorReceipt;
        this.idPhoto = idPhoto;
        this.isPublic = isPublic;
        this.createdDate = createdDate;
        this.receiptDTO = receiptDTO;
        this.typeMeal = typeMeal;
        this.creatorMeal = creatorMeal;
        this.products = products;
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

    public Integer getPhoto() {
        return idPhoto;
    }

    public void setPhoto(Integer idPhoto) {
        this.idPhoto = idPhoto;
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

    public ReceiptDTO getReceiptDTO() {
        return receiptDTO;
    }

    public void setReceiptDTO(ReceiptDTO receiptDTO) {
        this.receiptDTO = receiptDTO;
    }

    public Set<TypeMealDTO> getTypeMeal() {
        return typeMeal;
    }

    public void setTypeMeal(Set<TypeMealDTO> typeMeal) {
        this.typeMeal = typeMeal;
    }

    public UserDTO getCreatorMeal() {
        return creatorMeal;
    }

    public void setCreatorMeal(UserDTO creatorMeal) {
        this.creatorMeal = creatorMeal;
    }

    public Set<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductDTO> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MealDTO mealDTO = (MealDTO) o;

        if (idMeal != null ? !idMeal.equals(mealDTO.idMeal) : mealDTO.idMeal != null) return false;
        if (language != mealDTO.language) return false;
        if (title != null ? !title.equals(mealDTO.title) : mealDTO.title != null) return false;
        if (shortDescription != null ? !shortDescription.equals(mealDTO.shortDescription) : mealDTO.shortDescription != null)
            return false;
        if (amountCalories != null ? !amountCalories.equals(mealDTO.amountCalories) : mealDTO.amountCalories != null)
            return false;
        if (authorReceipt != null ? !authorReceipt.equals(mealDTO.authorReceipt) : mealDTO.authorReceipt != null)
            return false;
        if (idPhoto != null ? !idPhoto.equals(mealDTO.idPhoto) : mealDTO.idPhoto != null) return false;
        if (isPublic != null ? !isPublic.equals(mealDTO.isPublic) : mealDTO.isPublic != null) return false;
        if (createdDate != null ? !createdDate.equals(mealDTO.createdDate) : mealDTO.createdDate != null) return false;
        if (receiptDTO != null ? !receiptDTO.equals(mealDTO.receiptDTO) : mealDTO.receiptDTO != null) return false;
        if (typeMeal != null ? !typeMeal.equals(mealDTO.typeMeal) : mealDTO.typeMeal != null) return false;
        if (creatorMeal != null ? !creatorMeal.equals(mealDTO.creatorMeal) : mealDTO.creatorMeal != null) return false;
        return products != null ? products.equals(mealDTO.products) : mealDTO.products == null;
    }

    @Override
    public int hashCode() {
        int result = idMeal != null ? idMeal.hashCode() : 0;
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (shortDescription != null ? shortDescription.hashCode() : 0);
        result = 31 * result + (amountCalories != null ? amountCalories.hashCode() : 0);
        result = 31 * result + (authorReceipt != null ? authorReceipt.hashCode() : 0);
        result = 31 * result + (idPhoto != null ? idPhoto.hashCode() : 0);
        result = 31 * result + (isPublic != null ? isPublic.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (receiptDTO != null ? receiptDTO.hashCode() : 0);
        result = 31 * result + (typeMeal != null ? typeMeal.hashCode() : 0);
        result = 31 * result + (creatorMeal != null ? creatorMeal.hashCode() : 0);
        result = 31 * result + (products != null ? products.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MealDTO{" +
                "idMeal=" + idMeal +
                ", language=" + language +
                ", title='" + title + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", amountCalories=" + amountCalories +
                ", authorReceipt='" + authorReceipt + '\'' +
                ", idPhoto=" + idPhoto +
                ", isPublic=" + isPublic +
                ", createdDate=" + createdDate +
                ", receiptDTO=" + receiptDTO +
                ", typeMeal=" + typeMeal +
                ", creatorMeal=" + creatorMeal +
                ", products=" + products +
                '}';
    }
}
