package com.WildBirds.EatMeAll.application.DTO.full_;


import com.WildBirds.EatMeAll.application.DTO.unit_.ProductUnitDTO;
import com.WildBirds.RepositoryJPA.domain.model.enums.Language;


import java.time.Instant;
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
    private Set<ProductUnitDTO> products;


    public MealDTO() {
    }

    public MealDTO(Integer idMeal, Language language, String title, String shortDescription, Integer amountCalories, String authorReceipt, Integer idPhoto, Boolean isPublic, Instant createdDate, ReceiptDTO receiptDTO, Set<TypeMealDTO> typeMeal, UserDTO creatorMeal, Set<ProductUnitDTO> products) {
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

    public Set<ProductUnitDTO> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductUnitDTO> products) {
        this.products = products;
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
