package com.jzheadley.eat.Models;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

//    @OneToMany(mappedBy = "restaurantOwner", cascade = CascadeType.ALL)
//    private List<Restaurant> restaurants;

    @Column(name = "username")
    private String username;

    @Column(name = "firebaseid")
    private String firebaseId;

    public User() {
    }

    public User(String username, String firebaseId) {
        this.username = username;
        this.firebaseId = firebaseId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
//                ", restaurants=" + restaurants +
                ", username='" + username + '\'' +
                ", firebaseId='" + firebaseId + '\'' +
                '}';
    }
/*
    public User(List<Restaurant> restaurants, String username, String firebaseId) {
        this.restaurants = restaurants;
        this.username = username;
        this.firebaseId = firebaseId;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//    public List<Restaurant> getRestaurants() {
//        return restaurants;
//    }

//    public void setRestaurants(List<Restaurant> restaurants) {
//        this.restaurants = restaurants;
//    }

    public String getFirebaseId() {
        return firebaseId;
    }

    public void setFirebaseId(String firebaseId) {
        this.firebaseId = firebaseId;
    }
}
