package com.kalu.flo.service;

import com.kalu.flo.exceptions.NotFoundException;
import com.kalu.flo.model.ProductEntity;

import java.util.List;

public interface ProductService {

    List<ProductEntity> findAll();

    ProductEntity findById(Integer id) throws NotFoundException;

}
