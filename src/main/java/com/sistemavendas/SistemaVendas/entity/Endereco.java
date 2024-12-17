package com.sistemavendas.SistemaVendas.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Endereco")
    private Long id;

    @Column(name = "estado_Endereco")
    private String estado;

    @Column(name = "cidade_Endereco")
    private String cidade;

    @Column(name = "bairro_Endereco")
    private String bairro;

    @Column(name = "rua_Endereco")
    private String rua;

    @Column(name = "numero_Endereco")
    private Long numero;


    public Endereco(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

}
