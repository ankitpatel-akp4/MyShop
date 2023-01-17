package com.myshop.dto.productmapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.myshop.dto.usermapper.UserMapper;
import com.myshop.entities.Product;

@Mapper
public interface ProductMapper {
	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
	Product productReqToProduct(ProductReq productReq);
	
}
