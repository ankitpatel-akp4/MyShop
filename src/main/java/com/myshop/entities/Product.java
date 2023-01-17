package com.myshop.entities;

import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	private String productName;
	private String description;
	private String productImage;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "categoryId")
	private Category category;
	@OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
	private Set<ProductItem> productItems = new HashSet<>();
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(productId, other.productId) && Objects.equals(productName, other.productName);
	}
	@Override
	public int hashCode() {
		return Objects.hash(productId, productName);
	}
	
}
