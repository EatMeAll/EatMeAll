package com.WildBirds.RepositoryJPA.domain.model;


import javax.persistence.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMeal;

    private Language language;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "MealHasTypeMeal",
            joinColumns = {@JoinColumn(name = "idMeal")},
            inverseJoinColumns = {@JoinColumn(name = "idTypeMeal")})
    private Set<TypeMeal> typeMeal = new HashSet<>();

    private Integer prepareTime;

    private String title;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "idMeal")
    private List<Product> products = new ArrayList<>();

    private String receipt;

    private String description;

    private Integer amountCalories;

    private String authorReceipt;

    private File photo;

    public Meal() {
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

    public Set<TypeMeal> getTypeMeal() {
        return typeMeal;
    }

    public void setTypeMeal(Set<TypeMeal> typeMeal) {
        this.typeMeal = typeMeal;
    }

    public Integer getPrepareTime() {
        return prepareTime;
    }

    public void setPrepareTime(Integer prepareTime) {
        this.prepareTime = prepareTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
