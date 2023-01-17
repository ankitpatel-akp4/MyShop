package com.myshop.service;

import java.util.List;

import com.myshop.entities.User;
import com.myshop.exception.UserException;

public interface UserService {
	public List<User> getAllUser()	throws UserException;
	public User updateUser(User user) throws UserException;
	public User addUser(User user) throws UserException;
	public User makeAdmin(User user) throws UserException;
	public User delete(Long userId) throws UserException;
	public User getUserByEmail(String email) throws UserException;
	public User getUserByUserId(Long userId) throws UserException;
}
