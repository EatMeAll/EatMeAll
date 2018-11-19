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
    @Enumerated(EnumType.STRING)
    private UserType userType;

//    @ManyToMany(mappedBy = "likedBySet",cascade = {CascadeType.PERSIST, CascadeType.MERGE})

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(name = "Favourites",
            joinColumns = {@JoinColumn(name = "idUser")},
            inverseJoinColumns = {@JoinColumn(name = "idMeal")})
    private Set<Meal> favouritesMealsSet = new HashSet<>();
//
//    @OneToMany(mappedBy = "creatorMeal")
//    private Set<Meal> mealsCreatedSet = new HashSet<>();
//
//    @OneToMany(mappedBy = "dayOwner")
//    private Set<Day> historyMealsSet = new HashSet<>();

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
}
