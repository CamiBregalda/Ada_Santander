package Aula_4.Repositorio;

import Aula_4.Dominio.Restaurante;
import Aula_4.Dominio.Prato;
import Aula_4.Dominio.Pedido;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data {
                   //<Nome, Restaurante>
    private static Map<String, Restaurante> listaRestaurantes = new HashMap<>();
    private static Map<String, Prato> listaPratos = new HashMap<>();
    private static List<Pedido> listaPedidos = new ArrayList<>();

    public static void adicionarRestaurante(Restaurante restaurante){
        listaRestaurantes.put(restaurante.getNome(), restaurante);
    }

    public static void adicionarPrato(Prato prato){
        listaPratos.put(prato.getNome(), prato);
    }

    public static void adicionarPedido(Pedido pedido){
        listaPedidos.add(pedido);
    }

    public static Map<String, Restaurante> getListaRestaurantes() {
        return listaRestaurantes;
    }

    public static Map<String, Prato> getListaPratos() {
        return listaPratos;
    }

    public static List<Pedido> getListaPedidos() {
        return listaPedidos;
    }
}
