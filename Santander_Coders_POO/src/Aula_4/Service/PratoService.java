package Service;

import Entity.Prato;
import Repository.PratoRepository;
import Repository.RestauranteRepository;

import java.util.List;
import java.util.Map;

public class PratoService {
    public static void cadastrarPrato(Prato prato){
        PratoRepository.adicionarPrato(prato);
    }
    public static Map<Integer, Prato> listarPratos(){
        return PratoRepository.getListaPratos();
    }

    public static Prato buscarPrato(int id){
        return PratoRepository.buscarPrato(id);
    }

    public static List<Prato> listarPratosRestaurante(Integer id, String nome){
        List<Prato> pratos = RestauranteRepository.listarPratosRestaurante(id, nome);
        return pratos;
    }
}
