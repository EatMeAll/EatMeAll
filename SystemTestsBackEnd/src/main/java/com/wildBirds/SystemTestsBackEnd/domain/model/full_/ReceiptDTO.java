package com.wildBirds.SystemTestsBackEnd.domain.model.full_;

import java.util.Set;

public class ReceiptDTO {

    private Integer idReceipt;
    private String title;
    private String description;
    private Integer prepareTime;
    private Set<StepDTO> steps;

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

    public Integer getPrepareTime() {
        return prepareTime;
    }

    public void setPrepareTime(Integer prepareTime) {
        this.prepareTime = prepareTime;
    }

    public Set<StepDTO> getSteps() {
        return steps;
    }

    public void setSteps(Set<StepDTO> steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        return "ReceiptDTO{" +
                "idReceipt=" + idReceipt +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", prepareTime=" + prepareTime +
                ", steps=" + steps +
                '}';
    }
}
