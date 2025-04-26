package com.security.service;

import java.util.List;

import com.security.LocalDateTime.User;
import com.security.dto.UserDTO;

public interface UserService {
	void upateUserRole(Long userId, String roleName);
	
	List<User> getAllUsers();
	UserDTO getUserById(Long id);
}
