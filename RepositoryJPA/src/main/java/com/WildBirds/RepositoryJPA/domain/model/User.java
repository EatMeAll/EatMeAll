package com.WildBirds.RepositoryJPA.domain.model;

import com.WildBirds.RepositoryJPA.domain.model.enums.UserType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;
    private String nick;
    private String email;
    private String password;
    private UserType userType;

    @ManyToMany(mappedBy = "likedBySet",cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Meal> favouritesMealsSet = new HashSet<>();

    @OneToMany(mappedBy = "creatorMeal")
    private Set<Meal> mealsCreatedSet = new HashSet<>();

    @OneToMany(mappedBy = "dayOwner")
    private Set<Day> historyMealsSet = new HashSet<>();

    public User() {
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

    public Set<Meal> getFavouritesMealsSet() {
        return favouritesMealsSet;
    }

    public void setFavouritesMealsSet(Set<Meal> favouritesMealsSet) {
        this.favouritesMealsSet = favouritesMealsSet;
    }

    public Set<Meal> getMealsCreatedSet() {
        return mealsCreatedSet;
    }

    public void setMealsCreatedSet(Set<Meal> mealsCreatedSet) {
        this.mealsCreatedSet = mealsCreatedSet;
    }

    public Set<Day> getHistoryMealsSet() {
        return historyMealsSet;
    }

    public void setHistoryMealsSet(Set<Day> historyMealsSet) {
        this.historyMealsSet = historyMealsSet;
    }
}
