package com.javaakademi.ecommerce_homework.domain.user.api;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDto {
    private int id;
    private String username;
    private String usersurname;
    private String useremail;
    private String userpassword;
    private String useradress;
}
