package com.myshop.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class ShopingCart {
	@Id
	private Long shopingCartId;
	@OneToOne
	private User userId;
	@OneToMany
	private Set<ShopingCartItem> shopingCartItem = new HashSet<>();
}
