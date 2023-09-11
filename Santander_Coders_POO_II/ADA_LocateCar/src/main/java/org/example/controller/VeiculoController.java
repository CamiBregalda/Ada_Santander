package org.example.controller;

import org.example.entity.*;
import org.example.service.VeiculoService;
import org.example.utils.InputHandler;
import org.hibernate.SessionFactory;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

public class VeiculoController {
    private VeiculoService veiculoService;

    public VeiculoController(SessionFactory sessionFactory) {
        this.veiculoService = new VeiculoService(sessionFactory);
    }

    void cadastrarVeiculo(){
        System.out.println("---- Cadastro de Veículo ----");
        String placa = InputHandler.getStringInput("Digite o número da placa do veículo: ");
        String modelo = InputHandler.getStringInput("Digite o modelo do veículo: ");
        int categoriaValue = InputHandler.getIntInput("Digite a categoria do veículo: (1 - Pequeno | 2 - Medio | 3 - SUV)\n");
        CategoriaVeiculo categoriaVeiculo;
        switch (categoriaValue) {
            case 1: categoriaVeiculo = CategoriaVeiculo.PEQUENO; break;
            case 2: categoriaVeiculo = CategoriaVeiculo.MEDIO; break;
            case 3: categoriaVeiculo = CategoriaVeiculo.SUV; break;
            default: categoriaVeiculo = null; break;
        }

        Veiculo veiculo = new Veiculo(placa, modelo, categoriaVeiculo);
        veiculoService.cadastrarVeiculo(veiculo);

        System.out.println("Veículo cadastrado com sucesso!");
    }

    Veiculo buscarVeiculoPorId() {
        System.out.println("---- Buscar de Veículo Por Id ----");
        int id = InputHandler.getIntInput("Digite o id do veículo: ");
        Veiculo veiculo = veiculoService.buscarVeiculoPorId(id);
        return veiculo;
    }

    List<Veiculo> buscarVeiculoPorNome() {
        System.out.println("---- Buscar de Veículo Por Modelo ----");
        String modelo = InputHandler.getStringInput("Digite o modelo do veículo: ");
        return veiculoService.buscarVeiculosPorNome(modelo);
    }

    void atualizarVeículo(){
        System.out.println("---- Atualizar Dados do Veículo ----");
        int i, id = InputHandler.getIntInput("Informe o id do veículo: ");
        Veiculo veiculo = veiculoService.buscarVeiculoPorId(id);

        if (veiculo != null) {
            do {
                int cod = InputHandler.getIntInput("Qual informação deseja alterar? (1 - Placa | 2 - Modelo | 3 - Categoria)");
                switch (cod) {
                    case 1: {
                        String placa = InputHandler.getStringInput("Digite o número atualizado da placa do veículo: ");
                        veiculo.setPlaca(placa);
                    }
                    case 2: {
                        String modelo = InputHandler.getStringInput("Digite o modelo atualizado do veículo: ");
                        veiculo.setModelo(modelo);
                    }
                    case 3: {
                        int categoriaValue = InputHandler.getIntInput("Digite a categoria atualizada do veículo: (1 - Pequeno | 2 - Medio | 3 - SUV)\n");
                        CategoriaVeiculo categoriaVeiculo;
                        switch (categoriaValue) {
                            case 1:
                                categoriaVeiculo = CategoriaVeiculo.PEQUENO;
                                break;
                            case 2:
                                categoriaVeiculo = CategoriaVeiculo.MEDIO;
                                break;
                            case 3:
                                categoriaVeiculo = CategoriaVeiculo.SUV;
                                break;
                            default:
                                categoriaVeiculo = null;
                                break;
                        }
                        veiculo.setCategoriaVeiculo(categoriaVeiculo);
                    } default: {
                        System.out.println("Código inválido!");
                    }
                }
                i = InputHandler.getIntInput("Deseja alterar mais alguma informação? (1 - Sim | 2 - Não)");
            } while(i == 1);
        } else {
            System.out.println("Código não encontrado!");
        }
    }

    void listarVeiculos(){
        System.out.println("---- Listar Todos os Veículos ----");
        List<Veiculo> veiculos = veiculoService.listarVeiculos();

        for (Veiculo veiculo : veiculos){
            System.out.println(veiculo.toString() + "\n");
        }
    }

    void listarVeiculosDisponiveis(){
        System.out.println("---- Listar Veículos Disponíveis ----");
        try{
            LocalDate inicio = InputHandler.getLocalDateInput("Digite a data de início do período desejado: (dd/MM/yyyy): ");
            LocalDate termino = InputHandler.getLocalDateInput("Digite a data de término do período desejado: (dd/MM/yyyy): ");

            List<Veiculo> veiculos = veiculoService.listarVeiculosDisponiveis(inicio, termino);

            for (Veiculo veiculo : veiculos){
                System.out.println(veiculo.toString() + "\n");
            }
        } catch (DateTimeParseException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    void deletarVeiculo() {
        System.out.println("---- Deletar Veículo Pelo Id ----");
        int id = InputHandler.getIntInput("Digite o id do veículo: ");
        veiculoService.deletarVeiculos(id);
    }
}
