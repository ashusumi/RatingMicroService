package com.RatingService.Dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.RatingService.model.Ratings;

public interface RatingsRepo extends MongoRepository<Ratings, Integer>{

	List<Ratings> findByUserId(String userId);
	
	List<Ratings> findByHotelId(String hotelId);
}
