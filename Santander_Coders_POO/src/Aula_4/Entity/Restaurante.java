package Entity;

import Entity.Prato;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Restaurante {
    private static Integer ultimoIdentificador = 0;
    private Integer id;
    private String nome;
    private String endereco;
    private List<Prato> pratosDisponiveis;

    public Restaurante(Integer id, String nome, String endereco, List<Prato> pratosDisponiveis) {
        this.id = ++ultimoIdentificador;
        this.nome = nome;
        this.endereco = endereco;
        this.pratosDisponiveis = pratosDisponiveis;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public List<Prato> getPratosDisponiveis() {
        return pratosDisponiveis;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Restaurante: \nIdentificador: ").append(id).append("\nNome: ").append(nome).append("\nEndereco: ").append(endereco).append("\nPratos: ");
        if (pratosDisponiveis.isEmpty()) {
            stringBuilder.append("Nenhum prato disponível");
        } else {
            for (Prato prato : pratosDisponiveis) {
                stringBuilder.append(prato.getNome()).append(", ");
            }
        }
        return stringBuilder.toString();
    }
}