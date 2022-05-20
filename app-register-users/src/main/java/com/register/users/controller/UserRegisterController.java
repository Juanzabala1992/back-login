package com.register.users.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.register.users.DTO.UserRegisterDTO;
import com.register.users.model.Userd;
import com.register.users.repository.UserRepository;
import com.register.users.service.UserService;

@RestController
@RequestMapping("api/v1/")
public class UserRegisterController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private UserService userService;
		
	@ModelAttribute("usuario")
	public UserRegisterDTO returnNewUserRegisterDTO() {
		return new UserRegisterDTO();
	}
	@PostMapping("/register")
	public Userd saveUser(@RequestBody UserRegisterDTO userRegisterDTO ) {			
		return userService.save(userRegisterDTO);
	}
	@PostMapping("/login")
	public boolean loginInfo(@RequestBody UserRegisterDTO userRegisterDTO) {
		return userService.get(userRegisterDTO);		
	}	
}