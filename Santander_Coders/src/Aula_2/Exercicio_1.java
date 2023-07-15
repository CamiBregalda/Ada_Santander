/*Maria tem uma frutaria e está com uma promoção para quem comprar mais de 10 frutas (do mesmo item). A tabela de preços com frutas com preços
especias são: Pera, Laranja, Maçã, Tomate, Caqui. 

Comprando qualquer fruta da promoção e levando acima de 10 frutas o preçoda unidade fica 1.25 cada. Caso uma pessoa leve uma quantidade inferior
ou igual a 10, o preço individual da fruta fica em 1.45.

Faça uma função que recebe a quantidade de frutas que o cliente está levando e calcule o valor final a ser pago. Arredondar o valor final da 
compra para 2 casas deciamis.*/

package Aula_2;

public class Exercicio_1 {
    
    public static void main(String[] args) {
        
        String[] frutas = {"Pera", "Laranja", "Maçã", "Tomate", "Caqui"};
        int[] quantidades = new int[frutas.length];

        for (int i=0 ; i < frutas.length; i++){
            System.out.println("Quantidade de "+ frutas[i]+ "s:");
            int quantidade = Utils.lerInt();
            quantidades[i] = quantidade;
        };
        
        int totalFrutas = quantFrutas(quantidades);
        double totalPago = calculoFrutas(quantidades);
        mostrarResultados(totalFrutas, totalPago);
    
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
}
