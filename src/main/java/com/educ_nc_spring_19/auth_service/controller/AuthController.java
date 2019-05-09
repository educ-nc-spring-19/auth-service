package com.educ_nc_spring_19.auth_service.controller;

import com.educ_nc_spring_19.auth_service.exception.AppException;
import com.educ_nc_spring_19.auth_service.model.entity.RoleName;
import com.educ_nc_spring_19.auth_service.model.entity.SystemRole;
import com.educ_nc_spring_19.auth_service.model.entity.User;
import com.educ_nc_spring_19.auth_service.security.JwtTokenProvider;
import com.educ_nc_spring_19.auth_service.payload.request.LoginRequest;
import com.educ_nc_spring_19.auth_service.payload.request.SignUpRequest;
import com.educ_nc_spring_19.auth_service.payload.response.ApiResponse;
import com.educ_nc_spring_19.auth_service.payload.response.JwtAuthenticationResponse;
import com.educ_nc_spring_19.auth_service.service.repo.SystemRoleRepository;
import com.educ_nc_spring_19.auth_service.service.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    SystemRoleRepository systemRoleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getLoginOrEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if(userRepository.existsByLogin(signUpRequest.getLogin())) {
            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByEmailAddress(signUpRequest.getEmail())) {
            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        User user = new User(signUpRequest.getFirstName(), signUpRequest.getLastName(), signUpRequest.getLogin(),
                signUpRequest.getEmail(), signUpRequest.getPassword(), signUpRequest.getSystemRoles(), signUpRequest.getCreatedSystemRoles(),
                signUpRequest.getUpdatedSystemRoles(), signUpRequest.getUser(), signUpRequest.getCreatedByUserId());

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        SystemRole userRole = systemRoleRepository.findByName(RoleName.ROLE_USER.toString());
        if (userRole == null) {
            throw new AppException("User Role not set.");
        }

        user.addRole(userRole);

        User result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/users/{username}")
                .buildAndExpand(result.getUsername()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }
}
