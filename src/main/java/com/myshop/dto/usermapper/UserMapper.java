package com.myshop.dto.usermapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.myshop.entities.User;

@Mapper
public interface UserMapper {
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	User signupReqToUser(SignupReq signupReq);
	SignupRes userToSignupRes(User user);
	User signupResToUser(SignupRes signupRes);

	
}
