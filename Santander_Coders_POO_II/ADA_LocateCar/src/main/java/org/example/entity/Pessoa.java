package org.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;

@Entity
@Table (name = "pessoas")
@Data
@NoArgsConstructor
public class Pessoa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    private int id;
    @Column(name = "CPF", unique = true)
    private String cpf;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "SEXO")
    private Sexo sexo;
    @Column(name = "CATEGORIA", unique = true)
    private CategoriaPessoa categoriaPessoa;
    @OneToMany
    private List<Aluguel> alugueis;

    public Pessoa(String cpf, String nome, Sexo sexo, CategoriaPessoa categoriaPessoa) {
        this.cpf = cpf;
        this.nome = nome;
        this.sexo = sexo;
        this.categoriaPessoa = categoriaPessoa;
    }

    @Override
    public String toString() {
        return "Id: " + id +
                "\nCpf: " + cpf +
                "\nNome: " + nome +
                "\nSexo: " + sexo +
                "\nCategoria: " + categoriaPessoa +
                "\nAlugueis: " + alugueis;
    }
}
