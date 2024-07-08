package it.orbyta.backend_test_cert.security;

import it.orbyta.backend_test_cert.controller.constants.AuthApiConstants;
import it.orbyta.backend_test_cert.controller.constants.RicettaApiConsts;
import it.orbyta.backend_test_cert.entity.enumerator.UserRole;
import it.orbyta.backend_test_cert.security.serivce.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import static org.springframework.http.HttpMethod.POST;

@EnableWebSecurity
@Configuration
@AllArgsConstructor
public class WebSecurityConfiguration {

    private final AuthService authService;
    private final String[] AUTH_WHITE_LIST_AUTH = {
            AuthApiConstants.BASE_PATH + "/**",
            RicettaApiConsts.BASE_URL + RicettaApiConsts.GET_ALL_RICETTE,
            RicettaApiConsts.BASE_URL + RicettaApiConsts.GET_RICETTE_EASY,
            RicettaApiConsts.BASE_URL + RicettaApiConsts.GET_RICETTE_5_STAR,
    };

    private final String[] AUTH_WHITE_LIST_ADMIN = {
            RicettaApiConsts.BASE_URL + RicettaApiConsts.ADD_RICETTA,
            RicettaApiConsts.BASE_URL + RicettaApiConsts.REMOVE_RICETTA,
            RicettaApiConsts.BASE_URL + RicettaApiConsts.UPDATE_RICETTA,

    };


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests (authorizeRequests ->
                        authorizeRequests
                                .requestMatchers(AUTH_WHITE_LIST_AUTH).permitAll()

                                .requestMatchers(AUTH_WHITE_LIST_ADMIN).hasAuthority(UserRole.ADMIN.name())
                                .anyRequest().authenticated()
                )
                .addFilterBefore(new JwtTokenAuthenticationFilter(authService), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

}
