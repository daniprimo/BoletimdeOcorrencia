package com.BoletimDeOcorrencia.BoletimDeOcorrenciaOperacional.model;

import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.persistence.*;

@Entity
public class Vitma {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    private String cpf;
    @ManyToMany
    private Endereço endereço;
    private String telefone;
    private String estadoDaVitma;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereço getEndereço() {
        return endereço;
    }

    public void setEndereço(Endereço endereço) {
        this.endereço = endereço;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEstadoDaVitma() {
        return estadoDaVitma;
    }

    public void setEstadoDaVitma(String estadoDaVitma) {
        this.estadoDaVitma = estadoDaVitma;
    }
}
