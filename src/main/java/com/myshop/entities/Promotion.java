package com.myshop.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Promotion {
	@Id
	private Long promotionId;
	private String promotionName;
	private String description;
	private Float discountRate;
	private LocalDateTime startDateTime;
	private LocalDateTime endDateTime;
	@ManyToMany
	@JoinColumn(name = "shoping_cart")
	private Set<Category> categories = new HashSet<>();
}
