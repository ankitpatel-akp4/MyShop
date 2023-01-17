package com.myshop.dto.productmapper;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.myshop.entities.Category;

import lombok.Data;
@Data
public class ProductReq {
	private Long productId;
	private String productName;
	private String description;
	private String productImage;
	private Category category;
}
