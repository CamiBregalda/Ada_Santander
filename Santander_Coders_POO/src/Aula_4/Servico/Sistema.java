package Aula_4.Servico;

import Aula_4.Dominio.Pedido;
import Aula_4.Repositorio.Data;
import Aula_4.Dominio.Restaurante;
import Aula_4.Dominio.Prato;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sistema {
    public static void cadastrarRestaurante(String nome, String endereco, List<Prato> pratosDisponiveis){
        Restaurante restaurante = new Restaurante(nome, endereco, pratosDisponiveis);
        Data.adicionarRestaurante(restaurante);
    }

    public static void adicionarPrato(String nome, double preco, String descricao){
        Prato prato = new Prato(nome, preco, descricao);
        Data.adicionarPrato(prato);
    }

    public static void realizarPedido(Restaurante restaurante, List<Prato> prato, String enderecoEntrega){
        Pedido pedido = new Pedido(restaurante, prato, enderecoEntrega);
        Data.adicionarPedido(pedido);
    }

    public static void listarRestaurantes(Map<String, Restaurante> restaurantes){
        for (Restaurante listaRestaurante : restaurantes.values()) {
            System.out.println("Nome: " + listaRestaurante.getNome() + " | Endereço: " + listaRestaurante.getEndereco());
        }
    }

    public static void listarPratos(Map<String, Prato> pratos){}

    public static void listarPedidosRestaurante(){}

    public static void verPedidos(){}
}