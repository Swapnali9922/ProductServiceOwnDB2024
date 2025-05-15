package com.example.productserviceowndb.services;


import com.example.productserviceowndb.dtos.createProductDtos;
import com.example.productserviceowndb.exceptions.ProductNotFoundException;
import com.example.productserviceowndb.models.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
      Product createProduct(String name,String description,String category);
      Product getProductById(Integer id) throws ProductNotFoundException;
      Product updateProductById(Integer id, createProductDtos dto) throws ProductNotFoundException;
}
