package com.educ_nc_spring_19.auth_service.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data

@Entity
public class SystemRole {
    @Id
    @GeneratedValue
    private UUID id;

    private String roleName;
    private String roleDescription;

    @Column(columnDefinition = "timestamp with time zone")
    private OffsetDateTime createdDate;

    @ManyToOne
    @JoinColumn(name = "created_by_user_id")
    private User createdByUser;

    @Column(columnDefinition = "timestamp with time zone")
    private OffsetDateTime updatedDate;

    @ManyToOne
    @JoinColumn(name = "updated_by_user_id")
    private User updatedByUser;

    @ManyToMany(mappedBy = "systemRoles")
    private Set<User> users = new HashSet<>();
}
