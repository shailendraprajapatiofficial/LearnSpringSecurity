package com.security.LocalDateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.security.model.Role;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users",uniqueConstraints = {
		@UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames = "email")
})

public class User {
	
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public LocalDate getCredentialsExpiryDate() {
		return credentialsExpiryDate;
	}

	public void setCredentialsExpiryDate(LocalDate credentialsExpiryDate) {
		this.credentialsExpiryDate = credentialsExpiryDate;
	}

	public LocalDate getAccountExpiryDate() {
		return accountExpiryDate;
	}

	public void setAccountExpiryDate(LocalDate accountExpiryDate) {
		this.accountExpiryDate = accountExpiryDate;
	}

	public String getTwoFactorSecret() {
		return twoFactorSecret;
	}

	public void setTwoFactorSecret(String twoFactorSecret) {
		this.twoFactorSecret = twoFactorSecret;
	}

	public String getSignUpMethod() {
		return signUpMethod;
	}

	public void setSignUpMethod(String signUpMethod) {
		this.signUpMethod = signUpMethod;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@NotBlank
	@Size(max=20)
	@Column(name ="username")
	private String userName;
	
	@NotBlank
	@Size(max=50)
	@Column(name ="email")
	private String email;
	
	@NotBlank
	@Size(max=120)
	@Column(name ="password")
	@JsonIgnore
	private String password;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isTwoFactorEnabled() {
		return isTwoFactorEnabled;
	}
	

	public void setTwoFactorEnabled(boolean isTwoFactorEnabled) {
		this.isTwoFactorEnabled = isTwoFactorEnabled;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	private boolean accountNonLocked = true;
	private boolean accountNonExpired = true;
	private boolean credentialsNonExpired = true;
	private boolean enabled = true;
	
	private LocalDate credentialsExpiryDate;
	private LocalDate accountExpiryDate;
	
	private String twoFactorSecret;
	private boolean isTwoFactorEnabled = false;
	private String signUpMethod;
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
	@JoinColumn(name ="role_id",referencedColumnName = "role_id")
	@JsonBackReference
	private Role role;
	
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createdDate;
	
	@UpdateTimestamp
	private LocalDateTime updatedDate;
	
	public User(String userName, String email, String password) {
		this.userName=userName;
		this.email=email;
		this.password=password;
		
	}
	
	public User(String userName, String email) {
		this.userName=userName;
		this.email=email;
		
	}
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(!(o instanceof User)) return false;
		return userId != null && userId.equals(((User)o).getUserId());
	}
	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

	
	
	
	
	
	
	

}
