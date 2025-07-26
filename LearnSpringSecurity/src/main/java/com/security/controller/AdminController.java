package com.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.security.LocalDateTime.User;
import com.security.dto.UserDTO;
import com.security.service.UserService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	@Autowired
	UserService service;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/getuser")
	public ResponseEntity<List<User>> getAllUser(){
		return new ResponseEntity<List<User>>(service.getAllUsers(), HttpStatus.OK);
	}
	
	@PutMapping("/update-role")
	public ResponseEntity<String> updateRole(@RequestParam Long userId,@RequestParam String roleName){
		service.upateUserRole(userId, roleName);
		return new ResponseEntity<String>("User role Is Updated", HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<UserDTO> getUser(@PathVariable Long id){
		return new ResponseEntity<>(service.getUserById(id),HttpStatus.OK);
	}
	

}
