package com.javateamproject.uniservice.repositories;

import com.javateamproject.uniservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * 18.02.2018
 *
 * @author Andrey Romanov (steampart@gmail.com)
 * @version 1.0
 */
public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findByLogin(String login);
    Optional<User> findByToken(String token);
    Optional<User> findById(Long id);

}
