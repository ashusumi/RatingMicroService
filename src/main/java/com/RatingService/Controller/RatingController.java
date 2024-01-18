package com.RatingService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RatingService.ServiceImpl.RatingServiceImpl;
import com.RatingService.model.Ratings;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/ratings")
public class RatingController {

	
	@Autowired
	private RatingServiceImpl impl;
	
	@GetMapping("/AllRatings")
	public ResponseEntity<?> getAllRatings() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(impl.getAllRatings());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@PostMapping("/addRatings")
	public ResponseEntity<?> addRatings(@RequestBody Ratings rating) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(impl.addRatings(rating));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		
	}
	
	@PostMapping("/addAllRatings")
	public ResponseEntity<?> addMoreThanOneRatings(@RequestBody List<Ratings> ratings){
		try {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(impl.addListRatings(ratings));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}
	
	@GetMapping("hotel/{hotelId}")
	public ResponseEntity<?> getHotelById(@PathVariable String hotelId) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(impl.getRatingByHotelId(hotelId));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@PreAuthorize("hasAuthority('SCOPE_email')")
	@GetMapping("/user/{id}")
	public ResponseEntity<?> getUsersById(@PathVariable String  id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(impl.getRatingByUserId(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	
	
	
}
