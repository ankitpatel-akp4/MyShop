package com.myshop.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	private String productName;
	private String brand;
	private String price;
	private String description;
	private float rating;
	private Integer noRatings;
	@OneToOne(mappedBy = "product")
	private OrderDetails orderDetails;
	@ManyToOne
	private Category category;
}
