package com.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests((requests) -> requests
				// This permit to contact

				// .requestMatchers("/contact").permitAll()
				.anyRequest().authenticated());
		http.csrf(csrf -> csrf.disable());
		// http.formLogin(withDefaults());
		http.httpBasic(withDefaults());
		// This will hide the cookies
		// http.sessionManagement(session ->
		// session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		return http.build();

	}

	@Bean
	public UserDetailsService userDetailsService(DataSource dataSource) {
//		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		
//		if (!manager.userExists("user1")) {
//			manager.createUser(User.withUsername("user1").password("{noop}password").roles("USER").build());
//
//		}
		
		JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
		
		//Alternate way 
		
		UserDetails userDetails = User.withUsername("user1")
				.password("{noop}password")
				.roles("USER")
				.build();
		if (!manager.userExists("user1")) {
			System.out.println("hello");
		manager.createUser(userDetails);

	}
		

		if (!manager.userExists("admin")) {
			manager.createUser(User.withUsername("admin").password("{noop}adminpass").roles("ADMIN").build());

		}
		return manager;
	}

}
