package com.myshop.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class ProductItem {
	@Id
	private Long productItemId;
	private String sku;
	private Long qtyInStock;
	private String productItemImage;
	private Double salePrice;
	private Double marketPrice;
	@OneToOne
	private Product productId;
	@ManyToMany
	private Set<VariationValue> productValueId = new HashSet<>();
	@ManyToMany
	private Set<VariationValueNum> productValueNumId = new HashSet<>();
}
