package Aula_6;

public enum Estado {
    MG("MG", 7),
    SP("SP", 12),
    RJ("RJ", 15);

    private final String nome;
    private final double taxa;

    private Estado(String nome, double taxa) {
        this.nome = nome;
        this.taxa = taxa;
    }

    public double getTaxa() {
        return taxa;
    }
    
    public String getNome() {
        return nome;
    }
}


