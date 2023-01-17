package com.myshop.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class OrderStatusEnum {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Byte orderStatusEmumId;
	private String orderStatusEmumName;
}
