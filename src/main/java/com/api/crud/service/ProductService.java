package com.api.crud.service;

import com.api.crud.entity.ProductEntity;
import com.api.crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ArrayList<ProductEntity> getProduct(){
        return (ArrayList<ProductEntity>) productRepository.findAll();
    }

    public ProductEntity saveProduct(ProductEntity productEntity){
        return productRepository.save(productEntity);
    }

    public Optional<ProductEntity> getById(Long id){
        return productRepository.findById(id);
    }

    public ProductEntity updateById(ProductEntity request, Long id){

        ProductEntity productEntity = productRepository.findById(id).get();

        productEntity.setId_supplier(request.getId_supplier());
        productEntity.setName(request.getName());
        productEntity.setDescription(request.getDescription());
        productEntity.setType(request.getType());
        productEntity.setStock(request.getStock());
        productEntity.setPrice(request.getPrice());

        productRepository.save(productEntity);

        return productEntity;
    }

    public Boolean deleteProduct(Long id){
        try {
            productRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
