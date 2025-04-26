package com.security.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

//import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.security.LocalDateTime.User;
import com.security.model.AppRole;
import com.security.model.Role;
import com.security.repositories.RoleRepository;
import com.security.repositories.UserRepository;

import static org.springframework.security.config.Customizer.withDefaults;

import java.time.LocalDate;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests((requests) -> requests
				// This permit to contact

				// .requestMatchers("/contact").permitAll()
				//.requestMatchers("/admin").denyAll()
				.anyRequest().authenticated());
		http.csrf(csrf -> csrf.disable());
		// http.formLogin(withDefaults());
		http.httpBasic(withDefaults());
		// This will hide the cookies
		// http.sessionManagement(session ->
		// session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		return http.build();

	}

//	@Bean
//	public UserDetailsService userDetailsService(DataSource dataSource) {
////		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//		
////		if (!manager.userExists("user1")) {
////			manager.createUser(User.withUsername("user1").password("{noop}password").roles("USER").build());
////
////		}
//		
//		JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
//		
//		//Alternate way 
//		
//		UserDetails userDetails = User.withUsername("user1")
//				.password("{noop}password")
//				.roles("USER")
//				.build();
//		if (!manager.userExists("user1")) {
//			System.out.println("hello");
//		manager.createUser(userDetails);
//
//	}
//		
//
//		if (!manager.userExists("admin")) {
//			manager.createUser(User.withUsername("admin").password("{noop}adminpass").roles("ADMIN").build());
//
//		}
//		return manager;
//	}
	
	@Bean
    public CommandLineRunner initData(RoleRepository roleRepository, UserRepository userRepository) {
        return args -> {
            Role userRole = roleRepository.findByRoleName(AppRole.ROLE_USER)
                    .orElseGet(() -> roleRepository.save(new Role(AppRole.ROLE_USER)));

            Role adminRole = roleRepository.findByRoleName(AppRole.ROLE_ADMIN)
                    .orElseGet(() -> roleRepository.save(new Role(AppRole.ROLE_ADMIN)));

            if (!userRepository.existsByUserName("user1")) {
                User user1 = new User("user1", "user1@example.com", "{noop}password1");
                user1.setAccountNonLocked(false);
                user1.setAccountNonExpired(true);
                user1.setCredentialsNonExpired(true);
                user1.setEnabled(true);
                user1.setCredentialsExpiryDate(LocalDate.now().plusYears(1));
                user1.setAccountExpiryDate(LocalDate.now().plusYears(1));
                user1.setTwoFactorEnabled(false);
                user1.setSignUpMethod("email");
                user1.setRole(userRole);
                userRepository.save(user1);
            }
            
            if (!userRepository.existsByUserName("admin")) {
                User admin = new User("admin", "admin@example.com", "{noop}adminPass");
                admin.setAccountNonLocked(true);
                admin.setAccountNonExpired(true);
                admin.setCredentialsNonExpired(true);
                admin.setEnabled(true);
                admin.setCredentialsExpiryDate(LocalDate.now().plusYears(1));
                admin.setAccountExpiryDate(LocalDate.now().plusYears(1));
                admin.setTwoFactorEnabled(false);
                admin.setSignUpMethod("email");
                admin.setRole(adminRole);
                userRepository.save(admin);
            }
        };
    }

}
