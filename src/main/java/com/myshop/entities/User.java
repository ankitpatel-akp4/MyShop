package com.myshop.entities;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
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
import javax.validation.constraints.Email;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name = "users")
public class User{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private String email;
	private String username;
	private String firstName;
	private String lastName;
	private String roles;
	private String password;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private boolean enabled;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "users_address", joinColumns = @JoinColumn(referencedColumnName = "userId"),inverseJoinColumns = @JoinColumn(referencedColumnName = "addressId"))
	private Set<Address> addresses = new HashSet<>();
	@OneToMany(cascade = CascadeType.ALL)
	private Set<PaymentMathod> paymentMathods = new HashSet<>();
	@OneToOne
	private ShopingCart shopingCart;
	@OneToMany
	private Set<Review> reviews = new HashSet<>();
	
	
}
