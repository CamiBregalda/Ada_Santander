package org.example.controller;

import org.example.entity.CategoriaPessoa;
import org.example.entity.Pessoa;
import org.example.entity.Sexo;
import org.example.service.PessoaService;
import org.example.utils.InputHandler;
import org.hibernate.SessionFactory;

import java.util.List;

public class PessoaController {

    private PessoaService pessoaService;

    public PessoaController(SessionFactory sessionFactory) {
        this.pessoaService = new PessoaService(sessionFactory);
    }

    public void cadastrarPessoa(){
        System.out.println("---- Cadastro de Usuário ----");
        String cpf = InputHandler.getStringInput("Digite o cpf do usuário: ");
        String nome = InputHandler.getStringInput("Digite o nome do usuário: ");
        int sexoValue = InputHandler.getIntInput("Digite o sexo do usuário: (1 - Feminino | 2 - Masculino | 3 - Outro)\n");
        Sexo sexo;
        switch (sexoValue){
            case 1: sexo = Sexo.FEMININO; break;
            case 2: sexo = Sexo.MASCULINO; break;
            case 3: sexo = Sexo.OUTRO; break;
            default: sexo = null; break;
        }
        int categoriaValue = InputHandler.getIntInput("Digite a categoria do usuário: (1 - Pessoa Física | 2 - Pessoa Jurídica)\n");
        CategoriaPessoa categoriaPessoa;
        switch (categoriaValue){
            case 1: categoriaPessoa = CategoriaPessoa.PJ; break;
            case 2: categoriaPessoa = CategoriaPessoa.PF; break;
            default: categoriaPessoa = null; break;
        }

        Pessoa pessoa = new Pessoa(cpf, nome, sexo, categoriaPessoa);
        pessoaService.cadastrarPessoa(pessoa);

        System.out.println("Usuário cadastrado com sucesso!");
    }

    public Pessoa buscarPessoaPorId() {
        System.out.println("---- Buscar de Usuário Por Id ----");
        int id = InputHandler.getIntInput("Digite o id do usuário: ");
        Pessoa pessoa = pessoaService.buscarPessoaPorId(id);
        return pessoa;
    }

    public List<Pessoa> buscarPessoaPorNome() {
        System.out.println("---- Buscar de Usuário Por Nome ----");
        String nome = InputHandler.getStringInput("Digite o nome do usuário: ");
        return pessoaService.buscarPessoasPorNome(nome);
    }

    public void atualizarPessoa(){
        System.out.println("---- Atualizar Dados do Usuário ----");
        int i, id = InputHandler.getIntInput("Informe o id do usuário: ");
        Pessoa pessoa = pessoaService.buscarPessoaPorId(id);

        if (pessoa != null) {
            do {
                int cod = InputHandler.getIntInput("Qual informação deseja alterar? (1 - CPF | 2 - Nome | 3 - Sexo | 4 - Categoria)");
                switch (cod) {
                    case 1: {
                        String cpf = InputHandler.getStringInput("Digite o número atualizado do cpf do usuário: ");
                        pessoa.setCpf(cpf);
                    }
                    case 2: {
                        String nome = InputHandler.getStringInput("Digite o nome atualizado do usuário: ");
                        pessoa.setNome(nome);
                    }
                    case 3: {
                        int sexoValue = InputHandler.getIntInput("Digite o sexo atualizado do usuário: (1 - Feminino | 2 - Masculino | 3 - Outro)\n");
                        Sexo sexo;
                        switch (sexoValue) {
                            case 1:
                                sexo = Sexo.FEMININO;
                                break;
                            case 2:
                                sexo = Sexo.MASCULINO;
                                break;
                            case 3:
                                sexo = Sexo.OUTRO;
                                break;
                            default:
                                sexo = null;
                                break;
                        }
                        pessoa.setSexo(sexo);
                    }
                    case 4: {
                        int categoriaValue = InputHandler.getIntInput("Digite a categoria atualizada do usuário: (1 - Pessoa Física | 2 - Pessoa Jurídica)\n");
                        CategoriaPessoa categoriaPessoa;
                        switch (categoriaValue) {
                            case 1:
                                categoriaPessoa = CategoriaPessoa.PJ;
                                break;
                            case 2:
                                categoriaPessoa = CategoriaPessoa.PF;
                                break;
                            default:
                                categoriaPessoa = null;
                                break;
                        }
                        pessoa.setCategoriaPessoa(categoriaPessoa);
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

    void listarPessoas(){
        List<Pessoa> pessoas = pessoaService.listarPessoas();

        for (Pessoa pessoa : pessoas){
            System.out.println(pessoa.toString() + "\n");
        }
    }

    void deletarPessoa() {
        System.out.println("---- Deletar Usuário Pelo Id ----");
        int id = InputHandler.getIntInput("Digite o id do usuário: ");
        pessoaService.deletarPessoa(id);
    }
}
