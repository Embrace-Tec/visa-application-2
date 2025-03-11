package com.visa.userservice.dto;

import lombok.Data;

@Data
public class UserResponseDTO {
    private Long user_id;
    private String first_name;
    private String last_name;
    private String email;
    private String role;
}
