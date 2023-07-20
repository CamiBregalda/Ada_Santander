<p align="justify">Arquivo de organização das atividades realizadas durante a 4ª aula do curso Santander Coders 2023.</p><br>

<h3>O que foi feito:</h3> 

<p align="justify">Durante a aula 4 foram realizados 8 exercícios, os quais consistiam na criação de funções para o funcionamento correto do sistema. Ademais, houve a criação de uma classe Exception para a exibição de uma mensagem de excessão, utilizada durante os exercícios 7 e 8.</p><br>

<h3>Enunciados:</h3> 

<p align="justify"><b>1 - </b>Maria está olhando o mercado de automóveis para comprar um carro novo. Ela identificou que o preço final do veiculo tem um percentual relacionado ao distribuidor e também um percentual de impostos. Ela deseja identificar qual veículo possui os menores percentuais de imposto e do distribuidor, para fazer a escolha de seu carro novo.</p>

<p align="justify">Para ajudar Maria com a sua busca, crie uma função que receba um array com o preço de final de fábrica, o valor do custo com o distribuidor e o valor do preço dos impostos. Ao final, a função deve retornar um array com o percentual do custo do distribuidor e o percentual do custo com os impostos, seguindo essa ordem. Realize o arredondamento para duas casas decimais em relação aos dados de retorno.</p>

<hr>

<p align="justify"><b>2 -  </b>João é um empresário do ramo de construção civil e decidiu adotar novos critérios para dar reajuste salarial para seus funcionários. Agora, o reajuste vai ser dado seguindo as regras abaixo.

Tempo de serviço:
<li>Menos de 1 ano => somente inflação</li>
<li>De 1 até 5 anos (menos que 5 anos) => 1% + inflação</li>
<li>De 5 até 10 anos (menos que 10 anos) => 1.5% + inflação</li>
<li>10 ou mais anos => 2% + inflação (IPCA)</li><br>

<p align="justify">O valor total percentual para o reajuste vai ser a soma do percentual de tempo de serviço mais o percentual da inflação.</p>

<p align="justify">Para ajudar João a calcular o valor do reajuste salarial de seus funcionários, crie uma função que recebe um array como entrada; onde, a posição 0 do array é o tempo de serviço, a posição 1 é o valor da inflação e a posição 2 é o salário do funcionário. Sua função deve calcular o novo salário e retorna-lo. Considere arredondamento de duas casas decimais para o salário retornado.</p>

<hr>

<p aling="justify"><b>3 - </b>Uma professora está precisando de ajuda para calcular a nota de seus alunos. Os seus critérios de avaliação usam um sistema de notas ponderadas. 
Cada aluno possui 3 notas e também uma média de exercícios. Baseados nessas notas é calculado a média de aproveitamento seguindo a formula abaixo:</p>

<p align="center">media_aproveitamento = (N1 + N2 * 2 + N3 * 3 + media_exercicios) / 7</p>

<p align="justify">Após a obtenção de média de aproveitamento do aluno é determinado o conceito dele, seguindo os seguintes critérios:</p>

<li>Média >= 9,0 => conceito A</li>
<li>Média >= 7,5 e < 9,0 => conceito B</li>
<li>Média >= 6,0 e < 7,5 => conceito C</li>
<li>Média < 6,0 => conceito D</li><br>

<p align="justify">Para ajudar a professora com a sua turma, crie uma função que receba um array com as notas dos alunos (as três primeiras notas correspondem a N1, N2 e N3 e a última posição, a médias dos exercícios) e calcule a média de aproveitamento e retorne o conceito que o aluno obteve.</p>

<hr>

<p align="justify"><b>4 - </b>Um certo dia, Joãozinho chegou em casa e perguntou para sua mãe quantos dias ele tinha de vida. Para ajudar a mãe de Joãozinho, crie uma função que recebe a idade expressa em anos, meses e dias (os dados de entradas estarão contidos em um array) e retorne a idade da pessoa expressa em dias. Considerar o ano como tendo um total de 365 dias, e o mês como tendo um total de 30 dias.</p>

<hr>

<p align="justify"><b>5 -  </b>Crie uma função que recebe uma string e retorna o índice do primeiro caractere não repetido da string. Caso não exista caractere único na palavra em questão, retornar -1.</p>

<hr>

<p align="justify"><b>6 -  </b>Crie uma função que recebe um array de valores decimais e identifique se dentre o conjunto dos dados existem valores repetidos. Caso os valores sejam todos distintos retorne false, senão true.</p>

<hr>

<p align="justify"><b>7 -  </b>Crie uma função que receberá um array com três valores que correspondem a possíveis lados de um triângulo. Na função, validar se os dados fornecidos 
formam um triângulo.</p>

<p align="justify">OBS: para formar um triângulo, o valor de cada lado deve ser menor que a soma dos outros 2 lados.</p>

<hr>

<p align="justify"><b>8 -  </b>Crie uma função que receberá um array com três valores que correspondem a possíveis lados de um triângulo. Na função, validar se os dados fornecidos 
formam um triângulo e então mostrar a área do triângulo através da Fórmula de Heron.</p>
