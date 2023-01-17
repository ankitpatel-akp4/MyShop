package com.myshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.dto.productmapper.ProductMapper;
import com.myshop.dto.productmapper.ProductReq;
import com.myshop.entities.Product;
import com.myshop.entities.ProductItem;
import com.myshop.exception.ProductException;
import com.myshop.repo.CategoryRepo;
import com.myshop.repo.ProductItemRepo;
import com.myshop.repo.ProductRepo;
import com.myshop.repo.VariationValueNumRepo;
import com.myshop.repo.VariationValueRepo;

@Service
public class ProductService {
	@Autowired
	private ProductRepo productRepo;
	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	private ProductItemRepo productItemRepo;
	@Autowired
	private VariationValueRepo valueRepo;
	@Autowired
	private VariationValueNumRepo valueNumRepo;
	
	public Product addProduct(ProductReq productReq) {
		if(productReq == null) throw new ProductException("not a valid product");
		Product product = ProductMapper.INSTANCE.productReqToProduct(productReq);
		return productRepo.save(product);
	}
	public Product getProductById(Long productId) {
		
		return productRepo.findById(productId).orElseThrow((() -> new ProductException("Product not found with id: "+productId)));
	}
	public Product updateProduct(Product product) {
		getProductById(product.getProductId());
		for(ProductItem pe : product.getProductItems()) {
			pe.setProduct(product);
		}
		return productRepo.save(product);
	}
	public Product deleteProduct(Long productId) {
		Product product = getProductById(productId);
		product.setCategory(null);
		for(ProductItem pe : product.getProductItems()) {
			pe.getVariationValueNums().clear();
			pe.getVariationValues().clear();
		}
		productRepo.delete(product);
		return product;
	}
	public Product addProductItem(Long productId, ProductItem productItem) {
		if(productItem == null) throw new ProductException("not a valid product");
		Product product = productRepo.findById(productId).orElseThrow(()-> new ProductException("product not fount with id: "+productId));
		product.getProductItems().add(productItem);
		productItem.setProduct(product);
		return productRepo.save(product);
	}
	public List<Product> getAllProduct() {
		List<Product> products = productRepo.findAll();
		if(products.isEmpty()) throw new ProductException("no product found in the database");
		return products;
	}
	public List<ProductItem> getAllProductItem() {
		List<ProductItem> productItems = productItemRepo.findAll();
		if(productItems.isEmpty()) throw new ProductException("no product found in the database");
		return productItems;
	}
	public ProductItem getAllProductItemById(Long productItemId) {
		ProductItem productItem = productItemRepo.findById(productItemId).orElseThrow(()->new ProductException("no prduct item fount with id: "+productItemId));
		
		return productItem;
	}
}
