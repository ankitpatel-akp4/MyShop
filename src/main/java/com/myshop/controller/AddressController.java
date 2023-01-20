package com.myshop.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myshop.entities.Address;
import com.myshop.entities.User;
import com.myshop.service.AddressService;
import com.myshop.service.UserServiceImpl;

@RestController
@RequestMapping(value = "/addresses")
public class AddressController {
	@Autowired
	private AddressService addressService;
	@Autowired
	private UserServiceImpl userService;
	
	@PostMapping
	public ResponseEntity<Set<Address>> addAddress(@RequestBody Address address) {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		User currentUser = userService.getUserByEmail(email);
		currentUser.getAddresses().add(address);
		address.getUsers().add(currentUser);
		User user = userService.updateUser(currentUser);
		return new ResponseEntity<Set<Address>>(user.getAddresses(),HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity updateAddress(@RequestBody Address address) {
		return new ResponseEntity(addressService.updateAddress(address),HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<Set<Address>> getAllAddress() {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		User currentUser = userService.getUserByEmail(email);
		return new ResponseEntity<Set<Address>>(currentUser.getAddresses(),HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity deleteAddress(@RequestParam Long addressId) {
		Address address = addressService.deleteAddressById(addressId);
		return new ResponseEntity(address,HttpStatus.OK);
	}
}
