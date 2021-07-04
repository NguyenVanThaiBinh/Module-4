package com.example.demo.service;


import com.example.demo.model.Product;
import com.example.demo.model.Province;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProduct(){
        List<Product> productList = productRepository.findAll();
        if(productList.size() > 0) {
            return productList;
        } else {
            return new ArrayList<Product>();
        }

    }

    public Product findById(long parseLong){

        Product product = productRepository.getById(parseLong);
        return  product;
    }
}
