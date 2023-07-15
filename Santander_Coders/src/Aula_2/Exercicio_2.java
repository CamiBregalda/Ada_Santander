package Aula_2;

import java.util.Arrays;

public class Exercicio_2 {
    public static void main(String[] args) {
        int[] numeros = {5, 4, 1, 2, 3};
        int[] ascendingOrder = sortAscendingOrder(numeros);
        int[] descendingOrder = sortDescendingOrder(numeros);
        
        System.out.println("Array original: " + Arrays.toString(numeros));
        System.out.println("Array em ordem crescente: " + Arrays.toString(ascendingOrder));
        System.out.println("Array em ordem decrescente: " + Arrays.toString(descendingOrder));
    }
    
    public static int[] sortAscendingOrder(int[] numeros){
        //criação de uma cópia exata do array int[] numeros
        int[] array = numeros.clone();
        
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
	                int aux = array[i];
	                array[i] = array[j];
	                array[j] = aux;
	            }
            }
        }
        
        return array;
    }
    
    public static int[] sortDescendingOrder(int[] numeros){
        int[] array = numeros.clone();
        
	for (int i = 0; i < array.length; i++) {
            //-i pois o último valor já se tem certeza que é o correto, então não é necessário verificá-lo novamente
            for (int j = 0; j < array.length - 1 - i; j++) {
	        if (array[j] < array[j + 1]) {
	            int aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
	        }
	    }
	}
            
	return array;
    }
}
