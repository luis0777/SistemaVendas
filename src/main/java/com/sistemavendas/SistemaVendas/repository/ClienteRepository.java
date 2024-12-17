package com.sistemavendas.SistemaVendas.repository;

import com.sistemavendas.SistemaVendas.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
