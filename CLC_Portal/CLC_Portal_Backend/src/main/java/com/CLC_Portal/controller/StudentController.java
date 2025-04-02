package com.CLC_Portal.controller;

import com.CLC_Portal.model.Student;
import com.CLC_Portal.model.User;
import com.CLC_Portal.service.StudentService;
import com.CLC_Portal.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://localhost:3000") // Allow frontend access
public class StudentController {

    @Autowired
    private StudentService studentService;
    
    @Autowired
    private UserService userService;

    // Fetch all students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    // Fetch a student by Email
    @GetMapping("/detail")
    public ResponseEntity<?> getStudentByRollNumber(@RequestParam String email) {
        Optional<Student> student = studentService.getStudentByEmail(email);
        return student.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Register a new student
    @PostMapping("/register")
    public ResponseEntity<?> registerStudent(@RequestBody Student student) {
        try {
        	User user = new User();
            user.setName(student.getName());
            user.setEmail(student.getEmail());
            user.setPassword(student.getPassword());

            user.setRole("STUDENT"); // Set role

            userService.saveUser(user);
            Student savedStudent = studentService.saveStudent(student);
            return ResponseEntity.ok(savedStudent);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    
    
 // Update student details
    @PutMapping("/update")
    public ResponseEntity<?> updateStudent(@RequestBody Student studentDetails) {
        try {
            Student updatedStudent = studentService.updateStudent(studentDetails);
            return ResponseEntity.ok(updatedStudent);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    
    
 // Approve Student Status
    @PutMapping("/applications/approve")
    public ResponseEntity<?> approveStudent(@RequestParam String email) {
        try {
            Student updatedStudent = studentService.changeStatus(email,"APPROVED");
            return ResponseEntity.ok(updatedStudent);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

//    Reject Student Status
    @PutMapping("/applications/reject")
    public ResponseEntity<?> rejectStudent(@RequestParam String email) {
        try {
            Student updatedStudent = studentService.changeStatus(email,"REJECT");
            return ResponseEntity.ok(updatedStudent);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    
}
