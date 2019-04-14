package com.educ_nc_spring_19.auth_service.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data

@Entity
@Table(name = "users")
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

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_user_id", referencedColumnName = "id")
    private User createdByUser;

    @Column(name = "created_by_user_id", insertable = false, updatable = false)
    private UUID createdByUserId;

    @Column(columnDefinition = "timestamp with time zone")
    private OffsetDateTime updatedDate;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updated_by_user_id", referencedColumnName = "id")
    private User updatedByUser;

    @Column(name = "updated_by_user_id", insertable = false, updatable = false)
    private UUID updatedByUserId;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "createdByUser", fetch = FetchType.LAZY)
    private List<SystemRole> createdSystemRoles;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "updatedByUser", fetch = FetchType.LAZY)
    private List<SystemRole> updatedSystemRoles;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_role_junction",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "system_role_id") }
    )
    private Set<SystemRole> systemRoles = new HashSet<>();
}
