package com.myshop.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.myshop.auth.User;

import lombok.Data;

@Entity
@Data
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	private LocalDateTime orderDateTime;
	private LocalDateTime shipDate;
	private LocalDateTime deliveryDate;
	private Double totalAmount;
	
	
	@ManyToOne
	private User user;
	@OneToOne
	private Payment payment;
	@OneToOne
	private OrderDetails orderDetails;
	@OneToOne
	private Shipper shipper;
	
	
}
