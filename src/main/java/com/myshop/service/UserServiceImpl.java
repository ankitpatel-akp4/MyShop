package com.myshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.myshop.entities.ShopingCart;
import com.myshop.entities.User;
import com.myshop.exception.UserException;
import com.myshop.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public User addUser(User user) throws UserException {
		if(user == null)
			throw new UserException("Not a valid input");
		return userRepo.save(user);
	}
	
	public ShopingCart addShopingCart() throws UserException {
		
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		User currentUser = getUserByEmail(email);
		if(currentUser.getShopingCart()!= null) throw new UserException("you already have a cart");
		ShopingCart shopingCart = new ShopingCart();
		shopingCart.setUser(currentUser);
		currentUser.setShopingCart(shopingCart);
		return userRepo.save(currentUser).getShopingCart();
	}

	@Override
	public User delete(Long userId) throws UserException {
		User user = getUserByUserId(userId);
		userRepo.delete(user);
		return user;
	}
	
	public List<User> getAllUser()	throws UserException{
		List<User> users = userRepo.findAll();
		if(users.isEmpty())
			throw new UserException("No user foud in the database!");
		else {
			return users;
		}
	}
	
	
	public User updateUser(User user) throws UserException{
		if(user == null)
			throw new UserException("Not a valid input");
		return userRepo.save(user);
	}
	
	public User getUserByEmail(String email) throws UserException{
		if(email == null)
			throw new UserException("Not a valid argument");
		return userRepo.findByEmail(email).orElseThrow(()->new UserException("user not found"));
	}


	@Override
	public User makeAdmin(User user) throws UserException {
		user.setRoles("user admin");
		return userRepo.save(user);
	}


	@Override
	public User getUserByUserId(Long userId) throws UserException {
		User user = userRepo.findById(userId).orElseThrow(()->new UserException("user not found"));
		return user;
	}
	
	

	
}
