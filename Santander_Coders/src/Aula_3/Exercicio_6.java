/*Calcule a área de um triângulo utilizando a fórmula de Heron*/

package Aula_3;

import java.util.Scanner;

public class Exercicio_6 {
    
    public static void main(String[] args) {
        System.out.println("Digite o valor do 1º lado do triângulo: ");
        double a = entradaDados();
        System.out.println("Digite o valor do 2º lado do triângulo: ");
        double b = entradaDados();
        System.out.println("Digite o valor do 3º lado do triângulo: ");
        double c = entradaDados();
        
        try{
            double area = calcularArea(a, b, c);
            System.out.printf("A área do triângulo é %.2f cm2 e ele não atende as condições de desigualdade triangular.\n", area);
        } catch (IllegalArgumentException e) {
            System.out.println("Lados inválidos, ou seja, o referido triângulo atende as condições de desigualdade triangular.");
        }
        
    }
    
    public static double entradaDados(){
        Scanner scanner = new Scanner(System.in);
        double result = scanner.nextDouble();
        
        return result;
    }
    
    public static double calcularArea(double a, double b, double c){
        if (verificaTriangulo(a, b, c)){
            double p = (a + b + c) / 2;
            double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
            return area;
        }
        return 0;
    }

    public static boolean verificaDesigualdadeTriangular(double a, double b, double c) {
        if ((a < b + c) && (b < a + c) && (c < a + b) && (a > Math.abs(b - c)) && (b > Math.abs(a - c)) && (c > Math.abs(a - b))){
            return true;
        } else {
            throw new IllegalArgumentException();
        }
    }
    
}
