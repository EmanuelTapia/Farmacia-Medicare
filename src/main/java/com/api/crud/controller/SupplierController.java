package com.api.crud.controller;

import com.api.crud.entity.ProductEntity;
import com.api.crud.entity.SupplierEntity;
import com.api.crud.service.ProductService;
import com.api.crud.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public ArrayList<SupplierEntity> getSupplier(){
        return this.supplierService.getSupplier();
    }

    @PostMapping
    public SupplierEntity saveSupplier(@RequestBody SupplierEntity supplierEntity){
        return this.supplierService.saveSupplier(supplierEntity);
    }

    @GetMapping(path = "/{id_supplier}")
    public SupplierEntity updateSupplierById(@RequestBody SupplierEntity request, @PathVariable Long id){
        return this.supplierService.updateById(request, id);
    }

    @DeleteMapping(path = "/{id_supplier}")
    public String deleteById(@PathVariable("id_supplier") Long id){
        boolean ok = this.supplierService.deleteSupplier(id);

        if (ok){
            return "User with id " + id + " deleted!";
        } else {
            return "Error, we have a problem and can't delete user with id " +id;
        }
    }

}
