package com.WildBirds.RepositoryJPA.domain.model;

import com.WildBirds.RepositoryJPA.domain.model.baseEntity.BaseEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Step extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idStep;
    private Integer number;
    private String header;

    @ManyToOne
    @JoinColumn(name = "idReceipt")
    private Receipt receipt;

    public Step() {
    }

    public Integer getIdStep() {
        return idStep;
    }

    public void setIdStep(Integer idStep) {
        this.idStep = idStep;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
        receipt.getStepSet().add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Step step = (Step) o;

        if (idStep != null ? !idStep.equals(step.idStep) : step.idStep != null) return false;
        if (number != null ? !number.equals(step.number) : step.number != null) return false;
        if (header != null ? !header.equals(step.header) : step.header != null) return false;
        return receipt != null ? receipt.equals(step.receipt) : step.receipt == null;
    }

}
