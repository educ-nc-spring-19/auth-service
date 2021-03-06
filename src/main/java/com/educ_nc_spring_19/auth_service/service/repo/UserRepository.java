package com.educ_nc_spring_19.auth_service.service.repo;

import com.educ_nc_spring_19.auth_service.model.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {
}
