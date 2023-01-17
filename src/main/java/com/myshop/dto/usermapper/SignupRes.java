package com.myshop.dto.usermapper;

import lombok.Data;

@Data
public class SignupRes {
	private String email;
	private String mobile;
	private String firstName;
	private String lastName;
}
