package com.WildBirds.EatMeAll.application.modelDTO;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StepDTO stepDTO = (StepDTO) o;

        if (idStep != null ? !idStep.equals(stepDTO.idStep) : stepDTO.idStep != null) return false;
        if (number != null ? !number.equals(stepDTO.number) : stepDTO.number != null) return false;
        return header != null ? header.equals(stepDTO.header) : stepDTO.header == null;
    }

    @Override
    public int hashCode() {
        int result = idStep != null ? idStep.hashCode() : 0;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (header != null ? header.hashCode() : 0);
        return result;
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
