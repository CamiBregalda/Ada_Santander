/*Crie uma função que receberá um array com três valores que correspondem a possíveis lados de um triângulo. Na função, validar se os dados fornecidos 
formam um triângulo e então mostrar a área do triângulo através da Fórmula de Heron.*/

package Aula_4;

public class Exercicio_8 {
    public static void main(String[] args) {
        int[][] entradas = {
                {2, 2, 5},
                {12, 12, 12},
                {1232, 2200, 120},
                {2, 2, 2},
                {2, 5, 2},
                {150, 120, 220},
                {122, 252, 130},
                {1, 2, 1}
        };

        String[] saidas = {
                "LadosInvalidosException",
                "62,35",
                "LadosInvalidosException",
                "1,73",
                "LadosInvalidosException",
                "8528,45",
                "LadosInvalidosException",
                "LadosInvalidosException"
        };
        
        String resultado;
        
        for (int i = 0; i < entradas.length; i++) {
            try {
                resultado = String.format("%.2f", eUmTriangulo(entradas[i]));
            } catch (LadosInvalidosException e) {
                resultado = "LadosInvalidosException";
            }
            String esperado = saidas[i];

            
            System.out.println("Resultado: " + resultado);
            System.out.println("Esperado: " + esperado);
            System.out.println(resultado.equals(esperado));
            System.out.println();
        }
    }

    public static double eUmTriangulo(int[] input) throws LadosInvalidosException {
        int a = input[0];
        int b = input[1];
        int c = input[2];
        
        if ((a < b + c) && (b < a + c) && (c < a + b)){
            double p = (a + b + c) / 2;
            double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
            return area;
        } else {
            throw new LadosInvalidosException();
        }
    }
}
