package Controller;

import Entity.Cliente;
import Entity.Pedido;
import Entity.Prato;
import Entity.Restaurante;
import Repository.PratoRepository;
import Repository.RestauranteRepository;
import Service.ClienteService;
import Service.PedidoService;
import Service.PratoService;
import Service.RestauranteService;
import Utils.InputHandler;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;

public class MenuController {
    public void exibirMenu(){
        while (true) {
            System.out.println("\nSistema de Pedidos de Restaurantes");
            System.out.println("1. Cadastrar Restaurante");
            System.out.println("2. Listar Restaurantes");
            System.out.println("3. Adicionar Prato");
            System.out.println("4. Listar Pratos de um Restaurante");
            System.out.println("5. Fazer um Pedido");
            System.out.println("6. Listar pedidos de um restaurante");
            System.out.println("7. Cadastrar um cliente");
            System.out.println("8. Ver Pedidos de um Cliente");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao;
            try {
                opcao = Utils.InputHandler.getIntInput("");
            } catch (InputMismatchException e) {
                opcao = InputHandler.getIntInput("Opção inválida! Por favor, insira um número.");
                continue;
            }
            switch (opcao) {
                case 1:
                    cadastrarRestaurante();
                    break;
                case 2:
                    listarRestaurantes();
                    break;
                case 3:
                    cadastrarPrato();
                    break;
                case 4:
                    listarPratosRestaurante();
                    break;
                case 5:
                    cadastrarPedido();
                    break;
                case 6:
                    listarPedidosRestaurante();
                    break;
                case 7:
                    cadastrarCliente(); 
                    break;
                case 8:
                    verPedidosCliente();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida!");
                    System.out.println();
            }
        }
    }

    private void cadastrarRestaurante(){
        System.out.println("\n---- Cadastro de Restaurante ----");
        Integer id = InputHandler.getIntInput("Digite o número de identificação do restaurante: ");
        if (RestauranteService.listarRestaurantes().containsKey(id)){
            System.out.println("Restaurante já cadastrado!");
        } else {
            String nome = InputHandler.getStringInput("Digite o nome do restaurante: ");
            String endereco = InputHandler.getStringInput("Digite o endereço do restaurante: ");
            Integer add, prato;
            List<Prato> pratosRestaurante = new ArrayList();
            do {
                prato = InputHandler.getIntInput("Digite o código do prato servido no restaurante: (Para finalizar, digite -1)\n");
                if (prato != -1) {
                    Prato pratoLista = PratoService.buscarPrato(prato);
                    if (pratoLista != null) {
                        if (!pratosRestaurante.contains(pratoLista)) {
                            pratosRestaurante.add(pratoLista);
                        } else {
                            System.out.println("Prato já cadastrado no restaurante!");
                        }
                    } else {
                        System.out.println("Prato não encontrado no sistema!");
                    }
                }
            } while (prato != -1);

            Restaurante restaurante = new Restaurante(id, nome, endereco, pratosRestaurante);
            RestauranteService.cadastrarRestaurante(restaurante);
            if (RestauranteService.buscarRestaurante(id) != null) {
                System.out.println("Cadastro realizado com sucesso!");
            }
        }
    }

    private void listarRestaurantes(){
        System.out.println("\n---- Listar restaurantes ----");
        Map<Integer, Restaurante> restaurantes = RestauranteService.listarRestaurantes();
        if (restaurantes.isEmpty()){
            System.out.println("Nenhum restaurante cadastrado!");
        } else {
            System.out.println("Lista de restaurantes cadastrados:");
            for (Restaurante restaurante : restaurantes.values()) {
                System.out.println(restaurante);
            }
        }
    }
    private void cadastrarPrato(){
        System.out.println("\n---- Cadastro de Prato ----");
        Integer idPrato = InputHandler.getIntInput("Digite o código de identificação do prato: ");
        if (PratoService.buscarPrato(idPrato) != null) {
            System.out.println("Prato já cadastrado!");
        } else {
            String nome = InputHandler.getStringInput("Digite o nome do prato: ");
            double preco = InputHandler.getDoubleInput("Digite o preço do prato: ");
            String descricao = InputHandler.getStringInput("Digite a descrição do prato: ");

            Prato prato = new Prato(idPrato, nome, preco, descricao);
            PratoService.cadastrarPrato(prato);
            if (PratoService.buscarPrato(idPrato) != null) {
                System.out.println("Cadastro realizado com sucesso!");
            }
        }
    }

    private void listarPratosRestaurante() {
        System.out.println("\n---- Listar pratos do restaurante ----");
        int idRestaurante = InputHandler.getIntInput("Digite o código de identificação do restaurante: ");
        Restaurante restaurante = RestauranteService.buscarRestaurante(idRestaurante);
        if (restaurante != null){
            List<Prato> listaPratos = PratoService.listarPratosRestaurante(restaurante.getId(), restaurante.getNome());
            List<Prato> copiaListaPratos = new ArrayList<>(PratoService.listarPratosRestaurante(restaurante.getId(), restaurante.getNome()));
            if (copiaListaPratos.isEmpty()){
                System.out.println("Nenhum Prato cadastrado!");
            } else {
                System.out.println("Lista de pratos cadastrados no restaurante " + restaurante.getNome() + ":");
                for (Prato prato : copiaListaPratos) {
                    System.out.println(prato);
                    System.out.println("---");
                }
            }
        }
    }

    private void cadastrarPedido(){
        System.out.println("\n---- Cadastro de Pedido ----");
        Integer id = InputHandler.getIntInput("Digite o código de identificação do pedido: ");
        if (PedidoService.listarPedidos().contains(id)) {
            System.out.println("Pedido já cadastrado!");
        } else {
            int idRestaurante = InputHandler.getIntInput("Digite o código de identificação do restaurante: ");
            Restaurante restaurante = RestauranteService.buscarRestaurante(idRestaurante);
            if (restaurante != null) {
                int idCliente = InputHandler.getIntInput("Digite o código de identificação do cliente: ");
                Cliente cliente = ClienteService.buscarCliente(idCliente);
                if (cliente != null) {
                    List<Prato> pratos = new ArrayList<>();
                    listarPratosRestaurante();
                    int cod;
                    do {
                        cod = InputHandler.getIntInput("Digite o prato requerido: (Ao finalizar, digite -1)\n");
                        if (cod != -1) {
                            Prato prato = PratoService.buscarPrato(id);
                            pratos.add(prato);
                        }
                    } while (cod != -1);
                    String enderecoEntrega = InputHandler.getStringInput("Digite o endereço de entrega do pedido: ");

                    Pedido pedido = new Pedido(id, restaurante, cliente, pratos, enderecoEntrega);
                    PedidoService.cadastrarPedido(pedido);
                    if (PedidoService.buscarPedido(id) != null) {
                        System.out.println("Cadastro realizado com sucesso!");
                    }
                } else {
                    System.out.println("Cliente não encontrado!");
                }
            } else {
                System.out.println("Restaurante não encontrado!");
            }
        }
    }

    private void listarPedidosRestaurante(){
        System.out.println("\n---- Listar Pedidos de um Restaurante ----");
        int idRestaurante = InputHandler.getIntInput("Digite o código de identificação do restaurante: ");
        Restaurante restaurante = RestauranteService.buscarRestaurante(idRestaurante);
        if (restaurante != null){
            List<Pedido> listaPedidos = PedidoService.listarPedidosRestaurante(restaurante.getId());
            if (listaPedidos.isEmpty()){
                System.out.println("Nenhum pedido cadastrado!");
            } else {
                System.out.println("Lista de pratos cadastrados no restaurante " + restaurante.getNome() + ":");
                for (Pedido pedido : listaPedidos) {
                    System.out.println(pedido);
                    System.out.println("---");
                }
            }
        }
    }

    private void cadastrarCliente(){
        System.out.println("\n---- Cadastro de Cliente ----");

        Integer id = InputHandler.getIntInput("Digite o código de identificação do cliente: ");

        if (ClienteService.listarClientes().contains(id)) {
            System.out.println("Cliente já cadastrado!");
        } else {
            String nome = InputHandler.getStringInput("Digite o nome do cliente: ");

            Cliente cliente = new Cliente(id, nome);
            ClienteService.cadastrarCliente(cliente);
            if (ClienteService.buscarCliente(id) != null) {
                System.out.println("Cadastro realizado com sucesso!");
            }
        }
    }

    private void verPedidosCliente(){
        System.out.println("\n---- Listar Pedidos de um Cliente ----");
        int id = InputHandler.getIntInput("Digite o código de identificação do cliente: ");
        Cliente cliente = ClienteService.buscarCliente(id);
        if (cliente != null){
            List<Pedido> listaPedidos = PedidoService.listarPedidosCliente(cliente.getId());
            if (listaPedidos.isEmpty()){
                System.out.println("Nenhum pedido cadastrado!");
            } else {
                System.out.println("Lista de pedidos co cliente " + cliente.getNome() + ":");
                for (Pedido pedido : listaPedidos) {
                    System.out.println(pedido);
                    System.out.println("---");
                }
            }
        }
    }
}
