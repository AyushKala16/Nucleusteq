package com.CLC_Portal.controller;


import com.CLC_Portal.model.Seat;
import com.CLC_Portal.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/seats")
@CrossOrigin("*")
public class SeatController {

    @Autowired
    private SeatService seatService;

    // Get all seats
    @GetMapping
    public ResponseEntity<List<Seat>> getAllSeats() {
        return ResponseEntity.ok(seatService.getAllSeats());
    }

    // Get seat details by branch
    @GetMapping("/{branch}")
    public ResponseEntity<Seat> getSeatByBranch(@PathVariable String branch) {
        Optional<Seat> seat = seatService.getSeatByBranch(branch);
        return seat.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
 
    // Add or update seats
    @PostMapping("/add")
    public ResponseEntity<Seat> addOrUpdateSeat(@RequestBody Seat seat) {
        return ResponseEntity.ok(seatService.addOrUpdateSeat(seat));
    }
    
    @PutMapping("/update")
    public ResponseEntity<String> updateSeat(@RequestBody Map<String, Object> request) {
        String branch = (String) request.get("branch");
        int change = (int) request.get("change");
        boolean updated = seatService.updateSeat(branch, change);
        if (updated) {
            return ResponseEntity.ok("Seat count updated successfully!");
        }
        return ResponseEntity.badRequest().body("Failed to update seat count!");
    }


    // Allocate a seat
    @PutMapping("/{branch}/allocate")
    public ResponseEntity<String> allocateSeat(@PathVariable String branch) {
        boolean allocated = seatService.allocateSeat(branch);
        if (allocated) {
            return ResponseEntity.ok("Seat allocated successfully!");
        }
        return ResponseEntity.badRequest().body("No vacant seats available!");
    }
}
