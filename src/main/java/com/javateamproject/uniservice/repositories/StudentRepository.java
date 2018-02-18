package com.javateamproject.uniservice.repositories;

import com.javateamproject.uniservice.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 18.02.2018
 *
 * @author Andrey Romanov (steampart@gmail.com)
 * @version 1.0
 */
public interface StudentRepository extends JpaRepository<Student, Long>{
}
