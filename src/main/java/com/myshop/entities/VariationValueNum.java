package com.myshop.entities;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
public class VariationValueNum {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long variationValueNumId;
	private Double value;
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
		VariationValueNum other = (VariationValueNum) obj;
		return Objects.equals(variationValueNumId, other.variationValueNumId);
	}
	@Override
	public int hashCode() {
		return Objects.hash(variationValueNumId);
	}
}
