package com.myshop.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class PaymentType {
	@Id
	private Byte paymentTypeId;
	private String value;
}
