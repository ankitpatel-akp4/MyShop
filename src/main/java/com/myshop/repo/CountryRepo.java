/**
 * 
 */
package com.myshop.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myshop.entities.Country;

/**
 * @author indicate0
 *
 */
@Repository
public interface CountryRepo extends JpaRepository<Country, Integer>{
	List<Country> findByCountryNameContainingIgnoreCase(String countryName);
}
