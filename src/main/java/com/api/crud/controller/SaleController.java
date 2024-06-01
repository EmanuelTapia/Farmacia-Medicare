package com.api.crud.controller;

import com.api.crud.entity.ProductEntity;
import com.api.crud.entity.SaleEntity;
import com.api.crud.service.ProductService;
import com.api.crud.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/sale")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping
    public ArrayList<SaleEntity> getSale(){
        return this.saleService.getSale();
    }

    @PostMapping
    public SaleEntity saveSale(@RequestBody SaleEntity saleEntity){
        return this.saleService.saveSale(saleEntity);
    }

    @GetMapping(path = "/{id_sale}")
    public SaleEntity updateSaleById(@RequestBody SaleEntity request, @PathVariable Long id){
        return this.saleService.updateById(request, id);
    }

    @DeleteMapping(path = "/{id_sale}")
    public String deleteById(@PathVariable("id_sale") Long id){
        boolean ok = this.saleService.deleteSale(id);

        if (ok){
            return "User with id " + id + " deleted!";
        } else {
            return "Error, we have a problem and can't delete user with id " +id;
        }
    }

}
