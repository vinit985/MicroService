package com.lcwd.hotel.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path ="/staffs")
public class StaffController {

	@GetMapping()
	public ResponseEntity<List<String>> getStaffs()
	{
		List list = Arrays.asList("Vinit","Ashu","Shubham","Saatvik");
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
}
