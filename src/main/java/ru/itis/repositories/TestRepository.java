package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.Test;

import java.util.Date;

public interface TestRepository extends JpaRepository<Test, Long> {
    Test getTestByDate(Date date);

}
