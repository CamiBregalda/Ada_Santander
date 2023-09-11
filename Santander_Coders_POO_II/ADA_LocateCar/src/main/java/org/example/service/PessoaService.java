package org.example.service;

import org.example.entity.Pessoa;
import org.example.repository.PessoaRepository;
import org.example.service.Interface.PessoaServiceInterface;
import org.hibernate.SessionFactory;

import java.util.List;

public class PessoaService implements PessoaServiceInterface {
    private PessoaRepository pessoaRepository;

    public PessoaService(SessionFactory sessionFactory) {
        this.pessoaRepository = new PessoaRepository(sessionFactory);
    }

    @Override
    public void cadastrarPessoa(Pessoa pessoa){
        try{
            pessoaRepository.cadastrarPessoas(pessoa);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void atualizarPessoa(Pessoa pessoa){
        try{
            pessoaRepository.atualizarPessoa(pessoa);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Pessoa> listarPessoas(){
        try{
            return pessoaRepository.listarPessoas();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Pessoa buscarPessoaPorId(int id){
        try{
            return pessoaRepository.buscarPessoaPorId(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Pessoa> buscarPessoasPorNome(String nome){
        try{
            return pessoaRepository.buscarPessoasPorNome(nome);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void deletarPessoa(int id){
        try{
            pessoaRepository.deletarPessoa(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
