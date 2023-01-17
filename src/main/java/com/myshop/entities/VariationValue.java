package com.myshop.entities;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
public class VariationValue {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long variationValueId;
	private String value;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "variationId")
	private Variation variation;
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VariationValue other = (VariationValue) obj;
		return Objects.equals(variationValueId, other.variationValueId);
	}
	@Override
	public int hashCode() {
		return Objects.hash(variationValueId);
	}
}
