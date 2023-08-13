package Repository;

import Entity.Pedido;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PedidoRepository {
    private static List<Pedido> listaPedidos;

    public PedidoRepository() {
        this.listaPedidos = new ArrayList<>();
    }

    public static void adicionarPedido(Pedido pedido){
        listaPedidos.add(pedido);
    }

    public static void removerPedido(Pedido pedido){
        Iterator<Pedido> iterator = listaPedidos.iterator();
        while (iterator.hasNext()) {
            Pedido novo = iterator.next();
            if (novo.getNumeroPedido() == pedido.getNumeroPedido()) {
                iterator.remove();
                break;
            }
        }
    }

    public static Pedido buscarPedido(int numPedido){
        for (Pedido pedido : listaPedidos) {
            if (pedido.getNumeroPedido() == numPedido) {
                return pedido;
            }
        }
        return null;
    }

    public static List<Pedido> getListaPedidos() {
        return listaPedidos;
    }
}
