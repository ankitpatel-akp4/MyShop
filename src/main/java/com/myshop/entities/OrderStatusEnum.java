package com.myshop.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class OrderStatusEnum {
	@Id
	private Byte orderStatusEmumId;
	private String orderStatusEmumName;
}
