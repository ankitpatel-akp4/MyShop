package com.myshop.repo;

import javax.persistence.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myshop.entities.Orders;

@Repository
public interface OrdersRepo extends JpaRepository<Orders, Long>{
	
}
