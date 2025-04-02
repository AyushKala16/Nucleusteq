package com.CLC_Portal.repository;

import com.CLC_Portal.model.Seat;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

	Optional<Seat> findByBranch(String branch);
}
