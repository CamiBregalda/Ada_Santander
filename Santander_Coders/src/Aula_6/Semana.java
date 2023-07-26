
package Aula_6;

public enum Semana {
    DOMINGO("domingo"),
    SEGUNDA("segunda-feira"),
    TERCA("terça-feira"),
    QUARTA("quarta-feira"),
    QUINTA("quinta-feira"),
    SEXTA("sexta-feira"),
    SABADO("sábado");
    
    private final String nome;
    
    Semana(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return nome;
    }
    
    public static Semana mostrarNomeEnum(String nome) {
        for (Semana semana : Semana.values()) {
            if (semana.nome.equalsIgnoreCase(nome)) {
                return semana;
            }
        }
        throw new IllegalArgumentException("\nNome inválido: " + nome);
    }
    
    public String toString() {
        return "Semana." + this.name(); // Concatena "Semana." antes do nome
    }
}
