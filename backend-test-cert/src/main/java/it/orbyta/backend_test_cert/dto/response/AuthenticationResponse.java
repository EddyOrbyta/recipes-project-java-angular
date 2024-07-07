package it.orbyta.backend_test_cert.dto.response;

import it.orbyta.backend_test_cert.entity.enumerator.UserRole;
import lombok.Data;

@Data
public class AuthenticationResponse {
    private String token;
    private UserRole role;
    private String username;
}
