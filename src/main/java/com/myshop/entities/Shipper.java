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
public class Shipper {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer shipperId;
	private String companyName;
	@Column(unique = true)
	private String phone;
	@Column(unique = true)
	private String email;
	@OneToOne(mappedBy = "shipper")
	private Orders orders;
}
