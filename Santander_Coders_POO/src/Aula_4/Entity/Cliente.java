package Entity;

public class Cliente {
    private static Integer ultimoIdentificador = 0;
    private Integer id;
    private String nome;

    public Cliente(){}

    public Cliente(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public static Integer getUltimoIdentificador() {
        return ultimoIdentificador;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Cliente: \nIdentificador: " + id + "\nNome: " + nome;
    }
}
