package com.espe.api_clientes.repository;

import com.espe.api_clientes.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
// Puedes agregar métodos personalizados aquí si los necesitas más adelante
}
