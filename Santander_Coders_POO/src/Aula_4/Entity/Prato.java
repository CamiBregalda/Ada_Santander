package Entity;

import java.util.Objects;

public class Prato {
    private static Integer ultimoIdentificador = 0;
    private Integer id;
    private String nome;
    private double preco;
    private String descricao;

    public Prato(Integer id, String nome, double preco, String descricao) {
        this.id = ++ultimoIdentificador;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "\nIdentificador: " + id + "\nNome: " + nome + "\nPreço: " + preco + "\nDescrição: " + descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prato prato = (Prato) o;
        return id.equals(prato.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}