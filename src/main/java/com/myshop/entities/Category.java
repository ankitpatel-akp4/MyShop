package com.myshop.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoryId;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "parentCategoryId")
	private Category parentCategory;
	private String categoryName;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "category")
	@JsonIgnore
	private List<Product> products;
}
