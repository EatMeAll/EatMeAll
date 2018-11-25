package com.WildBirds.RepositoryJPA.domain.model;

import com.WildBirds.RepositoryJPA.domain.model.baseEntity.BaseEntity;
import com.WildBirds.RepositoryJPA.domain.model.enums.UserType;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;
    @Column(nullable = false, unique = true)
    private String nick;

    @Column(nullable = false, unique = true)
    @Pattern(regexp="^[A-z0-9._%+-]+@[A-z0-9.-]+\\.[A-z]{2,6}$")
    private String email;

    private String password;
    @Enumerated(EnumType.STRING)
    private UserType userType;

    //    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @ManyToMany(mappedBy = "likedBySet",cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Meal> favouritesMealsSet = new HashSet<>();

    @OneToMany(mappedBy = "creatorMeal")
    private Set<Meal> mealsCreatedSet = new HashSet<>();

    @OneToMany(mappedBy = "dayOwner")
    private Set<Day> historyMealsSet = new HashSet<>();

    @OneToMany(mappedBy = "photoOwner")
    private Set<Photo> myPhotosSet = new HashSet<>();

    public User() {
    }

    public User(String nick, String email){
        this.nick = nick;
        this.email = email;
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

    public void addPhoto(Photo photo){
        this.myPhotosSet.add(photo);
        photo.setPhotoOwner(this);
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

    public Set<Photo> getMyPhotosSet() {
        return myPhotosSet;
    }

    public void setMyPhotosSet(Set<Photo> photoOwner) {
        this.myPhotosSet = photoOwner;
    }


}
