package com.api.crud.service;

import com.api.crud.entity.ProductEntity;
import com.api.crud.entity.SupplierEntity;
import com.api.crud.repository.ProductRepository;
import com.api.crud.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    public ArrayList<SupplierEntity> getSupplier(){
        return (ArrayList<SupplierEntity>) supplierRepository.findAll();
    }

    public SupplierEntity saveSupplier(SupplierEntity supplierEntity){
        return supplierRepository.save(supplierEntity
        );
    }

    public Optional<SupplierEntity> getById(Long id){
        return supplierRepository.findById(id);
    }

    public SupplierEntity updateById(SupplierEntity request, Long id){

        SupplierEntity supplierEntity = supplierRepository.findById(id).get();

        supplierEntity.setName(request.getName());
        supplierEntity.setRuc(request.getRuc());
        supplierEntity.setPhone_number(request.getPhone_number());
        supplierEntity.setEmail(request.getEmail());
        supplierEntity.setAddress(request.getAddress());

        supplierRepository.save(supplierEntity);

        return supplierEntity;
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
