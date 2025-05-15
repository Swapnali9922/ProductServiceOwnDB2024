package com.example.productserviceowndb.services;

import com.example.productserviceowndb.dtos.createProductDtos;
import com.example.productserviceowndb.exceptions.ProductNotFoundException;
import com.example.productserviceowndb.models.Product;
import com.example.productserviceowndb.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
           ProductRepository productRepository;

    @Override
    public Product createProduct(String name, String description, String category) {
      Product p=productRepository.findFirstByName(name);
        if(p!=null)
            return p;
        Product product=new Product();

        product.setName(name);
        product.setDescription(description);
        product.setCategory(category);
        product=productRepository.save(product);
        return product;

    }

    @Override
    public Product getProductById(Integer id)  throws ProductNotFoundException {
        Optional<Product> p=productRepository.findById(id);

        if(p.isEmpty())
            throw new ProductNotFoundException("product not found");
        return p.get();


}

    @Override
    public Product updateProductById(Integer id, createProductDtos dto) throws ProductNotFoundException {

             Optional<Product> p= productRepository.findById(id);
             if(p.isEmpty())
                 throw new ProductNotFoundException("product not found");
             Product p1=p.get();
             p1.setName(dto.getProductName());
             p1.setDescription(dto.getProductDescription());
             p1.setCategory(dto.getProductCategory());
             p1=productRepository.save(p1);
             return p1;
    }

    @Override
    public String deleteProductById(Integer id) throws ProductNotFoundException {
        Optional<Product> p=productRepository.findById(id);
        if(p.isEmpty())
            return "product not found";
        productRepository.deleteById(id);
        return "product deleted";
    }


}
