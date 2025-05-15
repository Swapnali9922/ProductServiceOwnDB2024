package com.example.productserviceowndb.controllers;

import com.example.productserviceowndb.dtos.createProductDtos;
import com.example.productserviceowndb.exceptions.ProductNotFoundException;
import com.example.productserviceowndb.models.Product;
import com.example.productserviceowndb.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class ProductController {
    @Autowired
    ProductService productService;
    //CreateNewProduct API
    @PostMapping("/products")
    public Product createProduct(@RequestBody createProductDtos requestDto) {
        return productService.createProduct(requestDto.getProductName(),requestDto.getProductDescription(),requestDto.getProductCategory());


    }

    //GetProductById Api
    @GetMapping("/products/{Id}")
    public Product getProductById(@PathVariable("Id") Integer id) throws ProductNotFoundException{
        return productService.getProductById(id);
    }


    //UpdateById api
    @PutMapping("/products/{id}")
    public Product updateProductById(@PathVariable("id") Integer id, @RequestBody createProductDtos dto) throws ProductNotFoundException{
        //return productService.updateProductById(id,dto.getProductName(),dto.getProductDescription(),dto.getProductCategory());
        return productService.updateProductById(id,dto);
    }

    //delete api
    @DeleteMapping("/products/{Id}")
    public String deleteProductById(@PathVariable("Id") Integer id) throws ProductNotFoundException{
        return productService.deleteProductById(id);
    }
}
