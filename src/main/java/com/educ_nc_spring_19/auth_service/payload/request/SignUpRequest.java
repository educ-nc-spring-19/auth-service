package com.educ_nc_spring_19.auth_service.payload.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
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
    @Size(max = 60)
    @Email
    private String email;

    @Getter @Setter
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    @Getter @Setter
    private Set<String> systemRolesNames;

    @Getter @Setter
    private List<String> createdSystemRoles; //? что с этим делать???

    @Getter @Setter
    private List<String> updatedSystemRoles; //? что с этим делать???

    @Getter @Setter
    private UUID createdByUserId;

}