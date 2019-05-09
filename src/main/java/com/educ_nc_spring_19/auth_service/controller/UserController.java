package com.educ_nc_spring_19.auth_service.controller;

import com.educ_nc_spring_19.auth_service.model.entity.SystemRole;
import com.educ_nc_spring_19.auth_service.model.entity.User;
import com.educ_nc_spring_19.auth_service.payload.request.UserUpdateRequest;
import com.educ_nc_spring_19.auth_service.service.repo.SystemRoleRepository;
import com.educ_nc_spring_19.auth_service.service.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    SystemRoleRepository systemRoleRepository;

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    public ArrayList<User> AllUsers() {
        ArrayList<User> result = new ArrayList<>();
        for (User u : userRepository.findAll()) {
            result.add(u);
        }
        return result;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/findById", method = RequestMethod.GET, produces = "application/json")
    public User FindUserById(UUID id) {
        return userRepository.findById(id).orElse(null);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/findByLoginOrEmail", method = RequestMethod.GET, produces = "application/json")
    public User FindUserByLogin(String loginOrEmail) {
        return userRepository.findByLoginOrEmailAddress(loginOrEmail, loginOrEmail).get(0);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json")
    public String UpdateUser(@Valid @RequestBody UserUpdateRequest userUpdateRequest) {
        String  result = "success";
        try {
            User user = userRepository.findById(userUpdateRequest.getId()).orElse(null);
            user.setFirstName(userUpdateRequest.getFirstName());
            user.setLastName(userUpdateRequest.getLastName());
            user.setPassword(userUpdateRequest.getPassword());
            user.setEmailAddress(userUpdateRequest.getEmail());
            user.setLogin(userUpdateRequest.getLogin());
            Set<SystemRole> systemRoles = new HashSet<>();
            for (String s : userUpdateRequest.getSystemRolesNames()) {
                systemRoles.add(systemRoleRepository.findByName(s));
            }
            user.setSystemRoles(systemRoles);
            /*//TODO: и че с этим делоть
            List<SystemRole> createdSystemRoles = new ArrayList<>();
            for (String s : userUpdateRequest.getCreatedSystemRolesNames()) {
                createdSystemRoles.add(systemRoleRepository.findByName(s));
            }
            user.setCreatedSystemRoles(createdSystemRoles);
            List<SystemRole> updatedSystemRoles = new ArrayList<>();
            for (String s : userUpdateRequest.getUpdatedSystemRolesNames()) {
                updatedSystemRoles.add(systemRoleRepository.findByName(s));
            }
            user.setUpdatedSystemRoles();
            */
            user.setUpdatedByUserId(userUpdateRequest.getUpdatedByUserId());
            user.setUpdatedByUser(userRepository.findById(userUpdateRequest.getUpdatedByUserId()).orElse(null));
            user.setUpdatedDate(OffsetDateTime.now());
            userRepository.save(user);
        } catch (Exception e) {
            result = "Exception: " + e.getMessage();
        }
        return result;
    }

}
