package com.CLC_Portal.repository;


import com.CLC_Portal.model.AdmissionOfficer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmissionOfficerRepository extends JpaRepository<AdmissionOfficer, Long> {

	void deleteByEmail(String email);
}
