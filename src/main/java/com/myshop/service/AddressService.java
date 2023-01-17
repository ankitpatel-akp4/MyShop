package com.myshop.service;

import java.util.List;

import com.myshop.entities.Address;
import com.myshop.exception.AddressException;

public interface AddressService {
	public Address addAddressById(Address address) throws AddressException;
	public Address getAddressById(Long addressId) throws AddressException;
	public List<Address> getAllAddress() throws AddressException;
	public Address deleteAddressById(Long addressId) throws AddressException;
	public Address updateAddress(Address address) throws AddressException;
}
