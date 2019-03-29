package com.educ_nc_spring_19.auth_service.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data

@Entity
public class User {
    @Id
    @GeneratedValue
    private UUID id;

    private String firstName;
    private String lastName;
    @Column(name = "active", nullable = false)
    private Boolean isActive;
    @Column(nullable = false)
    private String login;
    private String emailAddress;
    @Column(nullable = false, columnDefinition = "text")
    private String credential;

    @Column(columnDefinition = "timestamp with time zone")
    private OffsetDateTime createdDate;

    @ManyToOne
    @JoinColumn(name = "created_by_user_id", referencedColumnName = "id")
    private User createdByUser;

    @Column(columnDefinition = "timestamp with time zone")
    private OffsetDateTime updatedDate;

    @ManyToOne
    @JoinColumn(name = "updated_by_user_id", referencedColumnName = "id")
    private User updatedByUser;

    @OneToMany(mappedBy = "createdByUser")
    private List<SystemRole> createdSystemRoles;

    @OneToMany(mappedBy = "updatedByUser")
    private List<SystemRole> updatedSystemRoles;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "user_role_junction",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "system_role_id") }
    )
    private Set<SystemRole> systemRoles = new HashSet<>();
}
