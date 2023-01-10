package com.myshop.auth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthoritiesContainer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.myshop.entities.User;

public class UserDetailsImpl implements UserDetails{
	
	private User user;
	private List<GrantedAuthority> authorities;
	public UserDetailsImpl(User user) {
		this.user = user;
		this.authorities = Arrays.stream(user.getRoles().split(" "))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return authorities;
	}

	@Override
	public String getPassword() {
		
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
//		return user.isAccountNonExpired();
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
//		return user.isAccountNonLocked();
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
//		return user.isCredentialsNonExpired();
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
//		return user.isEnabled();
		return true;
	}

}
