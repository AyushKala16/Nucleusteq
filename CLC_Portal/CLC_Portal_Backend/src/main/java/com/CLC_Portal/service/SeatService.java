 package com.CLC_Portal.service;

import com.CLC_Portal.model.Seat;
import com.CLC_Portal.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    // Get all seat details
    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    // Get seat details by branch
    public Optional<Seat> getSeatByBranch(String branch) {
        return seatRepository.findAll()
                .stream()
                .filter(seat -> seat.getBranch().equalsIgnoreCase(branch))
                .findFirst();
    }

    // Add or update seat details
    public Seat addOrUpdateSeat(Seat seat) {
        return seatRepository.save(seat);
    }
    

    public boolean updateSeat(String branch, int change) {
        Optional<Seat> seatOpt = seatRepository.findByBranch(branch);
        if (seatOpt.isPresent()) {
            Seat seat = seatOpt.get();
            
            int newVacantSeats = seat.getVacantSeats() + change;
            if (newVacantSeats < 0) {
                return false; // Avoid negative seat count
            }

            seat.setVacantSeats(newVacantSeats);
            seatRepository.save(seat);
            return true;
        }
        return false;
    }

    // Allocate a seat (decrement vacantSeats)
    public boolean allocateSeat(String branch) {
        Optional<Seat> seatOptional = getSeatByBranch(branch);
        if (seatOptional.isPresent()) {
            Seat seat = seatOptional.get();
            if (seat.getVacantSeats() > 0) {
                seat.setVacantSeats(seat.getVacantSeats() - 1);
                seatRepository.save(seat);
                return true;
            }
        }
        return false;
    }
}
