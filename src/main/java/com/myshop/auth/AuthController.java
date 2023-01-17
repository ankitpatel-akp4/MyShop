package com.myshop.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myshop.auth.util.JwtUtil;
import com.myshop.dto.usermapper.MakeAdminDto;
import com.myshop.dto.usermapper.SignupReq;
import com.myshop.dto.usermapper.SignupRes;
import com.myshop.dto.usermapper.UserMapper;
import com.myshop.entities.User;
import com.myshop.repo.UserRepo;
import com.myshop.service.UserService;



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
	    @Autowired
	    private UserService userService;
	    

	    @PostMapping("/login")
	    public String login(@RequestBody LoginRequest userLogin) throws Exception  {

	    	try {
	    		Authentication authentication = authenticationManager.authenticate(
						new UsernamePasswordAuthenticationToken(userLogin.email(), userLogin.password())
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
	    public ResponseEntity<SignupRes> signup(@RequestBody SignupReq signupReq)  {
	    	User user = UserMapper.INSTANCE.signupReqToUser(signupReq);
	    	user.setPassword(passwordEncoder.encode(user.getPassword()));
	    	user.setAccountNonExpired(true);
	    	user.setAccountNonLocked(true);
	    	user.setRoles("user");
	    	user.setEnabled(true);
	    	user.setCredentialsNonExpired(true);
	    	User savedUser = userRepo.save(user);
	    	SignupRes signupRes = UserMapper.INSTANCE.userToSignupRes(user);
	    	return new ResponseEntity<>(signupRes,HttpStatus.CREATED);
	    	
	    }
	    
	    @PatchMapping("/make_admin")
	    public ResponseEntity<SignupRes> makeAdmin(@RequestBody MakeAdminDto makeAdminDto )  {
	    	User user = userService.getUserByEmail(makeAdminDto.getEmail());
	    	User updatedUser = userService.makeAdmin(user);
	    	SignupRes signupRes = UserMapper.INSTANCE.userToSignupRes(updatedUser);
	    	return new ResponseEntity<>(signupRes,HttpStatus.CREATED);
	    	
	    	
	    }
}
