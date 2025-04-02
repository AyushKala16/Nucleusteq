package com.CLC_Portal.service;

import com.CLC_Portal.model.AdmissionOfficer;
import com.CLC_Portal.repository.AdmissionOfficerRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdmissionOfficerService {

    @Autowired
    private AdmissionOfficerRepository admissionOfficerRepository;

    // Get all admission officers
    public List<AdmissionOfficer> getAllAdmissionOfficers() {
        return admissionOfficerRepository.findAll();
    }

    // Add an admission officer
    public AdmissionOfficer addAdmissionOfficer(AdmissionOfficer officer) {
        return admissionOfficerRepository.save(officer);
    }

//    
    
 // Remove an admission officer
    @Transactional
    public void removeAdmissionOfficerWithEmail(String email) {
        admissionOfficerRepository.deleteByEmail(email);
    }
}
