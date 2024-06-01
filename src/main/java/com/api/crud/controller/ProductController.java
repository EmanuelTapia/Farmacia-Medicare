package com.api.crud.controller;

import com.api.crud.entity.ProductEntity;
import com.api.crud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ArrayList<ProductEntity> getProduct(){
        return this.productService.getProduct();
    }

    @PostMapping
    public ProductEntity saveProduct(@RequestBody ProductEntity productEntity){
        return this.productService.saveProduct(productEntity);
    }

    @GetMapping(path = "/{id_product}")
    public ProductEntity updateProductById(@RequestBody ProductEntity request, @PathVariable Long id){
        return this.productService.updateById(request, id);
    }

    @DeleteMapping(path = "/{id_product}")
    public String deleteById(@PathVariable("id_product") Long id){
        boolean ok = this.productService.deleteProduct(id);

        if (ok){
            return "User with id " + id + " deleted!";
        } else {
            return "Error, we have a problem and can't delete user with id " +id;
        }
    }

}


