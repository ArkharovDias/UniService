package com.javateamproject.uniservice.repositories;

import com.javateamproject.uniservice.models.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 18.02.2018
 *
 * @author Andrey Romanov (steampart@gmail.com)
 * @version 1.0
 */
public interface FacultyRepository extends JpaRepository<Faculty, Long>{
}
