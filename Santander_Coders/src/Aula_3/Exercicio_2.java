/*Maria está olhando o mercado de automóveis para comprar um carro novo. Ela identificou que o preço final do veiculo tem um percentual relacionado 
ao distribuidor e também um percentual de impostos. Ela deseja identificar qual veículo possui os menores percentuais de imposto e do distribuidor, 
para fazer a escolha de seu carro novo.

Para ajudar Maria com a sua busca, crie uma função que receba um array com o preço de final de fábrica, o valor do custo com o distribuidor e o 
valor do preço dos impostos. Ao final, a função deve retornar um array com o percentual do custo do distribuidor e o percentual do custo com os 
impostos, seguindo essa ordem. Realize o arredondamento para duas casas decimais em relação aos dados de retorno.*/

package Aula_3;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Exercicio_2 {
    
    public static void main(String[] args) {
        double[] array = {115500.00, 25000.00, 32500.00};
        
        double[] percentuais = custosCarro(array);
        System.out.printf("Percential do distribuidor: R$ %.2f\n", percentuais[0]);
        System.out.printf("Percential dos impostos: R$ %.2f\n", percentuais[1]);
    }
    
    public static double[] custosCarro(double[] input) {
        double precoFinal = input[0];
        double custoDistribuidor = input[1];
        double custoImpostos = input[2];
        
        double percentualDistribuidor = (custoDistribuidor / precoFinal) * 100;
        double percentualImpostos = (custoImpostos / precoFinal) * 100;
        
        double percentualExatoDistribuidor = new BigDecimal(percentualDistribuidor * 100.0 / 100.0).setScale(3, RoundingMode.DOWN).setScale(2, RoundingMode.HALF_DOWN).doubleValue();
        double percentualExatoImpostos = new BigDecimal(percentualImpostos * 100.0 / 100.0).setScale(3, RoundingMode.DOWN).setScale(2, RoundingMode.HALF_DOWN).doubleValue();
        
        double[] result = {percentualExatoDistribuidor, percentualExatoImpostos};
        
        return result;
    }
}

/*preço final = percentual do distribuidor e percentual de impostos*/
