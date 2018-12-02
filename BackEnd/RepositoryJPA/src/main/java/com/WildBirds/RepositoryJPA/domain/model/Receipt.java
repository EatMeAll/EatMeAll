package com.WildBirds.RepositoryJPA.domain.model;

import com.WildBirds.RepositoryJPA.domain.model.baseEntity.BaseEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Receipt extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReceipt;
    private String title;
    private String description;
    private Integer prepareTime;

    @OneToMany(mappedBy = "receipt", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Step> stepSet = new HashSet<>();

    @OneToOne(mappedBy = "receipt")
    private Meal meal;

    public Receipt() {
    }

    public void addStep(Step step){
        this.getStepSet().add(step);
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

    public Set<Step> getStepSet() {
        return stepSet;
    }

    public void setStepSet(Set<Step> stepSet) {
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
