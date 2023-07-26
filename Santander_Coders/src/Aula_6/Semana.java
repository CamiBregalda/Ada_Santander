
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
        for (int i = 0; i < Semana.values().length; i++) {
            Semana semana = Semana.values()[i];
            if (semana.nome.equalsIgnoreCase(nome)) {
                return semana;
            }
        }
        return null;
    }
    
    public String toString() {
        return "Semana." + this.name(); // Concatena "Semana." antes do nome
    }
}
