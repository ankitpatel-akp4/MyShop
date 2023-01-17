package com.myshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.entities.Country;
import com.myshop.exception.CountryException;
import com.myshop.repo.CountryRepo;

@Service
public class CountryServiceImpl implements CountryService{
	@Autowired
	private CountryRepo countryRepo;
	
	@Override
	public Country addCountry(Country country) throws CountryException {
		if(country != null)
			throw new CountryException("not a valid county data");
		return countryRepo.save(country);
	}
	
	@Override
	public List<Country> getAttCountry() throws CountryException {
		List<Country> countries = countryRepo.findAll();
		if(countries.isEmpty())
			throw new CountryException("no country found in database");
		return countries;
	}

	@Override
	public List<Country> getCounryByName(String countryName) throws CountryException {
		List<Country> countries = countryRepo.findByCountryNameContainingIgnoreCase(countryName);
		if(countries.isEmpty())
			throw new CountryException("no country by the name"+countryName);
		return countries;
	}

	@Override
	public Country getCounryById(Integer countryId) throws CountryException {
		
		return countryRepo.findById(countryId).orElseThrow(()->new CountryException("not contry found by id:"+countryId));
	}

	@Override
	public Country deleteCountry(Integer countryId) throws CountryException {
		Country foundCountry = getCounryById(countryId);
		countryRepo.delete(foundCountry);
		return foundCountry;
	}

	@Override
	public Country updateCountry(Country country) throws CountryException {
		Country foundCountry = getCounryById(country.getCountryId());
		
		return countryRepo.save(country);
	}



	
}
