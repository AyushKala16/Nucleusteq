package com.CLC_Portal.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "seats")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String branch;
    private int totalSeats;
    private int vacantSeats;
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public int getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	public int getVacantSeats() {
		return vacantSeats;
	}
	public void setVacantSeats(int vacantSeats) {
		this.vacantSeats = vacantSeats;
	}
}
