package Aula_4.Dominio;

import Aula_4.Dominio.Prato;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Restaurante {
    private String nome;
    private String endereco;
    private List<Prato> pratosDisponiveis;

    public Restaurante(String nome, String endereco, List<Prato> pratosDisponiveis) {
        this.nome = nome;
        this.endereco = endereco;
        this.pratosDisponiveis = pratosDisponiveis;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Prato> getPratosDisponiveis() {
        return pratosDisponiveis;
    }

    public void setPratosDisponiveis(List<Prato> pratosDisponiveis) {
        this.pratosDisponiveis = pratosDisponiveis;
    }
}