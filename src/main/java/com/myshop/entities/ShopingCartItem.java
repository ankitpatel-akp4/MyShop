package com.myshop.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class ShopingCartItem {
	@Id
	private Long shopingCartItemId;
	@ManyToOne
	@JoinColumn(name = "shoping_cart_id")
	private ShopingCart shopingCart;
	@ManyToMany
	@JoinColumn(name = "product_item_id")
	private Set<ProductItem> productItems = new HashSet<>();
}
