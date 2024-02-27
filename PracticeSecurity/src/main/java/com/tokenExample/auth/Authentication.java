package com.tokenExample.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tokenExample.jwtConfig.JWTHelper;

@RestController
public class Authentication {
	
	@Autowired
	AuthenticationManager manager;
	
	@Autowired
	JWTHelper jwtHelper;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@PostMapping("/authLogin")
	public String authenticateUser(@RequestBody Login login) {
		System.out.println(login.getUserName()+" : "+login.getPassword());
		authenticateUserNameAndPassword(login.getUserName(), login.getPassword());
		UserDetails userDetails = userDetailsService.loadUserByUsername(login.getUserName());
        String token = this.jwtHelper.generateToken(userDetails);
		return token;
	}
	
	private boolean authenticateUserNameAndPassword(String userName, String password) {
		
		UsernamePasswordAuthenticationToken authenticationUser = new UsernamePasswordAuthenticationToken(userName, password);
		try {
			manager.authenticate(authenticationUser);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}	
	}
	
	@ExceptionHandler(BadCredentialsException.class)
	public String exceptionHandler() {
		return "Credentials Invalid !!";
	}
}
