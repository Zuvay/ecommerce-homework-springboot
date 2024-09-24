package com.javaakademi.ecommerce_homework.response;

public class UserResponse {
    private String username;
    private String usersurname;
    private String useremail;
    private String useradress;
    private double usermoney;

    public UserResponse(String username, String usersurname, String useremail, String useradress, double usermoney) {
        this.username = username;
        this.usersurname = usersurname;
        this.useremail = useremail;
        this.useradress = useradress;
        this.usermoney = usermoney;
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

    public UserResponse(){}

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
}
