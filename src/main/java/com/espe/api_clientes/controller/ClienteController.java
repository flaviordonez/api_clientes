package com.espe.api_clientes.controller;
import com.espe.api_clientes.model.Cliente;
import com.espe.api_clientes.service.ClienteService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI; import java.util.List;

@RestController
@RequestMapping("api/clientes")
@CrossOrigin(origins = "*") // permite llamadas desde el frontend 

public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    // GET /api/clientes
    @GetMapping("/test") 
    public String test() {
        return "Funciona";
    }

    @GetMapping
    public List<Cliente> listarTodos() { 
        return clienteService.listarTodos();
    }

    // GET /api/clientes/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtenerPorId(@PathVariable Long id) { 
        return clienteService.obtenerPorId(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/clientes
    @PostMapping
    public ResponseEntity<Cliente> crear(@Valid @RequestBody Cliente cliente) { 
        Cliente creado = clienteService.guardar(cliente);
        return ResponseEntity.created(URI.create("/api/clientes/" + creado.getId())).body(creado);
    }

    // PUT /api/clientes/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizar(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
        return clienteService.obtenerPorId(id)
        .map(c -> {
        c.setCi(cliente.getCi());
        c.setNombres(cliente.getNombres());
        c.setApellidos(cliente.getApellidos());
        c.setDireccion(cliente.getDireccion());
        // agrega aquí más campos si tu entidad Cliente tiene más
        return ResponseEntity.ok(clienteService.guardar(c));
        })
        .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/clientes/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) { 
        if (clienteService.obtenerPorId(id).isPresent()) {
        clienteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
    }
}
