/**
 * 
 */
package com.myshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.myshop.entities.Address;
import com.myshop.entities.User;
import com.myshop.exception.AddressException;
import com.myshop.repo.AddressRepo;

/**
 * @author indicate0
 *
 */
@Service
public class AddressServiceImpl implements AddressService{
	@Autowired
	private AddressRepo addressRepo;
	@Autowired
	private UserService userService;
	
	@Override
	public Address getAddressById(Long addressId) throws AddressException {
		if (addressId==null) {
			throw new IllegalArgumentException("not a valid addressId");
		}
		Address address = addressRepo.findById(addressId).orElseThrow(()->new AddressException("address not found"));
		return address;
	}

	@Override
	public List<Address> getAllAddress() throws AddressException {
		List<Address> addresses = addressRepo.findAll();
		if(addresses.isEmpty())
			throw new AddressException("No address found");
		return addresses;
	}

	@Override
	public Address deleteAddressById(Long addressId) throws AddressException {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		User currentUser = userService.getUserByEmail(email);
		Address address = getAddressById(addressId);
		if(currentUser.getAddresses().contains(address))
			currentUser.getAddresses().remove(address);
		else 
			throw new AddressException("You can not delete this address");
		addressRepo.delete(address);
		return address;
	}

	@Override
	public Address updateAddress(Address address) throws AddressException {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		User currentUser = userService.getUserByEmail(email);
		Address address2 = getAddressById(address.getAddressId());
		if(!currentUser.getAddresses().contains(address2))
			throw new AddressException("You can not delete this address");
		address2.merge(address);
		Address savedAddress = addressRepo.save(address2);
		return savedAddress;
	}
	
	@Override
	public Address addAddressById(Address address) throws AddressException {
		if(address==null) throw new AddressException("not a valid exception!");
		
		Address savedAddress = addressRepo.save(address);
		return address;
	}

	

	

}
