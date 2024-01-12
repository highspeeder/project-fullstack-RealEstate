package com.fullstack.realestate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fullstack.realestate.dto.UserDto;
import com.fullstack.realestate.entity.User;
import com.fullstack.realestate.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder encoder;

	public void signUp(UserDto userDto) {

		String rawPassword = userDto.getPassword();
		String encPassword = encoder.encode(rawPassword);

		User newUser = User.builder()
				.name(userDto.getUsername())
				.email(userDto.getEmail())
				.password(encPassword)
				.build();

		if (newUser != null) {
			userRepository.save(newUser);
		}
	
	}
}
