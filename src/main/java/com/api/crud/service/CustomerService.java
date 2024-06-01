package com.api.crud.service;

import com.api.crud.entity.CustomerEntity;
import com.api.crud.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public ArrayList<CustomerEntity> getCustomer(){
        return (ArrayList<CustomerEntity>) customerRepository.findAll();
    }

    public CustomerEntity saveCustomer(CustomerEntity customerEntity){
        return customerRepository.save(customerEntity);
    }

    public Optional<CustomerEntity> getById(Long id){
        return customerRepository.findById(id);
    }

    public CustomerEntity updateById(CustomerEntity request, Long id){

        CustomerEntity customerEntity = customerRepository.findById(id).get();

        customerEntity.setName(request.getName());
        customerEntity.setLast_name(request.getLast_name());
        customerEntity.setDni(request.getDni());
        customerEntity.setBirthdate(request.getBirthdate());
        customerEntity.setPhone_number(request.getPhone_number());
        customerEntity.setAddress(request.getAddress());

        customerRepository.save(customerEntity);

        return customerEntity;
    }

    public Boolean deleteCustomer(Long id){
        try {
            customerRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
