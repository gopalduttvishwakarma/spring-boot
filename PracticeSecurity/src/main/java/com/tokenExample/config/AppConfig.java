package com.tokenExample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class AppConfig {
	
	@Bean
	protected UserDetailsService userDetailsService() {
		//user details who can access apis
		UserDetails userDetails = User.builder().username("gopal").password(passwordEncoder().encode("123")).build();
		UserDetails userDetails2 = User.builder().username("preeti").password(passwordEncoder().encode("123")).build();
		// Here you can create multiple users and pass comma separeted params
		return new InMemoryUserDetailsManager(userDetails, userDetails2); // this methos has varags 
	}
	
	@Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
	protected AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
		return builder.getAuthenticationManager();
	}
}
