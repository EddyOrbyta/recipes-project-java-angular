package it.orbyta.backend_test_cert.entity.enumerator;


import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
    FAN,
    ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
