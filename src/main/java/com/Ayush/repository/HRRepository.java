package com.Ayush.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Ayush.model.HR;

public interface HRRepository extends JpaRepository<HR, Long> {
    HR findByEmail(String email);
}
