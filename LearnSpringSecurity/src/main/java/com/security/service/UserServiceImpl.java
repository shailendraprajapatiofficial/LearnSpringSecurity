package com.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.LocalDateTime.User;
import com.security.dto.UserDTO;
import com.security.model.AppRole;
import com.security.model.Role;
import com.security.repositories.RoleRepository;
import com.security.repositories.UserRepository;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;

	@Override
	public void upateUserRole(Long userId, String roleName) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("User Not Found"));
		AppRole appRole = AppRole.valueOf(roleName);
		Role role = roleRepository.findByRoleName(appRole).orElseThrow(()-> new RuntimeException("Role not found"));
		user.setRole(role);
		userRepository.save(user);
		
		
		
		
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		
		return userRepository.findAll();
	}

	@Override
	public UserDTO getUserById(Long id) {
		User user = userRepository.findById(id).orElseThrow();
		return convertToDto(user);
	}

	private UserDTO convertToDto(User user) {
		// TODO Auto-generated method stub
		return new UserDTO(user.getUserId(),
				user.getUserName(),
				user.getEmail(),
				user.isAccountNonLocked(),
				user.isAccountNonExpired(),
				user.isCredentialsNonExpired(),
				user.isEnabled(),
				user.getCredentialsExpiryDate(),
				user.getAccountExpiryDate(),
				user.getTwoFactorSecret(),
				user.isTwoFactorEnabled(),
				user.getSignUpMethod(),
				user.getRole(),
				user.getCreatedDate(),
				user.getUpdatedDate()
				);
	}

	

	
}
