package com.kalu.flo.controller;


import com.kalu.flo.exceptions.NotFoundException;
import com.kalu.flo.model.ProductEntity;
import com.kalu.flo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<ProductEntity> getAllProducts(){
        return productService.findAll();
    }

    @GetMapping("/product/{id}")
    public ProductEntity findById(@PathVariable Integer id) throws NotFoundException {
        return productService.findById(id);
    }
}
