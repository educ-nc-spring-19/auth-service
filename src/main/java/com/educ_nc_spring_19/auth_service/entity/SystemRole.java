package com.educ_nc_spring_19.auth_service.entity;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

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

    // private UUID createdByUserId; // to replace with User class

    @Column(columnDefinition = "timestamp with time zone")
    private OffsetDateTime updatedDate;

    @ManyToOne
    @JoinColumn(name = "updated_by_user_id")
    private User updatedByUser;
    // private UUID updatedByUserId; // to replace with User class

    @ManyToMany(mappedBy = "systemRoles")
    private Set<User> users = new HashSet<>();

    protected SystemRole() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public OffsetDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(OffsetDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public User getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(User createdByUser) {
        this.createdByUser = createdByUser;
    }

    public OffsetDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(OffsetDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public User getUpdatedByUser() {
        return updatedByUser;
    }

    public void setUpdatedByUser(User updatedByUser) {
        this.updatedByUser = updatedByUser;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
