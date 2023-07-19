/*Um certo dia, Joãozinho chegou em casa e perguntou para sua mãe quantos dias ele tinha de vida. Para ajudar a mãe de Joãozinho, 
crie uma função que recebe a idade expressa em anos, meses e dias (os dados de entradas estarão contidos em um array) e retorne a idade 
da pessoa expressa em dias. Considerar o ano como tendo um total de 365 dias, e o mês como tendo um total de 30 dias.

Ex:
Entrada: [5, 4, 14]
Saída: 1959

Ex:
Entrada: [10, 8, 16]
Saída: 3906*/

package Aula_4;

public class Exercicio_4 {
    public static void main(String[] args) {
        int[][] entradas = {
                {5, 6, 12},
                {10, 8, 13},
                {21, 10, 25},
                {0, 10, 2},
                {102, 0, 10},
                {28, 11, 10},
                {55, 1, 15},
                {78, 8, 0},
                {0, 0, 15}
        };

        int[] saidas = {
                2017,
                3903,
                7990,
                302,
                37240,
                10560,
                20120,
                28710,
                15
        };

        for (int i = 0; i < entradas.length; i++) {
            int resultado = idadeEmDias(entradas[i]);
            int esperado = saidas[i];

            System.out.println("Resultado: " + resultado);
            System.out.println("Esperado: " + esperado);
            System.out.println(resultado == esperado);
            System.out.println();
        }
    }

    public static int idadeEmDias(int[] input) {
        int ano = input[0];
        int mes = input[1];
        int dias = input[2];
        
        int idade = (ano * 365) + (mes * 30) + dias;
        
        return idade;
    }
}
