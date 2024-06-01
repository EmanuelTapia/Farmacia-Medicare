package com.api.crud.controller;

import com.api.crud.entity.CustomerEntity;
import com.api.crud.entity.EmployeeEntity;
import com.api.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/employee")
public class EmployeeContoller {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ArrayList<EmployeeEntity> getEmployee(){
        return this.employeeService.getEmployee();
    }

    @PostMapping
    public EmployeeEntity saveEmployee(@RequestBody EmployeeEntity employeeEntity){
        return this.employeeService.saveEmployee(employeeEntity);
    }

    @GetMapping(path = "/{id_employee}")
    public EmployeeEntity updateEmployeeById(@RequestBody EmployeeEntity request, @PathVariable Long id){
        return this.employeeService.updateById(request, id);
    }

    @DeleteMapping(path = "/{id_Employee}")
    public String deleteById(@PathVariable("id_employee") Long id){
        boolean ok = this.employeeService.deleteEmployee(id);

        if (ok){
            return "User with id " + id + " deleted!";
        } else {
            return "Error, we have a problem and can't delete user with id " +id;
        }
    }

}
