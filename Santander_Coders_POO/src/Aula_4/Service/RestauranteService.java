package Service;

import Entity.Restaurante;
import Repository.RestauranteRepository;
import java.util.Map;

public class RestauranteService {
    public static void cadastrarRestaurante(Restaurante restaurante){
        RestauranteRepository.adicionarRestaurante(restaurante);
    }
    public static Map<Integer, Restaurante> listarRestaurantes(){
        return RestauranteRepository.getListaRestaurantes();
    }

    public static Restaurante buscarRestaurante(int id){
        return RestauranteRepository.buscarRestaurante(id);
    }
}