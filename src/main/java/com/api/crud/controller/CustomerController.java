package com.api.crud.controller;

import com.api.crud.entity.CustomerEntity;
import com.api.crud.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ArrayList<CustomerEntity> getCustomer(){
        return this.customerService.getCustomer();
    }
    
    @PostMapping
    public CustomerEntity saveCustomer(@RequestBody CustomerEntity customerEntity){
        return this.customerService.saveCustomer(customerEntity);
    }

    @GetMapping(path = "/{id_customer}")
    public CustomerEntity updateCustomerById(@RequestBody CustomerEntity request, @PathVariable Long id){
        return this.customerService.updateById(request, id);
    }

    @DeleteMapping(path = "/{id_customer}")
    public String deleteById(@PathVariable("id_customer") Long id){
        boolean ok = this.customerService.deleteCustomer(id);

        if (ok){
            return "User with id " + id + " deleted!";
        } else {
            return "Error, we have a problem and can't delete user with id " +id;
        }
    }

}
