package Aula_1;

/*Faça um Programa que peça a temperatura em graus Fahrenheit, transforme e mostre a temperatura em graus Celsius.
C = 5 * ((F-32) / 9).*/

import java.util.Scanner;

public class Exercicio_1 {
    
    public static void main(String[] args) {
        double fahrenheit = entradaValores();
        
        double celsius = calculoCelsius(fahrenheit);
        System.out.printf("A temperatura de %.2fº fahrenheit é equivalente a %.2fº celsius.\n", fahrenheit, celsius);
    }
    
    public static double entradaValores(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite a temperatura em graus Fahrenheit:");
        double fahrenheit = scanner.nextDouble();
        
        return fahrenheit;
    }
    
    public static double calculoCelsius(double fahrenheit){
        double celsius = 5 * ((fahrenheit - 32) / 9);
        
        return celsius;
    }
}