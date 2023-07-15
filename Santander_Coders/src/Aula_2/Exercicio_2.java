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
	                int temp = array[i];
	                array[i] = array[j];
	                array[j] = temp;
	            }
            }
        }
        
        return array;
    }
    
    public static int[] sortDescendingOrder(int[] numeros){
        int[] array = numeros.clone();
        
	    for (int i = 0; i < array.length; i++) {
	        for (int j = i + 1; j < array.length; j++) {
	            if (array[i] < array[j]) {
	                int temp = array[i];
	                array[i] = array[j];
	                array[j] = temp;
	            }
	        }
	    }
	    return array;
    }
}
