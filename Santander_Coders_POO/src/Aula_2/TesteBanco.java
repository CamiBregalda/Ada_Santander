package Aula_2;

import java.util.Scanner;

public class TesteBanco {

     public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);
        
        int sair, opcao;
        
        do{
            imprimirMenu();
            opcao = scanner.nextInt();

            switch (opcao){
                case 1: {
                    System.out.print("Digite o nome do cliente: ");
                    String nome = scanner.next();
                        
                    System.out.print("Digite o CPF do cliente: ");
                    String cpf = scanner.next();
                    if (banco.checarCliente(cpf)){
                        System.out.println("Cliente já existente!");
                    }
        
                    System.out.print("Digite o e-mail do cliente: ");
                    String email = scanner.next();

                    System.out.print("Digite a conta do cliente: ");
                    int conta = scanner.nextInt();

                    Cliente cliente = new Cliente(nome, cpf, email);
                    banco.criarConta(cliente, conta);
                    
                    break;
                }
                case 2: {
                    System.out.println("Digite o número da conta: ");
                    int conta = scanner.nextInt();
                    System.out.println("Qual o valor a ser depositado?");   
                    double valor = scanner.nextDouble();

                    if (banco.depositar(conta, valor)) {
                        System.out.println("Depósito realizado com sucesso!");
                    } else {
                        System.out.println("Erro ao realizar o depósito!");
                    }
                    break;
                }
                case 3: {
                    System.out.println("Digite o número da conta: ");
                    int conta = scanner.nextInt();
                    System.out.println("Qual o valor a ser saquado?");   
                    double valor = scanner.nextDouble();

                    if (banco.sacar(conta, valor)) {
                        System.out.println("Saque realizado com sucesso!");
                    } else {
                        System.out.println("Erro ao realizar saque!");
                    }
                    break;
                }
                case 4: {
                    System.out.print("Digite a conta a ser exibida: ");
                    int numeroConta = scanner.nextInt();

                    Conta conta = banco.buscarConta(numeroConta);

                    if (conta != null) {
                        System.out.println("\n" + conta);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;
                }
                default:
                    System.out.println("Opção inválida!");
            }
            
            System.out.println("\nDeseja realizar outra ação? (1 - sim | 2 - não)");
            sair = scanner.nextInt();
        } while(sair == 1);
    }
    
    public static void imprimirMenu() {
        System.out.println("---- Menu ----");
        System.out.println("1 - Criar conta");
        System.out.println("2 - Depositar");
        System.out.println("3 - Sacar");
        System.out.println("4 - Exibir dados de uma conta");
        System.out.print("Qual a opção desejada: ");
    }
    
    public void sacar(){
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite o número da conta: ");
        int conta = scanner.nextInt();
        System.out.println("Qual o valor a ser depositado?");   
        double valor = scanner.nextDouble();
        
        if (banco.sacar(conta, valor)) {
            System.out.println("Saque realizado com sucesso!");
	} else {
            System.out.println("Erro ao realizar saque!");
	}
    }
    
    public void depositar(){
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite o número da conta: ");
        int conta = scanner.nextInt();
        System.out.println("Qual o valor a ser depositado?");   
        double valor = scanner.nextDouble();
        
        if (banco.depositar(conta, valor)) {
            System.out.println("Depósito realizado com sucesso!");
	} else {
            System.out.println("Erro ao realizar o depósito!");
	}
    }
    
    public void criarConta(){
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
        
        if (banco.checarCliente(cpf)){
            System.out.println("Cliente já existente!");
        } else { 
            System.out.print("Digite o nome do cliente: ");
            String nome = scanner.nextLine();

            System.out.print("Digite o e-mail do cliente: ");
            String email = scanner.nextLine();

            System.out.print("Digite a conta do cliente: ");
            int conta = scanner.nextInt();

            Cliente cliente = new Cliente(nome, cpf, email);
            banco.criarConta(cliente, conta);
        }
    }
    
    public void exibirDados(){
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite a conta a ser exibida: ");
        int numeroConta = scanner.nextInt();
        
        Conta conta = banco.buscarConta(numeroConta);
        
        if (conta == null) {
            System.out.println(conta);
        } else {
            System.out.println("Conta não encontrada.");
        }
    }
}
