package com.myshop.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myshop.entities.ProductItem;

public interface ProductItemRepo extends JpaRepository<ProductItem, Long>{

}
