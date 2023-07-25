/*Uma empresa vende o mesmo produto para 3 diferentes estados. Cada estado possui uma taxa diferente de imposto sobre o produto (MG 7%; SP 12%; RJ 15%;). 
Faça um programa que recebe o valor do produto e o estado de destino do produto e, então, calcule o preço final do produto acrescido do imposto baseado no 
estado em que ele será vendido.

Considerar as seguintes restrições quanto a entrada e saída dos dados:

Fazer um arredondamento de 4 casas no valor final do produto*/

package Aula_6;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Exercicio_1 {
    public static void main(String[] args) {
        System.out.println(valorProdutoFinal(250.10, Estado.MG) == 267.607);
        System.out.println(valorProdutoFinal(250.10, Estado.RJ) == 287.615);
        System.out.println(valorProdutoFinal(250.10, Estado.SP) == 280.112);
    }

    public static double valorProdutoFinal(double valorProduto, Estado estado) {
        double taxaImposto = estado.getTaxa() / 100.0;
        double valorFinal = valorProduto * (1 + taxaImposto);
        return arredondar(valorFinal);
    }

    public static double arredondar(double numero) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat decimalFormat = new DecimalFormat("#.####", symbols);
        return Double.parseDouble(decimalFormat.format(numero));
    }
}
