package com.visa.userservice.dto;

import lombok.Data;

@Data
public class UserRequestDTO {
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private String role;
}
