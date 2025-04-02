package com.CLC_Portal.service;

import com.CLC_Portal.model.User;
import com.CLC_Portal.repository.UserRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

//    public Optional<User> getUserById(Long id) {
//        return userRepository.findById(id);
//    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User saveUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already registered!");
        }
        return userRepository.save(user);
    }


    @Transactional
    public void deleteUserWithEmail(String email) {
        userRepository.removeByEmail(email);
    }
}
