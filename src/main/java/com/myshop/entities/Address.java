package com.myshop.entities;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long addressId;
	private String houseNumber;
	private String streetNumber;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String region;
	private String postalCode;
	private boolean isDefault;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "countryId")
	private Country country;
	@ManyToMany(mappedBy = "addresses")
	@JsonIgnore
	private Set<User> users = new HashSet<>();
	
	
	public void merge(Address address) {
		if(address.getHouseNumber()!= null)
			this.houseNumber = address.getHouseNumber();
		if(address.getStreetNumber()!= null)
			this.streetNumber = address.getStreetNumber();
		if(address.getAddressLine1()!= null)
			this.addressLine1 = address.getAddressLine1();
		if(address.getAddressLine2()!= null)
			this.addressLine2 = address.getAddressLine2();
		if(address.getCity()!= null)
			this.city = address.getCity();
		if(address.getRegion()!= null)
			this.region = address.getRegion();
		if(address.getPostalCode()!= null)
			this.postalCode = address.getPostalCode();
		if(address.isDefault()) {
			this.isDefault = address.isDefault();
		}else {
			this.isDefault = false;
		}
		if(address.getCountry() != null) {
			this.country = address.getCountry();
		}
		
		
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(addressLine1, other.addressLine1) && Objects.equals(addressLine2, other.addressLine2)
				&& Objects.equals(city, other.city) && Objects.equals(country, other.country)
				&& Objects.equals(houseNumber, other.houseNumber) && Objects.equals(postalCode, other.postalCode)
				&& Objects.equals(region, other.region) && Objects.equals(streetNumber, other.streetNumber);
	}
	@Override
	public int hashCode() {
		return Objects.hash(addressLine1, addressLine2, city, country, houseNumber, postalCode, region,
				streetNumber);
	}
}
