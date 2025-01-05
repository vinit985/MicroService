package com.lcwd.rating.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.rating.entities.Rating;
import com.lcwd.rating.repositories.RatingRepository;

@Service
public interface RatingService {

//	Create rating
	 public Rating createRating(Rating rating);
//	 Get all rating
	 public List<Rating> getAllRating();
//	 Get rating by userId
	 public List<Rating> getRatingByUserId(String userId);
//	 Get rating by hotelId
	 public List<Rating> getRatingByHotelId(String hotelId);
}
