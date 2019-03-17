package com.WildBirds.EatMeAll.application.DTO.full_;

import com.WildBirds.EatMeAll.application.DTO.unit_.ProductUnitDTO;

import java.util.ArrayList;
import java.util.List;

public class ShoppingListDTO {
    private List<ProductUnitDTO> meat;
    private List<ProductUnitDTO> vegetable;
    private List<ProductUnitDTO> fruit;
    private List<ProductUnitDTO> baking;
    private List<ProductUnitDTO> grains;
    private List<ProductUnitDTO> dairy;
    private List<ProductUnitDTO> drink;
    private List<ProductUnitDTO> spice;
    private List<ProductUnitDTO> fish;
    private List<ProductUnitDTO> other;
    private List<ProductUnitDTO> unknown;


    public ShoppingListDTO() {
        meat = new ArrayList<>();
        vegetable = new ArrayList<>();
        fruit = new ArrayList<>();
        baking = new ArrayList<>();
        grains = new ArrayList<>();
        dairy = new ArrayList<>();
        drink = new ArrayList<>();
        spice = new ArrayList<>();
        fish = new ArrayList<>();
        other = new ArrayList<>();
        unknown = new ArrayList<>();
    }

    public List<ProductUnitDTO> getMeat() {
        return meat;
    }

    public List<ProductUnitDTO> getVegetable() {
        return vegetable;
    }

    public List<ProductUnitDTO> getFruit() {
        return fruit;
    }

    public List<ProductUnitDTO> getBaking() {
        return baking;
    }

    public List<ProductUnitDTO> getGrains() {
        return grains;
    }

    public List<ProductUnitDTO> getDairy() {
        return dairy;
    }

    public List<ProductUnitDTO> getDrink() {
        return drink;
    }

    public List<ProductUnitDTO> getSpice() {
        return spice;
    }

    public List<ProductUnitDTO> getFish() {
        return fish;
    }

    public List<ProductUnitDTO> getOther() {
        return other;
    }

    public List<ProductUnitDTO> getUnknown() {
        return unknown;
    }
}




