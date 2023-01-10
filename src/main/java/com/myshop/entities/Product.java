package com.myshop.entities;

import java.util.Map;

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
	private Integer productId;
	private String productName;
	private String description;
	private String productImage;
	@OneToOne
	private Category categoryId;
}
