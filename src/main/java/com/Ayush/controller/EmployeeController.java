package com.Ayush.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Ayush.model.Employee;
import com.Ayush.service.EmployeeService;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    
    @GetMapping("/")
    public String showLoginFrom() {
    	return "redirect:/hr/login";
    }

    @GetMapping("/employees")
    public String showEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employees";  // Loads employees.html
    }
    
    @PostMapping("/employees/delete")
    public String deleteEmployee(@RequestParam long id,Model model) {
    	employeeService.deleteEmployee(id);
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "redirect:/employees";  // redirect to employees page
    }
    
    @PostMapping("/employees/add")
    public String deleteEmployee(@RequestParam String name,@RequestParam String department,@RequestParam String email,@RequestParam double salary, Model model) {
    	
    	Employee employee = new Employee(name,department,email,salary);
    	employeeService.addEmployee(employee);
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "redirect:/employees";  // redirect to employees page
    }
    
    @PostMapping("/employees/update")
    public String showEditForm(Employee employee, Model model) {
        model.addAttribute("employees", employee);
        return "editform.html"; // show edit form
    }
    
    @PostMapping("/employees/doupdate")
    public String updateEmployee(Employee employee, Model model) {
    	employeeService.updateEmployee(employee.getId(), employee);
        model.addAttribute("employees", employee);
        return "redirect:/employees";
    }
}
