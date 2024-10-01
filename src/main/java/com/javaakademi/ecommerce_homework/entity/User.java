package com.javaakademi.ecommerce_homework.entity;

import jakarta.persistence.*;

import java.util.Optional;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String usersurname;
    private String useremail;
    private String userpassword;
    private String useradress;
    private double usermoney;
    @OneToMany
    private List<Basket> userBaskets;
    @OneToOne
    private Shop userShop;
    // ilgili getter setterlar eklenecek

   
}
