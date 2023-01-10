package com.myshop.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Variation {
	@Id
	private Long variationId;
	private String variationName;
	@OneToOne
	private Category categoryId;
}
