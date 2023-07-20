/*Crie uma função que receberá um array com três valores que correspondem a possíveis lados de um triângulo. Na função, validar se os dados fornecidos 
formam um triângulo.

OBS: para formar um triângulo, o valor de cada lado deve ser menor que a soma dos outros 2 lados.*/

package Aula_4;

public class Exercicio_7 {
    public static void main(String[] args) {
        int[][] entradas = {
                {2, 2, 5},
                {3, 3, 5},
                {2, 2, 2},
                {2, 5, 2},
                {2, 4, 3},
                {150, 120, 220},
                {122, 252, 130},
                {152, 200, 351},
                {1232, 2200, 120},
                {1, 2, 1},
                {2, 1, 2}
        };

        String[] saidas = {
                "LadosInvalidosException",
                "true",
                "true",
                "LadosInvalidosException",
                "true",
                "true",
                "LadosInvalidosException",
                "true",
                "LadosInvalidosException",
                "LadosInvalidosException",
                "true"
        };

        for (int i = 0; i < entradas.length; i++) {
            String resultado = "true";

            try {
                eUmTriangulo(entradas[i]);
            } catch (LadosInvalidosException e) {
                resultado = "LadosInvalidosException";
            }
            String esperado = saidas[i];

            System.out.println("Resultado: " + resultado);
            System.out.println("Esperado: " + esperado);
            System.out.println(resultado == esperado);
            System.out.println();
        }
    }

    public static void eUmTriangulo(int[] input) throws LadosInvalidosException {
        int a = input[0];
        int b = input[1];
        int c = input[2];
        
        if (!((a < b + c) && (b < a + c) && (c < a + b))){
            throw new LadosInvalidosException();
        }
    }
}
