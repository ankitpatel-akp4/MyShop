package com.myshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myshop.dto.productmapper.ProductReq;
import com.myshop.entities.Product;
import com.myshop.entities.ProductItem;
import com.myshop.service.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@PostMapping(value = "")
	public ResponseEntity<Product> addProduct(@RequestBody ProductReq productReq) {
		return new ResponseEntity<Product>(productService.addProduct(productReq),HttpStatus.CREATED);
	}
	@PutMapping(value = "")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		return new ResponseEntity<Product>(productService.updateProduct(product),HttpStatus.CREATED);
	}
	@DeleteMapping(value = "")
	public ResponseEntity<Product> updateProduct(@RequestParam Long productId) {
		return new ResponseEntity<Product>(productService.deleteProduct(productId),HttpStatus.CREATED);
	}
	
	@GetMapping(value = "")
	public ResponseEntity<List<Product>> getAllProduct() {
		return new ResponseEntity<List<Product>> (productService.getAllProduct(),HttpStatus.OK);
	}
	
	@GetMapping(value = "/items")
	public ResponseEntity<List<ProductItem>> getAllProductItem() {
		return new ResponseEntity<List<ProductItem>> (productService.getAllProductItem(),HttpStatus.OK);
	}

	
	@PatchMapping(value = "")
	public ResponseEntity<Product> addProductItem(@RequestParam Long productId, @RequestBody ProductItem productItem) {
		
		return new ResponseEntity<Product>(productService.addProductItem(productId, productItem),HttpStatus.OK);
	}
	

}
