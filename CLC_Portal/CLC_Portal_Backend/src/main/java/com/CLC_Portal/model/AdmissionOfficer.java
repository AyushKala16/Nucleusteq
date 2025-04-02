package com.CLC_Portal.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "admission_officers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdmissionOfficer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
