package com.wildBirds.SystemTestsBackEnd.domain.model.unit_;

//import com.WildBirds.RepositoryJPA.domain.model.enums.UserType;

public class UserUpdateDTO {

    private Integer idUser;
    private String email;
    private String password;


    public UserUpdateDTO() {
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
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


    @Override
    public String toString() {
        return "UserUpdateDTO{" +
                "idUser=" + idUser +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
