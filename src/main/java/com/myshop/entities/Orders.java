package com.myshop.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Orders {
	@Id
	private Integer orderId;
	private LocalDateTime orderDateTime;
	private LocalDateTime deliveryDateTime;
	private Double totalAmount;
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	@OneToOne
	@JoinColumn(name = "payment_method_id")
	private PaymentMathod paymentMathod;
	@OneToOne
	private Address address;
	@OneToOne
	private ShippingMthod shippingMthod;
	
	
}
