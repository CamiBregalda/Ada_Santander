/*Enunciado anterior: Maria tem uma frutaria e está com uma promoção para quem comprar mais de 10 frutas (do mesmo item). A tabela de preços com frutas com preços
especias são: Pera, Laranja, Maçã, Tomate, Caqui. 

Comprando qualquer fruta da promoção e levando acima de 10 frutas o preçoda unidade fica 1.25 cada. Caso uma pessoa leve uma quantidade inferior
ou igual a 10, o preço individual da fruta fica em 1.45.

Faça uma função que recebe a quantidade de frutas que o cliente está levando e calcule o valor final a ser pago. Arredondar o valor final da 
compra para 2 casas deciamis.

---

Melhore o exercicio de calculo de frutas com desconto realizado anteriormente.

Crie uma exception, que será lançada quando a quantidade de frutas no pedido for 0(zero) e informe para o usuário que não é possivel realizar um pedido sem itens.
Em seguida crie uma segunda exception que será lançada quando a quantidade de frutas no pedido for negativa e informe para o usuário que a quantidade de itens 
fornecidos é inváilido.*/

package Aula_5;

import java.util.Scanner;

public class Exercicio_1 {

        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            
        String[] frutas = {"Pera", "Laranja", "Maçã", "Tomate", "Caqui"};
        int[] quantidades = new int[frutas.length];

        for (int i=0 ; i < frutas.length; i++){
            try{
                System.out.print("Quantidade de "+ frutas[i]+ "s: ");
                int quantidade = scanner.nextInt();
                validarQuantidade(quantidade);
                quantidades[i] = quantidade;
            } catch (QuantidadeInvalidaException e) {
                System.out.println(e.getMessage());
                System.out.println("\nRepita o processo:");
                i--;
            }
        }
        
        int totalFrutas = quantFrutas(quantidades);
        try{
            double totalPago = calculoFrutas(quantidades);
            mostrarResultados(totalFrutas, totalPago);
        } catch (IllegalArgumentException e){
            System.out.println("É impossível realizar um pedido sem nenhum item.");
        }
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
        if (quant <= 10){
            return quant * 1.45;
        } else {
            return quant * 1.25;
        }
    }   
    
    public static void mostrarResultados(int totalFrutas, double totalPago) {
        System.out.println("Total de frutas compradas: " + totalFrutas);
        System.out.printf("Total a ser pago: R$ %.2f%n", totalPago);
    }
    
    /*Criação das exceptions*/
    
    public static void validarQuantidade(int quantidade) throws QuantidadeInvalidaException{
        if(quantidade < 0){
            throw new QuantidadeInvalidaException("A quantidade de itens fornecida é inválida.\nÉ impossível comprar " + quantidade + " frutas.");
        } else if (quantidade == 0){
            throw new QuantidadeInvalidaException("Não é possivel realizar um pedido sem itens.");
        } 
    }
}
