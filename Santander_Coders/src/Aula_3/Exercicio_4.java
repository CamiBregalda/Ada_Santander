/*Crie uma função que recebe uma string e retorna o índice do primeiro caractere não repetido da string. 
Caso não exista caractere único na palavra em questão, retornar -1.*/
package Aula_3;

public class Exercicio_4 {
    
    public static void main(String[] args) {
        String palavra = "amor";
        
        int indice = primeiroCaractereUnico(palavra);
        System.out.printf("O índice do primeiro caractere não repetido da palavra é %d.\n", indice);
    }
    
    public static int primeiroCaractereUnico(String input) {
        // Array para contar as ocorrências de cada letra (assumindo alfabeto em letras minúsculas)
        int[] ocorrencias = new int[26];
        char[] caracteres = input.toCharArray();
        
        // Contagem das ocorrências de cada letra na palavra
        for (int i = 0; i < caracteres.length; i++) {
            char c = caracteres[i];
            ocorrencias[c - 'a']++;
        }
        
        // Verificação do primeiro caractere não repetido
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (ocorrencias[c - 'a'] == 1) {
                return i;
            }
        }
        
        return -1;
    }
    
}
