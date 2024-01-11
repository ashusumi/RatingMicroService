package com.RatingService.Service;

import java.util.List;

import com.RatingService.model.Ratings;

public interface RatingService {

	
	public List<Ratings> getAllRatings();
	
	public List<Ratings> getRatingByUserId(String  userId);
	
	public List<Ratings> getRatingByHotelId(String hotelId);
	
	public Ratings addRatings(Ratings ratings);
	
	public String updateRatings(Integer id,Ratings ratings);
	
	public String deleteRatings(Integer id);
}
