package com.fullstack.realestate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.realestate.dto.UserDto;
import com.fullstack.realestate.dto.UserResponse;
import com.fullstack.realestate.service.UserService;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	private UserService userService;

	@PostMapping(value = "/signup")
	public ResponseEntity<UserResponse> singUp(@RequestBody UserDto userDto) {
		userService.signUp(userDto);

		UserResponse response = new UserResponse("User created successfully!");

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
