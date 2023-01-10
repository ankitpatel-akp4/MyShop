package com.myshop.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Category {
	@Id
	private Integer categoryId;
	private Integer parentCategoryId;
	@ManyToOne(cascade = CascadeType.ALL)
	private Category categoryName;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Product> products;
}
