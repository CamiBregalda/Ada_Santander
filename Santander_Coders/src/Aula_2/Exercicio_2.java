package Aula_2;

import java.util.Scanner;

public class Exercicio_2 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int quantidade;
        
        String[] frutas = {"Pera", "Laranja", "Maçã", "Tomate", "Caqui"};
        int[] quantidades = new int[frutas.length];

        for (int i=0 ; i < frutas.length; i++){
            System.out.println("Quantidade de "+ frutas[i]+ "s:");
            quantidade = scanner.nextInt();
            quantidades[i] = quantidade;
        };
        
        int totalFrutas = quantFrutas(quantidades);
        double totalPago = calculoFrutas(quantidades);
        mostrarResultados(totalFrutas, totalPago);
        
        
        scanner.close();
    }
    
    public static double calculoFrutas(int[] quantidades) {
        double totalPago = 0;
        
        for (int quantidade : quantidades) {
            totalPago += calculoPreco(quantidade);
        }
        
        return totalPago;
    }
    
    public static int quantFrutas(int[] quantidades){
        int total = 0;
        
        for (int quantidade : quantidades) {
            total += quantidade;
        }
        
        return total;
    }
    
    public static double calculoPreco(int quant){
        if (quant < 10){
            return quant * 1.45;
        } else {
            return quant * 1.25;
        }
    }   
    
    public static void mostrarResultados(int totalFrutas, double totalPago) {
        System.out.println("Total de frutas compradas: " + totalFrutas);
        System.out.printf("Total a ser pago: R$ %.2f%n", totalPago);
    }
}
