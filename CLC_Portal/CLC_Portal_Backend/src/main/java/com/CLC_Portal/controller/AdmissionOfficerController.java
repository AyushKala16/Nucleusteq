package com.CLC_Portal.controller;

import com.CLC_Portal.model.AdmissionOfficer;
import com.CLC_Portal.model.Student;
import com.CLC_Portal.model.User;
import com.CLC_Portal .service.AdmissionOfficerService;
import com.CLC_Portal.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/officers")
@CrossOrigin("*")
public class AdmissionOfficerController {

    @Autowired
    private AdmissionOfficerService admissionOfficerService;
    
    @Autowired
    private UserService userService;

    // Get all admission officers
    @GetMapping
    public ResponseEntity<List<AdmissionOfficer>> getAllAdmissionOfficers() {
        return ResponseEntity.ok(admissionOfficerService.getAllAdmissionOfficers());
    }

    // Add an admission officer
    @PostMapping("/add")
    public ResponseEntity<?> addAdmissionOfficer(@RequestBody AdmissionOfficer officer) {
    	try {
        	User user = new User();
            user.setName(officer.getName());
            user.setEmail(officer.getEmail());
            user.setPassword(officer.getPassword());

            user.setRole("OFFICER"); // Set role

            userService.saveUser(user);
            return ResponseEntity.ok(admissionOfficerService.addAdmissionOfficer(officer));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        
    }

    // Remove an admission officer
    
    @DeleteMapping("/removeofficer")
    public ResponseEntity<String> removeAdmissionOfficer(@RequestParam String email) {
        admissionOfficerService.removeAdmissionOfficerWithEmail(email);
        userService.deleteUserWithEmail(email);
        return ResponseEntity.ok("Admission officer removed successfully!");
    }
}
