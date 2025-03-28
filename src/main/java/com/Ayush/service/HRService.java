package com.Ayush.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Ayush.model.HR;
import com.Ayush.repository.HRRepository;

@Service
public class HRService {
    @Autowired
    private HRRepository repository;
    
	//	Authenticate valid login
    public boolean authenticate(String email, String password) {
        HR hr = repository.findByEmail(email);
        return hr != null && hr.getPassword().equals(password);
    }
}
