package com.myshop.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Review {
	@Id
	private Long reviewId;
	private LocalDateTime dateTime;
	private LocalDateTime lastEditDateTime;
	private Byte rating;
	private String comment;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	@OneToOne
	private OrderLine orderLine;
	
}
