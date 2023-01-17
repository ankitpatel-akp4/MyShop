package com.myshop.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reviewId;
	private LocalDateTime dateTime;
	private LocalDateTime lastEditDateTime;
	private Byte rating;
	private String comment;
	@ManyToOne
	@JoinColumn(name = "userId")
	@JsonIgnore
	private User user;
	@OneToOne
	@JoinColumn(name = "orderLineId")
	private OrderLine orderLine;
	
}
