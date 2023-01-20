package com.myshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.myshop.entities.ShopingCart;
import com.myshop.entities.User;
import com.myshop.exception.UserException;

@Service
public class CartService {
	@Autowired
	private UserService userService;

	public ShopingCart addShopingCart() throws UserException {
		
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		User currentUser = userService.getUserByEmail(email);
		if(currentUser.getShopingCart()!= null) throw new UserException("you already have a cart");
		ShopingCart shopingCart = new ShopingCart();
		shopingCart.setUser(currentUser);
		currentUser.setShopingCart(shopingCart);
		return userService.updateUser(currentUser).getShopingCart();
	}
}
