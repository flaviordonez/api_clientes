package com.espe.api_clientes.service;

import com.espe.api_clientes.model.Cliente;
import java.util.List; 
import java.util.Optional;

public interface ClienteService { 
    List<Cliente> listarTodos(); 
    Optional<Cliente> obtenerPorId(Long id); 
    Cliente guardar(Cliente cliente);
    void eliminar(Long id);
}
