/**
 * 
 */
package com.myshop.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myshop.entities.Product;

/**
 * @author indicate0
 *
 */
public interface ProductRepo extends JpaRepository<Product, Long>{

}
