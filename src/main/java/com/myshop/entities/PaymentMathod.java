package com.myshop.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class PaymentMathod {
	@Id
	private Long paymentMethodId;
	private String provider;
	private String accountNumber;
	private LocalDate expiryDate;
	private Boolean isDefault;
	@OneToOne
	@JoinColumn(name = "payment_type_id")
	private PaymentType paymentType;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
}
