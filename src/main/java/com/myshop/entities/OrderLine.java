package com.myshop.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class OrderLine {
	@Id
	private Long orderLineId;
	private Integer qty;
	private Double price;
	@OneToOne
	private ProductItem productItem;
	@OneToOne
	private Orders orders;
	
}
