package com.kalu.flo.controller;


import com.kalu.flo.exceptions.NotFoundException;
import com.kalu.flo.model.ProductEntity;
import com.kalu.flo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @GetMapping("/products/{id}")
    public ProductEntity findById(@PathVariable Integer id) throws NotFoundException {
        return productService.findById(id);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
    }

    @RequestMapping(value = "/uploadProduct", method = RequestMethod.POST, consumes = {   "multipart/form-data" })
    @ResponseBody
    public void addProduct(@RequestParam("imageFile") MultipartFile[] imageFiles, @RequestPart("productEntity") ProductEntity productEntity) throws IOException {
        productService.saveProduct(imageFiles,productEntity);

    }
}
