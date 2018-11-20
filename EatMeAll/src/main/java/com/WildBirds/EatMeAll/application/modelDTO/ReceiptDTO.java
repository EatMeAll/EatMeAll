package com.WildBirds.EatMeAll.application.modelDTO;

import java.util.List;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReceiptDTO that = (ReceiptDTO) o;

        if (idReceipt != null ? !idReceipt.equals(that.idReceipt) : that.idReceipt != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (prepareTime != null ? !prepareTime.equals(that.prepareTime) : that.prepareTime != null) return false;
        return steps != null ? steps.equals(that.steps) : that.steps == null;
    }

    @Override
    public int hashCode() {
        int result = idReceipt != null ? idReceipt.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (prepareTime != null ? prepareTime.hashCode() : 0);
        result = 31 * result + (steps != null ? steps.hashCode() : 0);
        return result;
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
