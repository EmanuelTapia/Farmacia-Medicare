package com.api.crud.service;


import com.api.crud.entity.Cliente;
import com.api.crud.repository.ClientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClientDAO clienteDAO;

    public ArrayList<Cliente> getClient(){
        return (ArrayList<Cliente>)  clienteDAO.findAll();
    }

    public Cliente saveClient(Cliente cliente){
        return clienteDAO.save(cliente);
    }

    public Optional<Cliente> getById(Long id){
        return clienteDAO.findById(id);
    }

    public Cliente updateByID(Cliente request, Long id ){
        Cliente cliente = clienteDAO.findById(id).get();

        cliente.setNombre(request.getNombre());
        cliente.setApellido(request.getApellido());
        cliente.setDni(request.getDni());
        cliente.setFechanacimiento(request.getFechanacimiento());
        cliente.setTelefono(request.getTelefono());
        cliente.setDireccion(request.getDireccion());

        clienteDAO.save(cliente);

        return cliente;
    }

    public Boolean deleteClient(Long id){
        try {
            clienteDAO.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
