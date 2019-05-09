package com.educ_nc_spring_19.auth_service.payload.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

public class UserUpdateRequest {

    @Getter@Setter
    @NotBlank
    private UUID id;

    @Getter@Setter
    @Size(max = 40)
    private String firstName;

    @Getter @Setter
    @Size(max = 40)
    private String lastName;

    @Getter @Setter
    @Size(min = 3, max = 15)
    private String login;

    @Getter @Setter
    @Size(max = 40)
    @Email
    private String email;

    @Getter @Setter
    @Size(min = 6, max = 40)
    private String password;

    @Getter @Setter
    private java.util.Set<String> systemRolesNames;

    /*//TODO: и с этим че делать?
    @Getter @Setter
    private List<String> createdSystemRoles; //? что с этим делать???

    @Getter @Setter
    private List<String> updatedSystemRoles; //? что с этим делать???
    */

    @Getter @Setter
    private UUID updatedByUserId;
}
