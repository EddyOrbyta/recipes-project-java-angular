package it.orbyta.backend_test_cert.controller;

import it.orbyta.backend_test_cert.controller.constants.AuthApiConstants;
import it.orbyta.backend_test_cert.dto.request.UserLoginRequest;
import it.orbyta.backend_test_cert.dto.request.UserSignupRequest;
import it.orbyta.backend_test_cert.dto.response.AuthenticationResponse;
import it.orbyta.backend_test_cert.exceptions.PasswordDoesntMatchException;
import it.orbyta.backend_test_cert.exceptions.UserAlreadyExistException;
import it.orbyta.backend_test_cert.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@AllArgsConstructor
@RequestMapping(AuthApiConstants.BASE_PATH)
public class AuthenticationController {


        private final UserService userService;

        @PostMapping(AuthApiConstants.SIGNUP)
        public ResponseEntity<AuthenticationResponse> signup(@RequestBody UserSignupRequest userSignupRequest) throws UserAlreadyExistException {

            AuthenticationResponse authenticationResponse = userService.signUp(userSignupRequest);

            return ResponseEntity.ok(authenticationResponse);
        }
        @PostMapping(AuthApiConstants.LOGIN)
        public ResponseEntity<AuthenticationResponse> login(@RequestBody UserLoginRequest userLogin) throws UserAlreadyExistException, PasswordDoesntMatchException {

            AuthenticationResponse authenticationResponse = userService.logIn(userLogin);

            return ResponseEntity.ok(authenticationResponse);
        }
    }