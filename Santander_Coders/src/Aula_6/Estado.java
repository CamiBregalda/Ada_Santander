package Aula_6;

public enum Estado {
    MG(7),
    RJ(15),
    SP(12);

    private final double taxa;

    private Estado(double taxa) {
        this.taxa = taxa;
    }

    public double getTaxa() {
        return taxa;
    }
}


