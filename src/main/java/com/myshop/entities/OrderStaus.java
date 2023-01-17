package com.myshop.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class OrderStaus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderStatusId;
	private LocalDateTime dateTime;
	private Boolean isCurrentStatus;
	@ManyToOne
	@JoinColumn(name = "orderId")
	private Orders orders;
	@ManyToOne
	@JoinColumn(name = "orderStatusEmumId")
	private OrderStatusEnum orderStatusEnum;
}
