package com.educ_nc_spring_19.auth_service.payload.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

public class RoleUpdateRequest {
    @Getter
    @Setter
    @Size(max = 40)
    @NotBlank
    private UUID id;

    @Getter
    @Setter
    @Size(max = 40)
    private String name;

    @Getter @Setter
    @Size(max = 255)
    private String description;

    @Getter @Setter
    private UUID updatedByUserId;
}
