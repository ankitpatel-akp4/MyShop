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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	private LocalDateTime orderDateTime;
	private LocalDateTime deliveryDateTime;
	private Double totalAmount;
	@OneToOne
	@JoinColumn(name = "userId")
	@JsonIgnore
	private User user;
	@OneToOne
	@JoinColumn(name = "paymentMethodId")
	private PaymentMethod paymentMathod;
	@OneToOne
	@JoinColumn(name = "shippingAddressId")
	private Address address;
	@OneToOne
	@JoinColumn(name = "shippingMethodId")
	private ShippingMthod shippingMthod;
	
	
}
