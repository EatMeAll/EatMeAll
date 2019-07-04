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
    private Double amountCalories;
    private Double amountProtein;
    private Double amountFat;
    private Double amountCarbohydrates;
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

    public MealDTO(Integer aIdMeal, Language aLanguage, String aTitle, String aShortDescription, Double aAmountCalories, Double aAmountProtein, Double aAmountFat, Double aAmountCarbohydrates, String aAuthorReceipt, Integer aIdPhoto, Boolean aIsPublic, Instant aCreatedDate, ReceiptDTO aReceiptDTO, Set<TypeMealDTO> aTypeMeal, UserDTO aCreatorMeal, Set<ProductUnitDTO> aProducts) {
        idMeal = aIdMeal;
        language = aLanguage;
        title = aTitle;
        shortDescription = aShortDescription;
        amountCalories = aAmountCalories;
        amountProtein = aAmountProtein;
        amountFat = aAmountFat;
        amountCarbohydrates = aAmountCarbohydrates;
        authorReceipt = aAuthorReceipt;
        idPhoto = aIdPhoto;
        isPublic = aIsPublic;
        createdDate = aCreatedDate;
        receiptDTO = aReceiptDTO;
        typeMeal = aTypeMeal;
        creatorMeal = aCreatorMeal;
        products = aProducts;
    }

    public void setAmountCalories(Double aAmountCalories) {
        amountCalories = aAmountCalories;
    }

    public Double getAmountProtein() {
        return amountProtein;
    }

    public void setAmountProtein(Double aAmountProtein) {
        amountProtein = aAmountProtein;
    }

    public Double getAmountFat() {
        return amountFat;
    }

    public void setAmountFat(Double aAmountFat) {
        amountFat = aAmountFat;
    }

    public Double getAmountCarbohydrates() {
        return amountCarbohydrates;
    }

    public void setAmountCarbohydrates(Double aAmountCarbohydrates) {
        amountCarbohydrates = aAmountCarbohydrates;
    }

    public Integer getIdPhoto() {
        return idPhoto;
    }

    public void setIdPhoto(Integer aIdPhoto) {
        idPhoto = aIdPhoto;
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

    public Double getAmountCalories() {
        return amountCalories;
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
