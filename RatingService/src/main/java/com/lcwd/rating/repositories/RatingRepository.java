package com.lcwd.rating.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lcwd.rating.entities.Rating;
@Repository
public interface RatingRepository  extends JpaRepository<Rating,String> {

//	Custom finder Method
	
	public List<Rating> findByUserId(String userId);
	public List<Rating> findByHotelId(String hotelId);
}
