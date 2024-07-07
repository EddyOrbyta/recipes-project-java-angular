package it.orbyta.backend_test_cert.dto.request;

import lombok.Data;

@Data
public class UserSignupRequest {
    private String username;
    private String password;
}

