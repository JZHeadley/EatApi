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
    @Column(name = "description")
    private String description;
    @Column(name = "zipcode")
    private String zipcode;
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "country")
    private String country;
    @Column(name = "pictureurl")
    private String pictureurl;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "restaurantmenus",
            joinColumns = @JoinColumn(name = "idrestaurant", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "idmenu", referencedColumnName = "id"))
    private Collection<Menu> menus;

    @Column(name = "ownerid")
    private int ownerId;


    public Restaurant(String name, String description, String zipcode, String address, String city, String country, String pictureurl, Collection<Menu> menus, int ownerId) {
        this.name = name;
        this.description = description;
        this.zipcode = zipcode;
        this.address = address;
        this.city = city;
        this.country = country;
        this.pictureurl = pictureurl;
        this.menus = menus;
        this.ownerId = ownerId;
    }

    public Restaurant(String name, String description, String zipcode, String address, String city, String country, String pictureurl, int ownerId) {
        this.name = name;
        this.description = description;
        this.zipcode = zipcode;
        this.address = address;
        this.city = city;
        this.country = country;
        this.pictureurl = pictureurl;
        this.ownerId = ownerId;
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

    public Collection<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Collection<Menu> menus) {
        this.menus = menus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPictureurl() {
        return pictureurl;
    }

    public void setPictureurl(String pictureurl) {
        this.pictureurl = pictureurl;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
}
