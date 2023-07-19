/*Crie uma função que recebe uma string e retorna o índice do primeiro caractere não repetido da string. Caso não exista caractere único na palavra em 
questão, retornar -1.

Ex:
Entrada: amor
Saída: 0

Ex:
Entrada: cocada
Saída: 1*/

package Aula_4;

public class Exercicio_5 {
    public static void main(String[] args) {
        String[] entradas = {
                "amor",
                "cocada",
                "mora",
                "ovo",
                "cachorro",
                "kaka",
                "saudades",
                "palalelepipedo",
                "fofocalizando",
                "papagaio",
                "ateiaateiab"
        };

        int[] saidas = {
                0,
                1,
                0,
                1,
                1,
                -1,
                2,
                9,
                4,
                4,
                10
        };

        for (int i = 0; i < entradas.length; i++) {
            double resultado = primeiroCaractereUnico(entradas[i]);
            double esperado = saidas[i];

            System.out.println("Resultado: " + resultado);
            System.out.println("Esperado: " + esperado);
            System.out.println(resultado == esperado);
            System.out.println();
        }
    }

    // Faça utilizando For
    
    public static int primeiroCaractereUnico(String input) {
        int[] ocorrencias = new int[26];
        char[] caracteres = input.toCharArray();
        
        for (int i = 0; i < caracteres.length; i++) {
            char c = caracteres[i];
            ocorrencias[c - 'a']++;
        }
        
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (ocorrencias[c - 'a'] == 1) {
                return i;
            }
        }
        
        return -1;
    }
}
