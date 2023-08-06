# POO Exercício 02

## Sistema Bancário Simplificado

<p align="justify">Você deve criar um sistema simplificado para um banco. Nesse sistema, será possível gerenciar clientes e suas respectivas contas.</p>

- <b>Parte 1:</b> Classe Cliente
    - <p align="justify">Crie uma classe Cliente que possua os seguintes atributos: nome, cpf e email.</p>
    - <p align="justify">Essa classe deve ter um construtor que inicialize todos esses valores, e os métodos equals() e toString(). O método equals() deve comparar dois clientes com base em seus CPFs (dois clientes são iguais se tiverem o mesmo CPF). O método toString() deve retornar uma string contendo todas as informações do cliente.</p>

<hr>

- <b>Parte 2:</b> Classe Conta
    - <p align="justify">Em seguida, crie uma classe Conta que possui um Cliente (o dono da conta), um numero (número da conta) e um saldo.</p>
    - <p align="justify">Essa classe deve ter um construtor para inicializar o cliente e o número da conta (o saldo inicial deve ser zero), um método depositar(), que aumenta o saldo em uma certa quantia, um método sacar(), que diminui o saldo em uma certa quantia (se houver saldo suficiente), e os métodos equals() e toString(). O método equals() deve comparar duas contas com base em seus números (duas contas são iguais se tiverem o mesmo número). O método toString() deve retornar uma string contendo todas as informações da conta.</p>

<hr>

- <b>Parte 3:</b> Classe Banco
    - <p align="justify">Por fim, crie uma classe Banco que gerencie um conjunto de Conta. Ela deve ter um método criarConta() que crie uma nova conta e a adicione ao conjunto, um método buscarConta() que retorne uma conta dado o seu número, um método depositar() que receba o número de uma conta e uma quantia, e faça o depósito nessa conta, e um método sacar() que faça o saque de uma conta.</p>

<hr>

- <b>Parte 4:</b> Classe Teste
    - <p align="justify">Crie uma classe TesteBanco com um método main(), que imprime um menu, para que o usuário possa executar operações como criar conta, depositar, sacar e exibir os dados de uma conta. Para isso, você pode usar a classe Scanner para ler as opções do usuário e os dados necessários para cada operação.</p>
