package com.wildBirds.SystemTestsBackEnd.domain.model.full_;

public class ProductDTO {

    private Integer idProduct;
    private String name;
    private String unit;

    public ProductDTO() {
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductDTO that = (ProductDTO) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return unit != null ? unit.equals(that.unit) : that.unit == null;
    }


    @Override
    public String toString() {
        return "ProductDTO{" +
                "idProduct=" + idProduct +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }
}
