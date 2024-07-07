package it.orbyta.backend_test_cert.service;

import it.orbyta.backend_test_cert.dto.request.UserLoginRequest;
import it.orbyta.backend_test_cert.dto.request.UserSignupRequest;
import it.orbyta.backend_test_cert.dto.response.AuthenticationResponse;
import it.orbyta.backend_test_cert.entity.User;
import it.orbyta.backend_test_cert.entity.enumerator.UserRole;
import it.orbyta.backend_test_cert.exceptions.PasswordDoesntMatchException;
import it.orbyta.backend_test_cert.exceptions.UserAlreadyExistException;
import it.orbyta.backend_test_cert.repository.UserRepository;
import it.orbyta.backend_test_cert.security.serivce.AuthService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final AuthService authService;
    @Transactional(rollbackFor = Throwable.class)
    public AuthenticationResponse signUp(UserSignupRequest userSignupRequest) throws UserAlreadyExistException {
        log.info("Start method signUp - request: {}", userSignupRequest);
        User userExist = userRepository.findByUsername(userSignupRequest.getUsername()).orElse(null);

        if (userExist != null) {
            log.error("User already exist - request: {}", userSignupRequest);
            throw new UserAlreadyExistException("User already exist");
        }

        User newUser = createUser(userSignupRequest);

        AuthenticationResponse authenticationResponse = createResponse(newUser);

        log.info("End method signUp - response: {}", authenticationResponse);
        return authenticationResponse;
    }
    private User createUser(UserSignupRequest userSignupRequest) {
        log.info("Start method createUser - request: {}", userSignupRequest);
        User user = new User();

        user.setUsername(userSignupRequest.getUsername());
        user.setPassword(
                authService.cryptPassword(userSignupRequest.getPassword())
        );
        user.setRole(identifyRole(userSignupRequest.getUsername()));
        log.info("End method createUser - user: {}", user);
        return userRepository.save(user);
    }

    private UserRole identifyRole(String username) {
        log.info("Start method identifyRole - request: {}", username);
        if(username.contains("admin")) {
            return UserRole.ADMIN;
        }
        return UserRole.FAN;
    }

    @Transactional(rollbackFor = Throwable.class)
    public AuthenticationResponse logIn(UserLoginRequest userLogin) throws UserAlreadyExistException, PasswordDoesntMatchException {
        log.info("Start method logIn - request: {}", userLogin);

        User user = userRepository.findByUsername(userLogin.getUsername()).orElseThrow( () -> new UserAlreadyExistException("User doesn't exist"));

        if (authService.checkPassword(userLogin.getPassword(), user.getPassword())) {
            log.info("Password match for user: {}", userLogin.getUsername());

            AuthenticationResponse authenticationResponse = createResponse(user);

            log.info("End method logIn - response: {}", authenticationResponse);
            return authenticationResponse;

        } else {
            throw new PasswordDoesntMatchException("Password doesn't match with old password");
        }
    }
    private AuthenticationResponse createResponse(User newUser) {
        log.info("Start method createResponse - request: {}", newUser);

        AuthenticationResponse authenticationResponse = new AuthenticationResponse();

        authenticationResponse.setUsername(newUser.getUsername());
        authenticationResponse.setRole(newUser.getRole());

        authenticationResponse.setToken(
                authService.createToken(newUser.getUsername(), newUser.getRole())
        );

        log.info("End method createResponse - response: {}", authenticationResponse);
        return authenticationResponse;
    }
}
