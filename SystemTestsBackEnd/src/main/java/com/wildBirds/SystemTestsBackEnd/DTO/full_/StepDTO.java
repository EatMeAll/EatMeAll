package com.wildBirds.SystemTestsBackEnd.DTO.full_;

public class StepDTO {

    private Integer idStep;
    private Integer number;
    private String header;

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


    @Override
    public String toString() {
        return "StepDTO{" +
                "idStep=" + idStep +
                ", number=" + number +
                ", header='" + header + '\'' +
                '}';
    }
}
