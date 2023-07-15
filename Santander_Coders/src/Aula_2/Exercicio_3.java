package Aula_2;

import java.util.Arrays;

public class Exercicio_3 {
    
    public static void main(String[] args) {
        int[] numeros = {5, 2, 8, 1, 9, 4, 7};
        
        int[] pares = new int[numeros.length];
        int[] impares = new int[numeros.length];
        
        int indicePares = 0, indiceImpares = 0;
        
        //for (tipo elemento : colecao) é equivalente a for(int i = 0; i < numeros.length; i++)
        for (int numero : numeros) {
            if (numero % 2 == 0) {
                pares[indicePares] = numero;
                indicePares++;
            } else {
                impares[indiceImpares] = numero;
                indiceImpares++;
            }
        }
        
        // Redimensionando arrays para remover espaços vazios
        pares = redimensionarArray(pares, indicePares);
        impares = redimensionarArray(impares, indiceImpares);
        
        System.out.println("Números pares: " + Arrays.toString(pares));
        System.out.println("Números ímpares: " + Arrays.toString(impares));
    }
    
    public static int[] redimensionarArray(int[] array, int novoTamanho) {
        int[] novoArray = new int[novoTamanho];
        
        for (int i = 0; i < novoTamanho; i++) {
            novoArray[i] = array[i];
        }
        //Em vez da estrutura de repetição, também pode-se usar o método System.arraycopy(array, 0, novoArray, 0, novoTamanho); para obter o mesmo resultado
         
        return novoArray;
    }
}
