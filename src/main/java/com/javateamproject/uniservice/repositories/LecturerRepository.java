package com.javateamproject.uniservice.repositories;

import com.javateamproject.uniservice.models.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 18.02.2018
 *
 * @author Andrey Romanov (steampart@gmail.com)
 * @version 1.0
 */
public interface LecturerRepository extends JpaRepository<Lecturer, Long>{
}
