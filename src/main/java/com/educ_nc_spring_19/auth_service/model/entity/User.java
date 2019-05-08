package com.educ_nc_spring_19.auth_service.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.*;

@Data

@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue
    private UUID id;

    private String firstName; //? зачем
    private String lastName; //? зачем

    @Column(name = "active", nullable = false)
    private boolean isActive;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String emailAddress; //? почему не column?

    @JsonIgnore
    @Column(nullable = false)
    private String password;

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
    private List<SystemRole> createdSystemRoles; //? зачем

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "updatedByUser", fetch = FetchType.LAZY)
    private List<SystemRole> updatedSystemRoles; //? зачем

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_role_junction",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "system_role_id") }
    )
    private Set<SystemRole> systemRoles = new HashSet<>();

    public void addRole(SystemRole role) {
        if (systemRoles == null) systemRoles = new HashSet<>();
        systemRoles.add(role);
    }

    private Collection<? extends GrantedAuthority> authorities;


    public User(String firstName, String lastName, String login, String email, String password,
                Collection<? extends GrantedAuthority> authorities, Set<SystemRole> systemRoles,
                List<SystemRole> createdSystemRoles, List<SystemRole> updatedSystemRoles, User user, UUID createdByUserId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.emailAddress = email;
        this.password = password;
        this.authorities = authorities;
        this.systemRoles = systemRoles;
        this.createdDate = OffsetDateTime.now();
        this.createdSystemRoles = createdSystemRoles;
        this.updatedSystemRoles = updatedSystemRoles;
        this.createdByUser = user;
        this.createdByUserId = createdByUserId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    //TODO: constructors
}
