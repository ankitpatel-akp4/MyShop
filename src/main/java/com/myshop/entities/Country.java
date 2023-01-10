package com.myshop.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Country {
	@Id
	private Integer countryId;
	private String countryName;
}
