package com.myshop.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class OrderLine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderLineId;
	private Integer qty;
	private Double price;
	@OneToOne
	@JoinColumn(name = "productItemId")
	private ProductItem productItem;
	@OneToOne
	@JoinColumn(name = "orderId")
	private Orders orders;
	
}
