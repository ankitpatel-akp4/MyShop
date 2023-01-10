package com.myshop.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myshop.auth.util.JwtUtil;
import com.myshop.entities.User;
import com.myshop.repo.UserRepo;



@RestController
@RequestMapping(value = "/auth")
public class AuthController {
	 private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

	    
	    @Autowired
	    private AuthenticationManager authenticationManager;
	    @Autowired
	    PasswordEncoder passwordEncoder;
	    @Autowired
	    private UserRepo userRepo;
	    @Autowired
	    private JwtUtil jwtUtil;
	    
	    

	    @PostMapping("/login")
	    public String login(@RequestBody LoginRequest userLogin) throws Exception  {
	    	try {
	    		Authentication authentication = authenticationManager.authenticate(
						new UsernamePasswordAuthenticationToken(userLogin.username(), userLogin.password())
				);
	    		
	    		final String jwt = jwtUtil.generateToken(authentication);

				return jwt;
			}
			catch (BadCredentialsException e) {
				throw new Exception("Incorrect username or password", e);
			}			
	    }
	    
	    
	    
	    
//	    @PostMapping("/logout")
//	    public String logout(@RequestBody LoginRequest userLogin)  {
//	    	Authentication authentication = authenticationManager.authenticate(null);
//	    	return tokenService.generateToken(authentication);
//	    }
	    @PostMapping("/signup")
	    public User signup(@RequestBody User user)  {
	    	user.setPassword(passwordEncoder.encode(user.getPassword()));
	    	System.out.println(user);
	    	return userRepo.save(user);
	    	
	    	
	    }
}
