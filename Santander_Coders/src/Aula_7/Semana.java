
package Aula_7;

public enum Semana {
    DOMINGO(new String[]{"domingo", "dom", "dm"}, 1),
    SEGUNDA(new String[]{"segunda-feira", "seg"}, 2),
    TERCA(new String[]{"terça-feira", "ter"}, 3),
    QUARTA(new String[]{"quarta-feira", "qua"}, 4),
    QUINTA(new String[]{"quinta-feira", "qui"}, 5),
    SEXTA(new String[]{"sexta-feira", "sex"}, 6),
    SABADO(new String[]{"sábado", "sab"}, 7);
    
    private final String[] keywords;
    private final int dia;
    
    Semana(String[] keywords, int dia){
        this.keywords = keywords;
        this.dia = dia;
    }

    public String[] getKeywords() {
        return keywords;
    }

    public int getDia() {
        return dia;
    }
    
    public static Semana mostrarNomeEnum(String nome) {
        for (Semana semana : Semana.values()) {
            for (String keyword : semana.keywords){
                if (nome.equalsIgnoreCase(keyword)) {
                    return semana;
                }   
            }
        }
        throw new IllegalArgumentException("\nNome inválido: " + nome);
    }
    
    public static Semana mostrarNomeEnum(int dia) {
        for (Semana semana : Semana.values()) {
            if (semana.dia == dia) {
                return semana;
            }
        }
        throw new IllegalArgumentException("\nDia inválido: " + dia);
    }
    
    public String toString() {
        return "Semana." + this.name(); // Concatena "Semana." antes do nome
    }
}
