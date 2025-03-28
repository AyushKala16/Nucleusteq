package com.Ayush.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.Ayush.service.HRService;

@Controller
@RequestMapping("/hr")
public class HRController {
    @Autowired
    private HRService service;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";  // Redirects to login.html
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        boolean isAuthenticated = service.authenticate(email, password);
        
        if (isAuthenticated) {
            return "redirect:/employees";
        } else {
            model.addAttribute("error", "Invalid Credentials");
            return "login";
        }
    }
}
