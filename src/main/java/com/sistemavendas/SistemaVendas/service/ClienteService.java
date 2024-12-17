package com.sistemavendas.SistemaVendas.service;

import com.sistemavendas.SistemaVendas.dto.ClienteDTO;
import com.sistemavendas.SistemaVendas.entity.Cliente;
import com.sistemavendas.SistemaVendas.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    private ClienteDTO convertToDTO(Cliente cliente){
        return new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), cliente.getEndereco());
    }

    private Cliente convertToEntity(ClienteDTO clienteDTO){
        Cliente cliente = new Cliente();
        cliente.setNome(clienteDTO.getNome());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setTelefone(clienteDTO.getTelefone());
        cliente.setEndereco(clienteDTO.getEndereco());
        return cliente;
    }

    private void validateUserDTO(ClienteDTO clienteDTO) {
        if (clienteDTO.getNome() == null || clienteDTO.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("O campo 'NOME' não pode estar vazio.");
        }
        if (clienteDTO.getEmail() == null || clienteDTO.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("O campo 'EMAIL' não pode estar vazio.");
        }
        if(clienteDTO.getTelefone() == null || clienteDTO.getTelefone().trim().isEmpty()){
            throw new IllegalArgumentException("O campo 'TELEFONE' não pode estar vazio.");
        }
    }

    public ClienteDTO createCliente(ClienteDTO clienteDTO) {
        validateUserDTO(clienteDTO);
        Cliente cliente = convertToEntity(clienteDTO);
        Cliente savedCliente = clienteRepository.save(cliente);
        return convertToDTO(savedCliente);
    }

    public List<ClienteDTO> getAllCliente() {
        return clienteRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ClienteDTO updateCliente(Long id, ClienteDTO updatedClienteDTO) {
        validateUserDTO(updatedClienteDTO);

        return clienteRepository.findById(id)
                .map(existingCliente -> {
                    existingCliente.setNome(updatedClienteDTO.getNome());
                    existingCliente.setEmail(updatedClienteDTO.getEmail());
                    existingCliente.setTelefone(updatedClienteDTO.getTelefone());
                    existingCliente.setEndereco(updatedClienteDTO.getEndereco());
                    Cliente savedCliente = clienteRepository.save(existingCliente);
                    return convertToDTO(savedCliente);
                })
                .orElse(null);
    }

    public boolean deleteUser(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        }
        return false; // Retorna false se o usuário não existir
    }
}
