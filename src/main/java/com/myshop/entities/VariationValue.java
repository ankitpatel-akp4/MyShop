package com.myshop.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class VariationValue {
	@Id
	private Long variationValueId;
	private String value;
	@OneToOne
	private Variation variationId;
}
