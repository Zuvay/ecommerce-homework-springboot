package com.javaakademi.ecommerce_homework.request;

public class UserRequest {
    private String username;
    private String usersurname;
    private String useremail;
    private String userpassword;
    private String useradress;
    private double usermoney;
    private String shopName;

    public UserRequest() {
    }

    public UserRequest(String username, String usersurname, String useremail, String userpassword, String useradress, double usermoney, String shopName) {
        this.username = username;
        this.usersurname = usersurname;
        this.useremail = useremail;
        this.userpassword = userpassword;
        this.useradress = useradress;
        this.usermoney = usermoney;
        this.shopName = shopName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
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
}
