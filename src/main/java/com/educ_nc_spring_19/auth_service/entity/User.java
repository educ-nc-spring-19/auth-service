package com.educ_nc_spring_19.auth_service.entity;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

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
    //private UUID createdByUserId; // to replace with User class

    @Column(columnDefinition = "timestamp with time zone")
    private OffsetDateTime updatedDate;

    @ManyToOne
    @JoinColumn(name = "updated_by_user_id", referencedColumnName = "id")
    private User updatedByUser;
    // private UUID updatedByUserId; // to replace with User class

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

    protected User() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential;
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

    public List<SystemRole> getCreatedSystemRoles() {
        return createdSystemRoles;
    }

    public void setCreatedSystemRoles(List<SystemRole> createdSystemRoles) {
        this.createdSystemRoles = createdSystemRoles;
    }

    public List<SystemRole> getUpdatedSystemRoles() {
        return updatedSystemRoles;
    }

    public void setUpdatedSystemRoles(List<SystemRole> updatedSystemRoles) {
        this.updatedSystemRoles = updatedSystemRoles;
    }

    public Set<SystemRole> getSystemRoles() {
        return systemRoles;
    }

    public void setSystemRoles(Set<SystemRole> systemRoles) {
        this.systemRoles = systemRoles;
    }
}
