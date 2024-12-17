package com.sistemavendas.SistemaVendas.controller;

import com.sistemavendas.SistemaVendas.dto.ClienteDTO;
import com.sistemavendas.SistemaVendas.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@CrossOrigin("*")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<ClienteDTO> getAllClientes(){
        return clienteService.getAllCliente();
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> createCliente(@RequestBody ClienteDTO clienteDTO) {

        ClienteDTO createdCliente = clienteService.createCliente(clienteDTO);
        return ResponseEntity.ok(createdCliente);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> updateCliente(@PathVariable Long id, @RequestBody ClienteDTO updatedClienteDTO) {

        ClienteDTO updateCliente = clienteService.updateCliente(id, updatedClienteDTO);
        return ResponseEntity.ok(updateCliente);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {

        clienteService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
