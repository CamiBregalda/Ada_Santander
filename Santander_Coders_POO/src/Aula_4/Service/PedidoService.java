package Service;

import Entity.Cliente;
import Entity.Pedido;
import Entity.Prato;
import Entity.Restaurante;
import Repository.ClienteRepository;
import Repository.PedidoRepository;
import Repository.PratoRepository;
import Repository.RestauranteRepository;

import java.util.List;
import java.util.stream.Collectors;

public class PedidoService {
    public static void cadastrarPedido(Pedido pedido){
        PedidoRepository.adicionarPedido(pedido);
    }

    public static Pedido buscarPedido(int id){
        return PedidoRepository.buscarPedido(id);
    }

    public static List<Pedido> listarPedidos(){
        return PedidoRepository.getListaPedidos();
    }

    public static List<Pedido> listarPedidosRestaurante(Integer id){
        Restaurante restaurante = RestauranteRepository.buscarRestaurante(id);
        if(restaurante != null) {
            return PedidoRepository.getListaPedidos().stream()
                    .filter(pedido -> pedido.getRestaurante().equals(restaurante))
                    .collect(Collectors.toList());
        }
        return null;
    }

    public static List<Pedido> listarPedidosCliente(Integer id){
        Cliente cliente = ClienteRepository.buscarCliente(id);
        if(cliente != null) {
            return PedidoRepository.getListaPedidos().stream()
                    .filter(pedido -> pedido.getCliente().equals(cliente))
                    .collect(Collectors.toList());
        }
        return null;
    }
}
