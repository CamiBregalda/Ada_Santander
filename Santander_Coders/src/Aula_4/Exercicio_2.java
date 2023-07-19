/*João é um empresário do ramo de construção civil e decidiu adotar novos critérios para dar reajuste salarial para seus funcionários. 
Agora, o reajuste vai ser dado seguindo as regras abaixo.

Tempo de serviço:
menos de 1 ano => somente inflação
de 1 até 5 anos (menos que 5 anos) => 1% + inflação
de 5 até 10 anos (menos que 10 anos) => 1.5% + inflação
10 ou mais anos => 2% + inflação
O valor total percentual para o reajuste vai ser a soma do percentual de tempo de serviço mais o percentual da inflação.

Para ajudar João a calcular o valor do reajuste salarial de seus funcionários, crie uma função que recebe um array como entrada; onde, a posição 0 
do array é o tempo de serviço, a posição 1 é o valor da inflação e a posição 2 é o salário do funcionário. Sua função deve calcular o novo salário 
e retorna-lo. Considere arredondamento de duas casas decimais para o salário retornado.

Ex:
Entrada: [1, 5.0, 2000.00]
Saída: 2120.00

Ex:
Entrada: [11,4.5,2500.00]
Saída: 2662.50*/

package Aula_4;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Exercicio_2 {
    public static void main(String[] args) {
        double[][] entradas = {
                {1, 5.0, 2000.00},
                {11, 4.5,2500.00},
                {5.1, 6.7, 4500.0},
                {1, 5.7, 4800.0},
                {10.1, 4.7, 4100.0},
                {15, 5.3, 6100.0},
                {2, 8.3, 9500.0},
                {20, 9.3, 10500.0},
                {0.5, 11.3, 4800.0},
                {5, 12.5, 6800.0},
                {10, 9.1, 8200.0}
        };

        double[] saidas = {
                2120.00,
                2662.50,
                4869.00,
                5121.60,
                4374.70,
                6545.30,
                10383.50,
                11686.50,
                5342.4,
                7752.00,
                9110.20
        };

        for (int i = 0; i < entradas.length; i++) {
            double resultado = calculoSalario(entradas[i]);
            double esperado = saidas[i];

            System.out.println("Resultado: " + resultado);
            System.out.println("Esperado: " + esperado);
            System.out.println(resultado == esperado);
            System.out.println();
        }
    }

    public static double calculoSalario(double[] input) {
        double tempoServico = input[0];
        double inflacao = input[1];
        double salario = input[2];
        double percentualTempoServico;
        
        if (tempoServico >= 1 && tempoServico < 5) {
            percentualTempoServico = 1.0;
        } else if (tempoServico >= 5 && tempoServico < 10) {
            percentualTempoServico = 1.5;
        } else if (tempoServico >= 10) {
            percentualTempoServico = 2.0;
        } else {
            percentualTempoServico = 0.0;
        }
        
        double valorReajuste = salario * ((percentualTempoServico + inflacao) / 100);
        double novoSalario = salario + valorReajuste;
        
        return arredondar(novoSalario);
    }

    public static double arredondar(double numero) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat decimalFormat = new DecimalFormat("#.##", symbols);
       return Double.parseDouble(decimalFormat.format(numero));
    }
}
