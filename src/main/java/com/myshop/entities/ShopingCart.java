package com.myshop.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class ShopingCart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long shopingCartId;
	@OneToOne
	@JsonIgnore
	@JoinColumn(name = "userId")
	private User user;
	@ManyToMany
	@JoinTable(name = "shoping_cart_item", joinColumns = @JoinColumn(name = "shopingCartId"),inverseJoinColumns = @JoinColumn(name = "productItemId"))
	private Set<ProductItem> productItems = new HashSet<>();
}
