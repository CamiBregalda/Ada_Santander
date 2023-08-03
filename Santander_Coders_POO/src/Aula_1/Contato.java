
package Aula_1;

public class Contato {
    
    private String nome;
    private String numero;
    
    public Contato(String nome, String numero){
        this.nome = nome;
        this.numero = numero;
    }
    
    public void ligar(){
        System.out.println("\nLigando para " + nome + ". Número: " + numero);
    }
    
    public void detalhar(){
        System.out.println("\nDetalhes do contato:");
        System.out.println("Nome: " + getNome());
        System.out.println("Número: " + getNumero());   
    }
    
    public void verNumero(){
        System.out.println("\nO número de " + nome + " é " + numero);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
}
