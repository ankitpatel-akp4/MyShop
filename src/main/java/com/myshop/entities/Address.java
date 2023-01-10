package com.myshop.entities;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Address {
	@Id
	private Integer addressId;
	private String houseNumber;
	private String streetNumber;
	private String address_line1;
	private String address_line2;
	private String city;
	private String region;
	private String postalcode;
	private boolean isDefault;
	@ManyToOne
	@JoinColumn(name = "country_id")
	private Country countryId;
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<User> users = new HashSet<>();
}
