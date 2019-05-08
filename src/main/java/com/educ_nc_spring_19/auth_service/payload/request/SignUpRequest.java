package com.educ_nc_spring_19.auth_service.payload.request;

import com.educ_nc_spring_19.auth_service.model.entity.SystemRole;
import com.educ_nc_spring_19.auth_service.model.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.validation.constraints.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class SignUpRequest {
    @Getter @Setter
    @Size(max = 40)
    private String firstName;

    @Getter @Setter
    @Size(max = 40)
    private String lastName;

    @Getter @Setter
    @NotBlank
    @Size(min = 3, max = 15)
    private String login;

    @Getter @Setter
    @NotBlank
    @Size(max = 40)
    @Email
    private String email;

    @Getter @Setter
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    @Getter @Setter
    @Size(max = 255)
    private Collection<? extends GrantedAuthority> authorities; //?

    @Getter @Setter
    @Size(max = 255)
    private Set<SystemRole> systemRoles; //? сделать их все по названиям что ли

    @Getter @Setter
    @Size(max = 255)
    private List<SystemRole> createdSystemRoles; //? сделать их все по названиям что ли

    @Getter @Setter
    @Size(max = 255)
    private List<SystemRole> updatedSystemRoles; //? сделать их все по названиям что ли

    @Getter @Setter
    @Size(max = 20)
    private User user; //мб по UUID его вытаскивать? который ниже, к примеру

    @Getter @Setter
    @Size(max = 63)
    private UUID createdByUserId;

}