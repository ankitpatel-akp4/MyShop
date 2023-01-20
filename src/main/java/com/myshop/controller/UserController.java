package com.myshop.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myshop.dto.usermapper.SignupReq;
import com.myshop.dto.usermapper.SignupRes;
import com.myshop.dto.usermapper.UserMapper;
import com.myshop.entities.Address;
import com.myshop.entities.ProductItem;
import com.myshop.entities.ShopingCart;
import com.myshop.entities.User;
import com.myshop.exception.AddressException;
import com.myshop.exception.ProductException;
import com.myshop.service.AddressService;
import com.myshop.service.ProductService;
import com.myshop.service.UserServiceImpl;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	@Autowired
	private UserServiceImpl userService;

	
	@GetMapping(value = "")
	public ResponseEntity<List<User>> getAllUser() {
		return new ResponseEntity<>(userService.getAllUser(),HttpStatus.OK);
	}
	
	@PutMapping(value = "")
	public ResponseEntity<SignupRes> updateUser(@RequestBody SignupRes signupRes) {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		User currenUser = userService.getUserByEmail(email);
		User tempUser = UserMapper.INSTANCE.signupResToUser(signupRes);
		currenUser.merge(tempUser);
		User updatedUser = userService.updateUser(currenUser);
		SignupRes signupRes2 = UserMapper.INSTANCE.userToSignupRes(updatedUser);		
		return new ResponseEntity<>(signupRes2,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
}
