package com.educ_nc_spring_19.auth_service.service.repo;

import com.educ_nc_spring_19.auth_service.model.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserCrudRepository extends CrudRepository<User, UUID> {

}
