package com.sistemavendas.SistemaVendas.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Cliente")
    private Long id;

    @Column(name = "nome_Cliente")
    private String nome;

    @Column(name = "email_Cliente")
    private String email;

    @Column(name = "telefone_Cliente")
    private String telefone;

    @OneToOne(cascade = CascadeType.ALL) // Define a relação 1-1 com Endereco
    @JoinColumn(name = "endereco_id", referencedColumnName = "id_Endereco") // Define a coluna de ligação
    private Endereco endereco;

    public Cliente (){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
