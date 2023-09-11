package org.example.controller;

public class MenuController {
    private AluguelController aluguelController;
    private PessoaController pessoaController;
    private VeiculoController veiculoController;

    public void menu(){
        System.out.println("Menu de Operações:");
        System.out.println("____________________________________");
        System.out.println( "1) Cadastro de Usuário\n" +
                "2) Cadastro de Veículo\n" +
                "3) Realizar Aluguel de Veículo\n" +
                "4) Listar Todos os Veículos\n" +
                "5) Listar Veículos disponíveis em Determinado período\n" +
                "6) Listar Usuários\n" +
                "7) Alterar Informações de Um Usuário\n" +
                "8) Alterar Informações de Um Veículo\n" +
                "9) Buscar Veículo por ID\n" +
                "10) Buscar Usuário por ID\n" +
                "11) Buscar Veículo pelo nome\n" +
                "12) Buscar Usuário pelo nome\n" +
                "13) Deletar Veículo pelo Id\n" +
                "14) Deletar Usuário pelo Id\n" +
                "0) Encerrar aplicativo");
        System.out.println("____________________________________");
    }

    public void operacaoARealizar(int operacao){

        switch (operacao){
            case 1:
                pessoaController.cadastrarPessoa();
                break;
            case 2:
                veiculoController.cadastrarVeiculo();
                break;
            case 3:
                aluguelController.cadastrarAluguel();
                break;
            case 4:
                veiculoController.listarVeiculos();
                break;
            case 5:
                veiculoController.listarVeiculosDisponiveis();
                break;
            case 6:
                pessoaController.listarPessoas();
                break;
            case 7:
                pessoaController.atualizarPessoa();
                break;
            case 8:
                veiculoController.atualizarVeículo();
                break;
            case 9:
                veiculoController.buscarVeiculoPorId();
                break;
            case 10:
                pessoaController.buscarPessoaPorId();
                break;
            case 11:
                veiculoController.buscarVeiculoPorNome();
                break;
            case 12:
                pessoaController.buscarPessoaPorNome();
                break;
            case 13:
                veiculoController.deletarVeiculo();
                break;
            case 14:
                pessoaController.deletarPessoa();
                break;
            case 0:
                break;
            default:
                System.out.println("Valor inválido");
                break;
        }
    }
}
