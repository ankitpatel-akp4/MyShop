package com.myshop.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ShippingMthod {
	@Id
	private Byte shippingMethodId;
	private String shippingMethodName;
	private Double price;
	
}
