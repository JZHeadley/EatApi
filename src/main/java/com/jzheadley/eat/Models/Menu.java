package com.jzheadley.eat.Models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "Menu")
public class Menu implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "menuname")
    private String menuName;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "menucategory",
            joinColumns = @JoinColumn(name = "idmenu", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "idcategory", referencedColumnName = "id"))
    private Collection<Category> categories;

    public Menu() {
    }

    public Menu(String menuName) {
        this.menuName = menuName;
    }

    public Menu(String menuName, Collection<Category> categories) {
        this.menuName = menuName;
        this.categories = categories;
    }

    public int getId() {
        return id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Collection<Category> getCategories() {
        return categories;
    }

    public void setCategories(Collection<Category> categories) {
        this.categories = categories;
    }
}
