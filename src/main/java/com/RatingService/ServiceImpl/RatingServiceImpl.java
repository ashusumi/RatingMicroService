package com.RatingService.ServiceImpl;

import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.RatingService.Dao.RatingsRepo;
import com.RatingService.Service.RatingService;
import com.RatingService.model.Ratings;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingsRepo ratingsRepo;

	@Override
	public List<Ratings> getAllRatings() {

		return ratingsRepo.findAll();
	}

	@Override
	public Ratings addRatings(Ratings ratings) {

		Random num = new Random();
		int id = Math.abs(num.nextInt());
		Ratings ratings2 = Ratings.builder().id(id).userId(ratings.getUserId()).hotelId(ratings.getHotelId())
				.feedBack(ratings.getFeedBack()).ratings(ratings.getRatings()).build();
		ratingsRepo.save(ratings2);
		return ratings2;
	}

	@Override
	public String updateRatings(Integer id, Ratings ratings) {

		return null;
	}

	@Override
	public String deleteRatings(Integer id) {

		return null;
	}

	@Override
	public List<Ratings> getRatingByUserId(String userId) {
		
	
		return ratingsRepo.findByUserId(userId);
	}

	@Override
	public List<Ratings> getRatingByHotelId(String hotelId) {

		return ratingsRepo.findByHotelId(hotelId);
	}

}
