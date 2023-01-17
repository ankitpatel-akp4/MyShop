package com.myshop.dto.usermapper;

import lombok.Data;

@Data
public class SignupReq {
	private String email;
	private String mobile;
	private String firstName;
	private String lastName;
	private String password;
}
