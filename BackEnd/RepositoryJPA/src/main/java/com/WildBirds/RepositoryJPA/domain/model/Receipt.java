package com.WildBirds.RepositoryJPA.domain.model;

import com.WildBirds.RepositoryJPA.domain.model.baseEntity.BaseEntity;

import javax.persistence.*;
import java.util.*;

@Entity
public class Receipt extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReceipt;
    private String title;
    private String description;
    private Integer prepareTime;

    @OneToMany(mappedBy = "receipt", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Step> stepSet = new ArrayList<>();

    @OneToOne(mappedBy = "receipt")
    private Meal meal;

    public Receipt() {
    }

    public void addStep(Step step){
        this.getStepList().add(step);
        step.setReceipt(this);
    }

    public Integer getIdReceipt() {
        return idReceipt;
    }

    public void setIdReceipt(Integer idReceipt) {
        this.idReceipt = idReceipt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Step> getStepList() {
        return stepSet;
    }

    public void setStepSet(List<Step> stepSet) {
        this.stepSet = stepSet;
    }

    public Integer getPrepareTime() {
        return prepareTime;
    }

    public void setPrepareTime(Integer prepareTime) {
        this.prepareTime = prepareTime;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {

        this.meal = meal;
    }

}
