package com.api.crud.controller;


import com.api.crud.entity.Cliente;
import com.api.crud.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping
    public ArrayList<Cliente> getClient(){
        return this.clienteService.getClient();
    }

    @PostMapping
    public Cliente saveClient(@RequestBody Cliente cliente){
        return this.clienteService.saveClient(cliente);
    }

    @GetMapping(path = "/{idCliente}")
    public Optional<Cliente> getUserById(@PathVariable Long id){
        return this.clienteService.getById(id);
    }

    @PutMapping(path = "{idCliente}")
    public Cliente updateUserById(@RequestBody Cliente request ,@PathVariable Long id){
        return this.clienteService.updateByID(request, id);
    }

    @DeleteMapping(path = "/{idCliente}")
    public String deleteById(@PathVariable("idCliente") Long id){
        boolean ok = this.clienteService.deleteClient(id);

        if (ok){
            return "User with id " + id + " deleted!";
        } else {
            return "Error, we have a problem and can't delete user with id " +id;
        }
    }
}
