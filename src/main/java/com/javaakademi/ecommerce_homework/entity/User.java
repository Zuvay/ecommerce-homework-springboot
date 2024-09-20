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
    @OneToOne
    private Basket userBasket;

    public User(int id, String username, String usersurname, String useremail, String userpassword, Basket userBasket) {
        this.id = id;
        this.username = username;
        this.usersurname = usersurname;
        this.useremail = useremail;
        this.userpassword = userpassword;
        this.userBasket = userBasket;
    }
    public User(){}

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

    public String getUsersurname() {
        return usersurname;
    }

    public void setUsersurname(String usersurname) {
        this.usersurname = usersurname;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public Basket getUserBasket() {
        return userBasket;
    }

    public void setUserBasket(Basket userBasket) {
        this.userBasket = userBasket;
    }
}
