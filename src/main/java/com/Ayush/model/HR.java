package com.Ayush.model;

import jakarta.persistence.*;

@Entity
@Table(name = "hr_users")
public class HR {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String email;
    private String password;
    
    //    Default Constructor
    public HR() {}
    
    // Constructor
    public HR(String email, String password) {
        this.email = email;
        this.password = password;
    }
    //    Getter and Setter Methods
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
