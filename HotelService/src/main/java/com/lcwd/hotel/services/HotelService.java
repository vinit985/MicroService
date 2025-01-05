package com.lcwd.hotel.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lcwd.hotel.entites.Hotel;
@Service
public interface HotelService {

	public Hotel createHotel(Hotel hotel);
	public List<Hotel> getAllHotel();
	public Hotel getHotelById(String id);
	
}
