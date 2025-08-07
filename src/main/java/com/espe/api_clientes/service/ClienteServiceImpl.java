package com.espe.api_clientes.service;

import com.espe.api_clientes.repository.ClienteRepository; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;
import com.espe.api_clientes.model.Cliente;

import java.util.List; 
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listarTodos() { 
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> obtenerPorId(Long id) { 
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente guardar(Cliente cliente) { 
        return clienteRepository.save(cliente);
    }

    @Override
    public void eliminar(Long id) { 
        clienteRepository.deleteById(id);
    }

}