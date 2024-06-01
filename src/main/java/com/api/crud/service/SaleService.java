package com.api.crud.service;

import com.api.crud.entity.ProductEntity;
import com.api.crud.entity.SaleEntity;
import com.api.crud.repository.ProductRepository;
import com.api.crud.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class SaleService {

    @Autowired
    SaleRepository saleRepository;

    public ArrayList<SaleEntity> getSale(){
        return (ArrayList<SaleEntity>) saleRepository.findAll();
    }

    public SaleEntity saveSale(SaleEntity saleEntity){
        return saleRepository.save(saleEntity);
    }

    public Optional<SaleEntity> getById(Long id){
        return saleRepository.findById(id);
    }

    public SaleEntity updateById(SaleEntity request, Long id){

        SaleEntity saleEntity = saleRepository.findById(id).get();

        saleEntity.setDate(request.getDate());
        saleEntity.setTotal(request.getTotal());

        saleRepository.save(saleEntity);

        return saleEntity;
    }

    public Boolean deleteSale(Long id){
        try {
            saleRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
