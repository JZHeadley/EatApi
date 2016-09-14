package com.jzheadley.eat.Models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name = "Category")
public class Category implements Serializable {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "categoryname")
    private String categoryName;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "menuitemcategory",
            joinColumns = @JoinColumn(name = "idcategory", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "idmenuitem", referencedColumnName = "id"))
    private Collection<MenuItem> menuItems;

    public Category() {
    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public Category(String categoryName, Collection<MenuItem> menuItems) {
        this.categoryName = categoryName;
//        this.menuItems = menuItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Collection<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(Collection<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                Arrays.toString(menuItems.toArray()) +
                '}';
    }


}
