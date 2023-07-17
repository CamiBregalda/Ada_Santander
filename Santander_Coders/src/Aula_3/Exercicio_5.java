/*Crie uma função que recebe um array de valores decimais e identifique se dentre o conjunto dos dados existem valores repetidos. 
  Caso os valores sejam todos distintos retorne false, senão true.*/

package Aula_3;

public class Exercicio_5 {
    
    public static void main(String[] args) {
        double[] array = {2.5, 3.2, 4.5, 4, 6};
        
        boolean elementosRepetidos = elementosRepetidos(array);
        if (elementosRepetidos == true){
            System.out.println("Há elementos repetidos!");
        } else {
            System.out.println("Não há elementos repetidos!");
        }
    }
    
    public static boolean elementosRepetidos(double[] input) {
        int n = input.length;
    
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (input[i] == input[j]) {
                    return true;
                }
            }
        }

        return false;
    }
}
