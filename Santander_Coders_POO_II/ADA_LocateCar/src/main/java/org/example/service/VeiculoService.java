package org.example.service;

import org.example.entity.Pessoa;
import org.example.entity.Veiculo;
import org.example.repository.PessoaRepository;
import org.example.repository.VeiculoRepository;
import org.example.service.Interface.VeiculoServiceInterface;
import org.hibernate.SessionFactory;

import java.time.LocalDate;
import java.util.List;

public class VeiculoService implements VeiculoServiceInterface {
    private VeiculoRepository veiculoRepository;

    public VeiculoService(SessionFactory sessionFactory) {
        this.veiculoRepository = new VeiculoRepository(sessionFactory);
    }

    @Override
    public void cadastrarVeiculo(Veiculo veiculo){
        try{
            veiculoRepository.cadastrarVeiculos(veiculo);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void atualizarVeiculo(Veiculo veiculo){
        try{
            veiculoRepository.atualizarVeiculo(veiculo);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Veiculo> listarVeiculos(){
        try{
            return veiculoRepository.listarVeiculos();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Veiculo> listarVeiculosDisponiveis(LocalDate dataInicio, LocalDate dataDevolucao){
        try{
            return veiculoRepository.listarVeiculosDisponiveis(dataInicio, dataDevolucao);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Veiculo buscarVeiculoPorId(int id){
        try{
            return veiculoRepository.buscarVeiculoPorId(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Veiculo> buscarVeiculosPorNome(String nome){
        try{
            return veiculoRepository.buscarVeiculoPorNome(nome);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void deletarVeiculos(int id){
        try{
            veiculoRepository.deletarVeiculo(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean isDisponivelParaAluguel(int id, LocalDate dataInicio, LocalDate dataDevolucao){
        try{
            return veiculoRepository.isDisponivelParaAluguel(id, dataInicio, dataDevolucao);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void bloquearDatas(int id, LocalDate dataInicio, LocalDate dataDevolucao){
        try{
            veiculoRepository.bloquearDatas(id, dataInicio, dataDevolucao);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
