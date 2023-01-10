package com.myshop.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class OrderStaus {
	@Id
	private Long orderStatusId;
	private LocalDateTime dateTime;
	private Boolean isCurrentStatus;
	@ManyToOne
	private Orders orders;
	@OneToOne
	private OrderStatusEnum orderStatusEnum;
}
