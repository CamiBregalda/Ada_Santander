package org.example.service.Interface;

import org.example.entity.Pessoa;
import org.example.entity.Veiculo;

import java.time.LocalDate;
import java.util.List;

public interface VeiculoServiceInterface {
    void cadastrarVeiculo(Veiculo veiculo);
    void atualizarVeiculo(Veiculo veiculo);
    List<Veiculo> listarVeiculos();
    List<Veiculo> listarVeiculosDisponiveis(LocalDate dataInicio, LocalDate dataDevolucao);
    Veiculo buscarVeiculoPorId(int id);
    List<Veiculo> buscarVeiculosPorNome(String nome);
    void deletarVeiculos(int id);
    boolean isDisponivelParaAluguel(int id, LocalDate dataInicio, LocalDate dataDevolucao);
    void bloquearDatas(int id, LocalDate dataInicio, LocalDate dataDevolucao);
}
