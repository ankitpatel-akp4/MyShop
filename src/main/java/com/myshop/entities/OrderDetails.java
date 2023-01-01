package com.myshop.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class OrderDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderDetailsId;
	private Integer quantity;
	@OneToOne(mappedBy = "orderDetails")
	private Orders orders;
	@OneToOne
	private Product product;
	@OneToOne
	private Supplier supplier;
}
