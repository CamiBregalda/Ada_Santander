package org.example.service.Interface;

import org.example.entity.Pessoa;

import java.util.List;

public interface PessoaServiceInterface {
    void cadastrarPessoa(Pessoa pessoa);
    void atualizarPessoa(Pessoa pessoa);
    List<Pessoa> listarPessoas();
    Pessoa buscarPessoaPorId(int id);
    List<Pessoa> buscarPessoasPorNome(String nome);
    void deletarPessoa(int id);
}
