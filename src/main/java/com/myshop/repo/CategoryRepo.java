/**
 * 
 */
package com.myshop.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myshop.entities.Category;

/**
 * @author indicate0
 *
 */
public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
