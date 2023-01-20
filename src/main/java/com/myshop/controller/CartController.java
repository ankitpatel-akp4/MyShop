package com.myshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myshop.entities.ProductItem;
import com.myshop.entities.ShopingCart;
import com.myshop.entities.User;
import com.myshop.exception.ProductException;
import com.myshop.service.AddressService;
import com.myshop.service.CartService;
import com.myshop.service.ProductService;
import com.myshop.service.UserServiceImpl;

@RestController
@RequestMapping(value = "/carts")
public class CartController {
	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private CartService cartService;
	@Autowired
	private ProductService productService;

	@GetMapping
	public ResponseEntity<ShopingCart> getShopingChart() {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		User currentUser = userService.getUserByEmail(email);
		return new ResponseEntity<ShopingCart>(currentUser.getShopingCart(),HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<ShopingCart> addShopingChart() {
		
		return new ResponseEntity<ShopingCart>(cartService.addShopingCart(),HttpStatus.OK);
	}
	@PatchMapping
	public ResponseEntity<ShopingCart> addProductItem(@RequestParam Long productItemId) {
		ProductItem productItem = productService.getProductItemById(productItemId);
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		User currentUser = userService.getUserByEmail(email);
		currentUser.getShopingCart().getProductItems().add(productItem);
		
		return new ResponseEntity<ShopingCart>(userService.updateUser(currentUser).getShopingCart(),HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<ShopingCart> deleteProductItem(@RequestParam Long productItemId) {
		ProductItem productItem = productService.getProductItemById(productItemId);
		
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		User currentUser = userService.getUserByEmail(email);
		if(currentUser.getShopingCart().getProductItems().contains(productItem))
		currentUser.getShopingCart().getProductItems().remove(productItem);
		else throw new ProductException("you dont have this item in your cart");
		userService.updateUser(currentUser);
		return new ResponseEntity<ShopingCart>(currentUser.getShopingCart(),HttpStatus.OK);
	}
	

}
