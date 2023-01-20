package com.myshop.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.myshop.entities.Orders;
import com.myshop.entities.ProductItem;
import com.myshop.entities.User;
import com.myshop.exception.ProductException;
import com.myshop.repo.OrdersRepo;

@Service
public class OrderService {
	@Autowired
	private OrdersRepo ordersRepo;
	@Autowired
	private AddressService addressService;
	@Autowired
	private UserService userService;
	@Autowired 
	ProductService productService;
	
	
	
	public Orders placeOrder(Orders orders){
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		User currentUser = userService.getUserByEmail(email);
		orders.setAddress(addressService.getAddressById(orders.getAddress().getAddressId()));
		ProductItem productItem = productService.getProductItemById(orders.getProductItem().getProductItemId());
		if(productItem.getQtyInStock()>1) {
			productItem.setQtyInStock(productItem.getQtyInStock()-1);
		}else {
			throw new ProductException("Sorry, there is not enough stock in the store");
		}
		orders.setUser(currentUser);
		orders.setOrderDateTime(LocalDateTime.now());
		orders.setPaymentMathod(null);
		orders.setProductItem(productItem);
		orders.setShippingMthod(null);
		orders.setTotalAmount(orders.getProductItem().getSalePrice());
		return ordersRepo.save(orders);
	}
	public List<Orders> getAllOrders(){
		List<Orders> orders = ordersRepo.findAll();
		if(orders.isEmpty()) throw new ProductException("no oder is placed yet...");
		return orders;
	}
	public Orders getOrdersById(Long orderId){
		 
		
		return ordersRepo.findById(orderId).orElseThrow(()-> new ProductException("no order is placed by the id: "+orderId));
	}
	
	public Orders deleteOrdersById(Long orderId){
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		User currentUser = userService.getUserByEmail(email);
		Orders orders = getOrdersById(orderId);
		ProductItem productItem = productService.getProductItemById(orders.getProductItem().getProductItemId());
		if(orders.getUser().getEmail().equals(currentUser.getEmail())) {
			if(productItem.getQtyInStock()>1) {
				productItem.setQtyInStock(productItem.getQtyInStock()+1);
			}else {
				throw new ProductException("Sorry, there is not enough stock in the store");
			}
		}
		return orders;
		
	}
	
}
