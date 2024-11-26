package com.javaakademi.ecommerce_homework.domain.user.web;

import com.javaakademi.ecommerce_homework.response.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse extends BaseResponse {
    private String username;
    private String usersurname;
    private String useremail;
    private String useradress;
}
