package com.epam.jwt.auth.server.repository;


import com.epam.jwt.auth.server.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    UserEntity findByUserName(String username);
}
