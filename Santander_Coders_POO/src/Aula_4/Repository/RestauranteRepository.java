package Repository;

import Entity.Prato;
import Entity.Restaurante;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RestauranteRepository {
                   //<Nome, Restaurante>
    private static Map<Integer, Restaurante> listaRestaurantes;

    public RestauranteRepository(){
        this.listaRestaurantes = new HashMap<>();
    }

    public static void adicionarRestaurante(Restaurante restaurante){
        listaRestaurantes.put(restaurante.getId(), restaurante);
    }

    public static void removerRestaurante(Restaurante restaurante){
        Iterator<Map.Entry<Integer, Restaurante>> iterator = listaRestaurantes.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Restaurante> entry = iterator.next();
            if (entry.getKey() == restaurante.getId()) {
                iterator.remove();
                break;
            }
        }
    }
    public static Restaurante buscarRestaurante(int id){
        for (Restaurante restaurante : listaRestaurantes.values()){
            if (restaurante.getId() == id){
                return restaurante;
            }
        }

        return null;
    }

    public static Map<Integer, Restaurante> getListaRestaurantes() {
        return listaRestaurantes;
    }

    public static List<Prato> listarPratosRestaurante(Integer id, String nome){
        Restaurante restaurante = buscarRestaurante(id);
        if (restaurante != null) {
            List<Prato> pratos = restaurante.getPratosDisponiveis();
            for (Prato prato : pratos) {
                if (prato.getNome().equalsIgnoreCase(nome) && prato.getId() == id) {
                    pratos.add(prato);
                }
            }

            return pratos;
        } else {
            return null;
        }
    }
}
