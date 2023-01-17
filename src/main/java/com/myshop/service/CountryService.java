package com.myshop.service;

import java.util.List;


import com.myshop.entities.Country;
import com.myshop.exception.CountryException;

public interface CountryService {
	
	public Country addCountry(Country country) throws CountryException;
	public List<Country> getAttCountry() throws CountryException;
	public List<Country> getCounryByName(String countryName) throws CountryException;
	public Country getCounryById(Integer countryId) throws CountryException;
	public Country deleteCountry(Integer countryId) throws CountryException;
	public Country updateCountry(Country country) throws CountryException;
}
