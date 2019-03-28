package com.educ_nc_spring_19.auth_service.repository;

import com.educ_nc_spring_19.auth_service.entity.SystemRole;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SystemRoleRepository extends CrudRepository<SystemRole, UUID> {
}
