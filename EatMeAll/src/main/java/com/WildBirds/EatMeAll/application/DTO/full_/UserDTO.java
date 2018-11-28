package com.WildBirds.EatMeAll.application.DTO.full_;


import com.WildBirds.RepositoryJPA.domain.model.enums.UserType;

import java.util.Set;

public class UserDTO {

    private Integer idUser;
    private String nick;
    private String email;
    private UserType userType;
    private Set<Integer> favouritesMealsSetId;

    public UserDTO() {
    }

    public UserType getUserType() {
        return userType;
    }

    public Set<Integer> getFavouritesMealsSetId() {
        return favouritesMealsSetId;
    }

    public void setFavouritesMealsSetId(Set<Integer> favouritesMealsSetId) {
        this.favouritesMealsSetId = favouritesMealsSetId;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}
