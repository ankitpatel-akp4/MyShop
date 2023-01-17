package com.myshop.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class Promotion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
