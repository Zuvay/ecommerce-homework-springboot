package com.javaakademi.ecommerce_homework.entity;

import jakarta.persistence.*;

import java.util.List;
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
    @OneToOne(cascade = CascadeType.PERSIST) //Bu sayede, Shop nesnesini save etmenize gerek kalmaz, çünkü User kaydedildiğinde Shop da otomatik kaydedilir.
    private Shop userShop;
    public User(){}

    public User(int id, String username, String usersurname, String useremail, String userpassword, String useradress, double usermoney, List<Basket> userBaskets, Shop userShop) {
        this.id = id;
        this.username = username;
        this.usersurname = usersurname;
        this.useremail = useremail;
        this.userpassword = userpassword;
        this.useradress = useradress;
        this.usermoney = usermoney;
        this.userBaskets = userBaskets;
        this.userShop = userShop;
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

    public List<Basket> getUserBaskets() {
        return userBaskets;
    }

    public void setUserBaskets(List<Basket> userBaskets) {
        this.userBaskets = userBaskets;
    }

    public Shop getUserShop() {
        return userShop;
    }

    public void setUserShop(Shop userShop) {
        this.userShop = userShop;
    }
}
