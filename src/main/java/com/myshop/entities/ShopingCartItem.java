package com.myshop.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class ShopingCartItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long shopingCartItemId;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "shopingCartId")
	private ShopingCart shopingCart;

}
