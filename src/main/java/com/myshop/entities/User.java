package com.myshop.entities;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name = "users")
@ToString
public class User{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	private String email;
	private String mobile;
	private String firstName;
	private String lastName;
	private String roles;
	private String password;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private boolean enabled;
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "users_address", joinColumns = @JoinColumn(name = "userId"),inverseJoinColumns = @JoinColumn(name = "addressId"))
	private Set<Address> addresses = new HashSet<>();
//	@JsonIgnore
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "paymentMethodId")
//	private Set<PaymentMethod> paymentMathods = new HashSet<>();
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "userId")
	@JoinColumn(name = "shopingCartId")
	private ShopingCart shopingCart;
//	@JsonIgnore
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "reviewId")
//	private Set<Review> reviews = new HashSet<>();
	
	public void merge(User user) {
		if(user.getEmail() != null)
			this.email = user.getEmail();
		if(user.getMobile() != null)
			this.mobile = user.getMobile();
		if(user.getFirstName() != null)
			this.firstName = user.getFirstName();
		if(user.getLastName() != null)
			this.lastName = user.getLastName();
		
	}
}
