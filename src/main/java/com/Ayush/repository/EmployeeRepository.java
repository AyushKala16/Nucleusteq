package com.Ayush.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.Ayush.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {}
