package com.educ_nc_spring_19.auth_service.service.repo;

import com.educ_nc_spring_19.auth_service.model.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {

    ArrayList<User> findByLoginOrEmailAddress(String login, String emailAddress);

    boolean existsByLogin(String login);

    boolean existsByEmailAddress(String email);

}
