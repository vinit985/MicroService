 package com.lcwd.user.service.services;

import java.util.ArrayList;


import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.yaml.snakeyaml.internal.Logger;

import com.lcwd.user.service.entity.Hotel;
import com.lcwd.user.service.entity.Rating;
import com.lcwd.user.service.entity.User;
import com.lcwd.user.service.exception.ResourceNotFoundException;
import com.lcwd.user.service.external.services.HotelService;
import com.lcwd.user.service.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private HotelService hotelService;
	private org.slf4j.Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Override
	public User saveUser(User user) {
//		This will generate always unique id 
		 String randomUserId = UUID.randomUUID().toString();
		 user.setUserId(randomUserId);
		return  this.userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
//		Implementing rating service in this method to include it in userService to get displayed
		List<User> listofUser =  this.userRepository.findAll();
		
		return listofUser;
	}

	@Override
	public User getUserById(String id) {
		// TODO Auto-generated method stub
//		Helps to get user from database thorugh userId 
		User user = this.userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found with given UserId"));
//		TO inculde rating in  userService we need to call Rating service
//		We can use this url to call ratings service 
//		http://localhost:8083/ratings/users/36b95c1e-770e-465b-85b9-ce0bfe9d055e
        Rating[]  ratingArray = restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+user.getUserId(),Rating[].class);
        List<Rating> ratingList = Arrays.stream(ratingArray).toList();
        List<Rating> list = ratingList.stream().map(rating->{
//        	API to call hotelservice
//                http://localhost:8082/hotels/c667609c-7a6a-4856-ac3c-accc28f1ad48
//         ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTELSERVICE/hotels/"+rating.getHotelId(),Hotel.class);
        	Hotel forEntity = hotelService.getHotel(rating.getHotelId());
         rating.setHotel(forEntity); 	   
         return rating;
        	
        }).collect(Collectors.toList());
        user.setRatings(list);
        logger.info("{}",ratingList);
	    return user;
	}

}
