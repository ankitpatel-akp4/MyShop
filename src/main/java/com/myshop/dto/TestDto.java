package com.myshop.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class TestDto {
	@NotBlank
	@NotNull
	@NotEmpty
	private String name;
	@Pattern(regexp = "")
	@Size(min = 8)
	private String password;
}
