package com.myshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.myshop.service.AddressService;

@RestController
public class AddressController {
	@Autowired
	private AddressService addressService;
}
