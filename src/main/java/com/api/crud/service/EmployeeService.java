package com.api.crud.service;

import com.api.crud.entity.EmployeeEntity;
import com.api.crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public ArrayList<EmployeeEntity> getEmployee(){
        return (ArrayList<EmployeeEntity>) employeeRepository.findAll();
    }

    public EmployeeEntity saveEmployee(EmployeeEntity employeeEntity){
        return employeeRepository.save(employeeEntity);
    }

    public Optional<EmployeeEntity> getById(Long id){
        return employeeRepository.findById(id);
    }

    public EmployeeEntity updateById(EmployeeEntity request, Long id){

        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();

        employeeEntity.setName(request.getName());
        employeeEntity.setLast_name(request.getLast_name());
        employeeEntity.setPhone_number(request.getPhone_number());
        employeeEntity.setAddress(request.getAddress());
        employeeEntity.setRole(request.getRole());
        employeeEntity.setEmail(request.getEmail());
        employeeEntity.setPassword(request.getPassword());

        employeeRepository.save(employeeEntity);

        return employeeEntity;
    }

    public Boolean deleteEmployee(Long id){
        try {
            employeeRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }


}
