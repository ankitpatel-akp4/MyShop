package com.myshop.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.myshop.entities.User;
import com.myshop.repo.UserRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	private UserRepo userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByEmail(username).orElseThrow(()->new UsernameNotFoundException("Wrong credentials!"));
		return new UserDetailsImpl(user);
	}
	
}
