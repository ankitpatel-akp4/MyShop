package com.myshop.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class Country {
	@Id
	private Integer countryId;
	private String countryName;
}
