/*Replique a classe sobre os dias da semana que fizemos em aula, em seguida adicione a possibilidade transformar de string para Enum, porém utilizando o 
nome verdadeiro do dia, por exemplo:

sábado -> Semana.SABADO terça-feira - > Semana.TERCA*/

package Aula_7;

import java.util.Arrays;

public class Exercicio_1 {
    public static void main(String[] args) {
        
        String dia = "sábado";
        
        Semana diaDaSemana = Semana.mostrarNomeEnum(dia);
        String[] array = Semana.mostrarNomeEnum(dia).getKeywords();
        Semana numDia = Semana.mostrarNomeEnum(1);
        
        
        try {
            if (diaDaSemana != null) {
                System.out.println("Dia da semana pelo nome: " + diaDaSemana);
                System.out.println("Array do dia da semana: " + Arrays.toString(array));
            }
            if (numDia != null) {
                System.out.println("\nDia da semana pelo numero: " + numDia);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
 
          
}
