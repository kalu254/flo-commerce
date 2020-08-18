package com.kalu.flo.service;

import com.kalu.flo.exceptions.NotFoundException;
import com.kalu.flo.model.ProductEntity;
import com.kalu.flo.repository.ProductEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductEntityRepository productEntityRepository;

    @Autowired
    public ProductServiceImpl(ProductEntityRepository productEntityRepository) {
        this.productEntityRepository = productEntityRepository;
    }

    @Override
    public List<ProductEntity> findAll() {
        return productEntityRepository.findAll();
    }

    @Override
    public ProductEntity findById(Integer id) throws NotFoundException {
        return productEntityRepository.findById(id).
            orElseThrow(()->new NotFoundException("Product not found"));
    }
}
