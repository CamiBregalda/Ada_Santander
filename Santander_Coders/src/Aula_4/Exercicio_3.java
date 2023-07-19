/*Uma professora está precisando de ajuda para calcular a nota de seus alunos. Os seus critérios de avaliação usam um sistema de notas ponderadas. 
Cada aluno possui 3 notas e também uma média de exercícios. Baseados nessas notas é calculado a média de aproveitamento seguindo a formula abaixo:

media_aproveitamento = (N1 + N2 * 2 + N3 * 3 + media_exercicios) / 7

Após a obtenção de média de aproveitamento do aluno é determinado o conceito dele, seguindo os seguintes critérios:

média >= 9,0 => conceito A
média >= 7,5 e < 9,0 => conceito B
média >= 6,0 e < 7,5 => conceito C
média < 6,0 => conceito D
Para ajudar a professora com a sua turma, crie uma função que receba um array com as notas dos alunos (as três primeiras notas correspondem a N1, N2 e N3 
e a última posição, a médias dos exercícios) e calcule a média de aproveitamento e retorne o conceito que o aluno obteve.

Ex:
Entrada: [8.0, 7.0, 8.0, 8.0]
Saída: B

Ex:
Entrada: [5.0, 4.3, 8.0, 7.0]
Saída: C*/

package Aula_4;

public class Exercicio_3 {
    public static void main(String[] args) {
        double[][] entradas = {
                {8.0, 7.0, 8.0, 8.0},
                {5.0, 4.3, 8.0, 7.0},
                {2.0, 5.0, 8.0, 6.0},
                {4.0, 1.0, 9.0, 7.0},
                {2.0, 2.0, 10.0, 1.0},
                {2.9, 2.5, 10.0, 7.1},
                {4.4, 4.1, 8.5, 9.5},
                {5.0, 7.0, 9.0, 8.0},
                {8.0, 7.0, 8.0, 9.0},
                {8.0, 8.0, 10.0, 9.0},
                {2.0, 2.0, 5.0, 1.0}
        };

        String[] saidas = {
                "B",
                "C",
                "C",
                "D",
                "D",
                "C",
                "C",
                "B",
                "B",
                "A",
                "D"
        };

        for (int i = 0; i < entradas.length; i++) {
            String resultado = mediaAproveitamento(entradas[i]);
            String esperado = saidas[i];

            System.out.println("Resultado: " + resultado);
            System.out.println("Esperado: " + esperado);
            System.out.println(resultado.equals(esperado));
            System.out.println();
        }
    }

    public static String mediaAproveitamento(double[] input) {
        double N1 = input[0];
        double N2 = input[1];
        double N3 = input[2];
        double mediaExercicios = input[3];
        
        double nota = (N1 + N2 * 2 + N3 * 3 + mediaExercicios) / 7;
        
        if (nota >= 9){
            return "A";
        } else if (nota >= 7.5 && nota < 9){
            return "B";
        } else if (nota >= 6 && nota < 7.5){
            return "C";
        } else {
            return "D";
        }
    }
}
