package com.WildBirds.RepositoryJPA.domain.model;

import com.WildBirds.RepositoryJPA.domain.model.baseEntity.BaseEntity;
import com.WildBirds.RepositoryJPA.domain.model.enums.UserType;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idUser;
    private String nick;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserType userType;

    //    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @ManyToMany(mappedBy = "likedBySet",cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private Set<Meal> favouritesMealsSet = new HashSet<>();

    @OneToMany(mappedBy = "creatorMeal")
    private Set<Meal> mealsCreatedSet = new HashSet<>();

    @OneToMany(mappedBy = "dayOwner")
    private Set<Day> historyMealsSet = new HashSet<>();

    public User() {
    }


    public void addCreateMeal(Meal meal) {
        this.mealsCreatedSet.add(meal);
        meal.setCreatorMeal(this);
    }

    public void addDayToHistory(Day day){
        this.getHistoryMealsSet().add(day);
        day.setDayOwner(this);
    }

    public void addFavoriteMeal(Meal meal){
        this.getFavouritesMealsSet().add(meal);
        meal.getLikedBySet().add(this);
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (idUser != null ? !idUser.equals(user.idUser) : user.idUser != null) return false;
        if (nick != null ? !nick.equals(user.nick) : user.nick != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (userType != user.userType) return false;
        if (favouritesMealsSet != null ? !favouritesMealsSet.equals(user.favouritesMealsSet) : user.favouritesMealsSet != null)
            return false;
        if (mealsCreatedSet != null ? !mealsCreatedSet.equals(user.mealsCreatedSet) : user.mealsCreatedSet != null)
            return false;
        return historyMealsSet != null ? historyMealsSet.equals(user.historyMealsSet) : user.historyMealsSet == null;
    }

}
