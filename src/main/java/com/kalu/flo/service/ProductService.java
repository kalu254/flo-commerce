package com.kalu.flo.service;

import com.kalu.flo.exceptions.NotFoundException;
import com.kalu.flo.model.ProductEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    List<ProductEntity> findAll();

    ProductEntity findById(Integer id) throws NotFoundException;

    void saveProduct(MultipartFile[] imageFiles, ProductEntity productEntity) throws IOException;

    void deleteProduct(int id);
}
