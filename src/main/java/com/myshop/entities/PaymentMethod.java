package com.myshop.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
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
public class PaymentMethod {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paymentMethodId;
	private String provider;
	private String accountNumber;
	private LocalDate expiryDate;
	private Boolean isDefault;
	@OneToOne
	@JoinColumn(name = "paymentTypeId")
	private PaymentType paymentType;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	@JsonIgnore
	private User user;
}
