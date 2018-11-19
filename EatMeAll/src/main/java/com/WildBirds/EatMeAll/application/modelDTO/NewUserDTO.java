package com.WildBirds.EatMeAll.application.modelDTO;

//import com.WildBirds.RepositoryJPA.domain.model.enums.UserType;

import com.WildBirds.RepositoryJPA.domain.model.enums.UserType;

public class NewUserDTO {

    private Integer idUser;
    private String nick;
    private String email;
    private String password;
    private UserType userType;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
