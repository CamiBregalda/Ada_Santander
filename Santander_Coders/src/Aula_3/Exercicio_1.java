/*Maria tem uma frutaria e está com uma promoção para quem comprar mais de 10 frutas (do mesmo item). A tabela de preços das frutas com preços 
especiais são:

Frutas: Pera, Laranja, Maçã, Tomate, Caqui
Comprando qualquer fruta da promoção e levando acima de 10 frutas o preço da unidade fica em 1.25 cada, caso a pessoa leve uma quantidade inferior 
ou igual a 10 o preço individual da fruta fica em 1.45.

Faça uma função que recebe a quantidade de frutas que o cliente está levando e calcule o valor final a ser pago. Arredondar o valor final da 
compra para 2 casas decimais.*/

package Aula_3;

public class Exercicio_1 {

    public static void main(String[] args) {
        double quant = 12;
        
        double custoCompra = custoCompra(quant);
        System.out.printf("Custo da compra: R$ %.2f\n", custoCompra);
    }
    
    public static double custoCompra(double input) {
        if (input <= 10){
            return input * 1.45;
        } else {
            return input * 1.25;
        }
    }
    
}
