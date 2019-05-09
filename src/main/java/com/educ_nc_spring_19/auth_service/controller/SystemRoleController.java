package com.educ_nc_spring_19.auth_service.controller;

import com.educ_nc_spring_19.auth_service.model.entity.SystemRole;
import com.educ_nc_spring_19.auth_service.model.entity.User;
import com.educ_nc_spring_19.auth_service.payload.request.RoleAddRequest;
import com.educ_nc_spring_19.auth_service.payload.request.RoleUpdateRequest;
import com.educ_nc_spring_19.auth_service.service.repo.SystemRoleRepository;
import com.educ_nc_spring_19.auth_service.service.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.OffsetDateTime;
import java.util.ArrayList;

@RestController
@RequestMapping("/role")
public class SystemRoleController {

    @Autowired
    SystemRoleRepository systemRoleRepository;
    @Autowired
    UserRepository userRepository;

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    public ArrayList<SystemRole> AllRoles() {
        ArrayList<SystemRole> result = new ArrayList<>();
        for (SystemRole s : systemRoleRepository.findAll()) {
            result.add(s);
        }
        return result;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public String AddRole(@Valid @RequestBody RoleAddRequest roleAddRequest) {
        String result = "success";
        try {
            User creator = userRepository.findById(roleAddRequest.getCreatedByUserId()).orElse(null);
            SystemRole systemRole = new SystemRole(roleAddRequest.getName(), roleAddRequest.getDescription(), creator,
                    roleAddRequest.getCreatedByUserId());
            systemRoleRepository.save(systemRole);
        } catch (Exception e) {
            result = "Exception: " + e.getMessage();
        }
        return result;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json")
    public String AddRole(@Valid @RequestBody RoleUpdateRequest roleUpdateRequest) {
        String result = "success";
        try {
            SystemRole systemRole = systemRoleRepository.findById(roleUpdateRequest.getId()).orElse(null);
            systemRole.setName(roleUpdateRequest.getName());
            systemRole.setDescription(roleUpdateRequest.getDescription());
            systemRole.setUpdatedByUserId(roleUpdateRequest.getUpdatedByUserId());
            systemRole.setUpdatedByUser(userRepository.findById(roleUpdateRequest.getUpdatedByUserId()).orElse(null));
            systemRole.setUpdatedDate(OffsetDateTime.now());
            systemRoleRepository.save(systemRole);
        } catch (Exception e) {
            result = "Exception: " + e.getMessage();
        }
        return result;
    }

}
