package com.javaakademi.ecommerce_homework.response;

public class UserResponse {
    private String username;
    private String usersurname;
    private String useremail;

    public UserResponse(String username, String usersurname, String useremail) {
        this.username = username;
        this.usersurname = usersurname;
        this.useremail = useremail;
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
