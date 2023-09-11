package org.example.controller;

import org.example.entity.*;
import org.example.service.AluguelService;
import org.example.service.PessoaService;
import org.example.service.VeiculoService;
import org.example.utils.InputHandler;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class AluguelController {

    private AluguelService aluguelService;
    private VeiculoService veiculoService;
    private PessoaService pessoaService;

    public AluguelController(SessionFactory sessionFactory) {
        this.aluguelService = new AluguelService(sessionFactory);
    }


    public void cadastrarAluguel(){
        System.out.println("---- Cadastro de Aluguel ----");
        String localEntrega = InputHandler.getStringInput("Digite o local onde será efetuada a entrega do carro: ");
        String localDevolucao = InputHandler.getStringInput("Digite o local onde será efetuada a devolução do carro: ");
        int idPessoa = InputHandler.getIntInput("Digite o id do usuário: ");
        Pessoa pessoa = pessoaService.buscarPessoaPorId(idPessoa);
        if (pessoa != null) {

            int idVeiculo = InputHandler.getIntInput("Digite o id do carro: ");
            Veiculo carro = veiculoService.buscarVeiculoPorId(idVeiculo);
            if (carro != null) {
                LocalDate inicio = InputHandler.getLocalDateInput("Digite a data de início do aluguel (dd/MM/yyyy): ");
                LocalDate termino = InputHandler.getLocalDateInput("Digite a data de término do aluguel (dd/MM/yyyy): ");
                veiculoService.isDisponivelParaAluguel(idVeiculo, inicio, termino);
                LocalTime horarioEntrega = InputHandler.getLocalTimeInput("Digite o horário de entrega (HH:MM): ");
                LocalTime horarioDevolucao = InputHandler.getLocalTimeInput("Digite o horário de devolução (HH:MM): ");

                BigDecimal valorTotal = valorAluguel(diasAlugados(inicio, termino, horarioEntrega, horarioDevolucao), carro.getCategoriaVeiculo(), pessoa);

                LocalDate dataPedido = LocalDate.now(); //Pegar a data atual
                Aluguel aluguel = new Aluguel(localEntrega, localDevolucao, dataPedido, inicio, termino, horarioEntrega, horarioDevolucao, valorTotal, carro, pessoa);
                aluguelService.cadastrarAluguel(aluguel);
                veiculoService.bloquearDatas(idVeiculo, inicio, termino);
                System.out.println("Aluguel cadastrado com sucesso!");
            } else {
                System.out.println("Código do veículo não encontrado!");
            }
        } else {
            System.out.println("Código do usuário não encontrado!");
        }
    }

    private long diasAlugados(LocalDate dataInicio, LocalDate dataTermino, LocalTime horarioInicio, LocalTime horarioTermino){
        LocalDateTime inicio = LocalDateTime.of(dataInicio, horarioInicio);
        LocalDateTime termino = LocalDateTime.of(dataTermino, horarioInicio);

        if (horarioTermino.isBefore(horarioInicio)) {
            return Duration.between(inicio, termino).toDays();
        } else {
            return Duration.between(inicio, termino).toDays() + 1;
        }
    }

    private BigDecimal valorAluguel(long dias, CategoriaVeiculo categoriaVeiculo, Pessoa pessoa){
        BigDecimal valorDiaria;

        switch (categoriaVeiculo) {
            case PEQUENO: valorDiaria = new BigDecimal("100.00"); break;
            case MEDIO: valorDiaria = new BigDecimal("150.00"); break;
            case SUV: valorDiaria = new BigDecimal("200.00"); break;
            default: throw new IllegalArgumentException("Categoria de veículo desconhecida: " + categoriaVeiculo);
        }

        BigDecimal valorTotal = valorDiaria.multiply(BigDecimal.valueOf(dias));

        if (pessoa != null && pessoa.getCategoriaPessoa() == CategoriaPessoa.PF && dias > 5) {
            BigDecimal desconto = valorTotal.multiply(new BigDecimal("0.05"));
            valorTotal = valorTotal.subtract(desconto);
        }

        if (pessoa != null && pessoa.getCategoriaPessoa() == CategoriaPessoa.PJ && dias > 3) {
            BigDecimal desconto = valorTotal.multiply(new BigDecimal("0.10"));
            valorTotal = valorTotal.subtract(desconto);
        }

        return valorTotal;
    }
}
