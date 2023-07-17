/*João é um empresário do ramo de construção civil e decidiu adotar novos critérios para dar reajuste salarial para seus funcionários. Agora, 
o reajuste vai ser dado seguindo as regras abaixo.

Tempo de serviço:
de 1 até 5 anos => 1%
de 5 até 10 anos => 1.5%
10 ou mais anos => 2% valor da inflação (IPCA)
O valor total percentual para o reajuste vai ser a soma do percentual de tempo de serviço mais o percentual da inflação.

Para ajudar João a calcular o valor do reajuste salarial de seus funcionários, crie uma função que recebe um array como entrada; onde, a posição 0 
do array é o tempo de serviço, a posição 1 é o valor da inflação e a posição 3 é o salário do funcionário. Sua função deve calcular o novo salário 
e retorna-lo. Considere arredondamento de duas casas decimais para o salário retornado.*/

package Aula_3;

public class Exercicio_3 {
    
    public static void main(String[] args) {
        double[] array = {11, 4.5, 2500.00};
        
        double novoSalario = calculoSalario(array);
        System.out.printf("Novo salário: R$ %.2f\n", novoSalario);
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
        
        return novoSalario;
    }
    
}
