package com.myshop.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
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
import lombok.ToString;

@Entity
@Data
public class ProductItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productItemId;
	private String sku;
	private Long qtyInStock;
	private String productItemImage;
	private Double salePrice;
	private Double marketPrice;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "productId")
	@JsonIgnore
	private Product product;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "product_config", joinColumns = @JoinColumn(name = "productItemId"),inverseJoinColumns = @JoinColumn(name ="variationValueId"))
	private Set<VariationValue> variationValues = new HashSet<>();
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "product_config_num", joinColumns = @JoinColumn(name = "productItemId"),inverseJoinColumns = @JoinColumn(name ="variationValueNumId"))
	private Set<VariationValueNum> variationValueNums = new HashSet<>();
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductItem other = (ProductItem) obj;
		return Objects.equals(productItemId, other.productItemId) && Objects.equals(sku, other.sku);
	}
	@Override
	public int hashCode() {
		return Objects.hash(productItemId, sku);
	}
	
	
}
