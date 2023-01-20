package com.myshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myshop.entities.Orders;
import com.myshop.service.OrderService;

@RestController
@RequestMapping(value = "orders")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@PostMapping
	public ResponseEntity<Orders> placeOrder(@RequestBody Orders orders){
				
		return new ResponseEntity<Orders>(orderService.placeOrder(orders),HttpStatus.CREATED);
	}
	@DeleteMapping
	public ResponseEntity<Orders> deleteOrder(@RequestParam Long orderId){
		
		return new ResponseEntity<Orders>(orderService.deleteOrdersById(orderId),HttpStatus.OK);
	}
	@GetMapping(value = "/{orderId}")
	public ResponseEntity<Orders> getOrderById(@RequestParam Long orderId){
		
		return new ResponseEntity<Orders>(orderService.getOrdersById(orderId),HttpStatus.FOUND);
	}
	@GetMapping
	public ResponseEntity<List<Orders>> getAllOrde(){
		
		return new ResponseEntity<List<Orders>>(orderService.getAllOrders(),HttpStatus.FOUND);
	}
	
}
