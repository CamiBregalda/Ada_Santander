/*Replique a classe sobre os dias da semana que fizemos em aula, em seguida adicione a possibilidade transformar de string para Enum, porém utilizando o 
nome verdadeiro do dia, por exemplo:

sábado -> Semana.SABADO terça-feira - > Semana.TERCA*/

package Aula_6;

public class Exercicio_3 {
    public static void main(String[] args) {
        //System.out.println(Semana.SABADO);
        
        Semana diaDaSemana = Semana.mostrarNomeEnum("sábado");
        
        if (diaDaSemana != null) {
            System.out.println(diaDaSemana);
        } else {
            System.out.println("Dia inválido.");
        }
    }
 
          
}
