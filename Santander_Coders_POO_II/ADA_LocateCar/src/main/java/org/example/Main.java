package org.example;

import org.example.controller.AluguelController;
import org.example.controller.MenuController;
import org.example.controller.PessoaController;
import org.example.controller.VeiculoController;
import org.example.repository.PessoaRepository;
import org.example.utils.InputHandler;
import org.example.utils.Instance;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = Instance.getSessionFactory();
        VeiculoController veiculoController = new VeiculoController(sessionFactory);
        PessoaController pessoaController = new PessoaController(sessionFactory);
        AluguelController aluguelController = new AluguelController(sessionFactory);
        MenuController menuController = new MenuController();

        System.out.println("Bem-vindo ao ADA LocateCar!");
        int opcao;

        do {
            System.out.println();
            menuController.menu();
            opcao = InputHandler.getIntInput("Qual a opção desejada? ");
            System.out.println();
            menuController.operacaoARealizar(opcao);
        } while (opcao != 0);

        Instance.closeSessionFactory();
    }
}