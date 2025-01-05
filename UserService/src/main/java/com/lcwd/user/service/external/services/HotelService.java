package com.lcwd.user.service.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lcwd.user.service.entity.Hotel;

@FeignClient(name = "HOTELSERVICE")
public interface HotelService {
 
	@GetMapping(path = "/hotels/{hotelId}")
	 Hotel getHotel(@PathVariable("hotelId") String  hotelId);
}
