package com.myshop.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Supplier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer supplierId;
	private String companyName;
	@Column(unique = true)
	private String email;
	@Column(unique = true)
	private String phone;
	
	@OneToOne(mappedBy = "supplier")
	private OrderDetails orderDetails;
}
