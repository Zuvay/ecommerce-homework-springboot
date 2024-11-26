package com.javaakademi.ecommerce_homework.domain.user.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequest {
    private String username;
    private String usersurname;
    private String useremail;
    private String userpassword;
    private String useradress;
}
