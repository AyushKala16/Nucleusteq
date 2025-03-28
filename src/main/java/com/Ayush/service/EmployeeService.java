package com.Ayush.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Ayush.model.Employee;
import com.Ayush.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }
    //    Add Employee
    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }
    //    Update Employee
    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        return repository.findById(id).map(emp -> {
            emp.setName(updatedEmployee.getName());
            emp.setDepartment(updatedEmployee.getDepartment());
            emp.setEmail(updatedEmployee.getEmail());
            emp.setSalary(updatedEmployee.getSalary());
            return repository.save(emp);
        }).orElseThrow(() -> new RuntimeException("Employee not found"));
    }
	// 	Delete Employee
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}
