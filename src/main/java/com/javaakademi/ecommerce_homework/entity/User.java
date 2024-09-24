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
    @OneToOne
    private Basket userBasket;

    public User(int id, String username, String usersurname, String useremail, String userpassword, String useradress, double usermoney, Basket userBasket) {
        this.id = id;
        this.username = username;
        this.usersurname = usersurname;
        this.useremail = useremail;
        this.userpassword = userpassword;
        this.useradress = useradress;
        this.usermoney = usermoney;
        this.userBasket = userBasket;
    }

    public User(){}

    public String getUseradress() {
        return useradress;
    }

    public void setUseradress(String useradress) {
        this.useradress = useradress;
    }

    public double getUsermoney() {
        return usermoney;
    }

    public void setUsermoney(double usermoney) {
        this.usermoney = usermoney;
    }

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
