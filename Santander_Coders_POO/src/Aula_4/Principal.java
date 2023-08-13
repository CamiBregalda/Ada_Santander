import Controller.MenuController;
import Repository.ClienteRepository;
import Repository.PedidoRepository;
import Repository.PratoRepository;
import Repository.RestauranteRepository;

public class Principal {
    public static void main(String[] args) {
        RestauranteRepository restauranteRepository = new RestauranteRepository();
        PratoRepository pratoRepository = new PratoRepository();
        PedidoRepository pedidoRepository = new PedidoRepository();
        ClienteRepository clienteRepository = new ClienteRepository();

        MenuController menu = new MenuController();
        menu.exibirMenu();
    }
}