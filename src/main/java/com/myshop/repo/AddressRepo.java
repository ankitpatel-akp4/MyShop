/**
 * 
 */
package com.myshop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myshop.entities.Address;

/**
 * @author indicate0
 *
 */
@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {

}
