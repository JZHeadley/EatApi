package com.jzheadley.eat.Models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;


@Entity
@Table(name = "Restaurant")
public class Restaurant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "restaurantmenus",
            joinColumns = @JoinColumn(name = "idrestaurant", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "idmenu", referencedColumnName = "id"))
    private Collection<Menu> menus;

    public Restaurant(String name, String location, Collection<Menu> menus) {
        this.name = name;
        this.location = location;
        this.menus = menus;
    }

    public Restaurant(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public Restaurant() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Collection<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Collection<Menu> menus) {
        this.menus = menus;
    }
}
