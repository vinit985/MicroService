package com.lcwd.hotel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.hotel.entites.Hotel;
import com.lcwd.hotel.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired 
	private HotelService hotelService;
	@PostMapping()
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel)
	{
	     return new ResponseEntity<Hotel>( hotelService.createHotel(hotel),HttpStatus.CREATED);
	}
	@GetMapping(path="/{id}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable("id")String  id)
	{
		 return new ResponseEntity<Hotel>( hotelService.getHotelById(id),HttpStatus.OK);
	}
	@GetMapping()
	public ResponseEntity<List<Hotel>> getAllHotel()
	{
		 return new ResponseEntity<List<Hotel>>( hotelService.getAllHotel(),HttpStatus.OK);
	}
}
