package com.javateamproject.uniservice.repositories;

import com.javateamproject.uniservice.models.Profile;
import com.javateamproject.uniservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * 18.02.2018
 *
 * @author Andrey Romanov (steampart@gmail.com)
 * @version 1.0
 */
public interface ProfileRepository extends JpaRepository<Profile, Long>{

    Optional<Profile> findByUser(User user);

}
