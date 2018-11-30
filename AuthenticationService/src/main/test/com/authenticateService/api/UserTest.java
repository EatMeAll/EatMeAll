package com.authenticateService.api;

public class UserTest {

    private Integer idUser;
    private String nick;
    private String email;


    public UserTest(Integer idUser, String nick, String email) {
        this.idUser = idUser;
        this.nick = nick;
        this.email = email;
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
