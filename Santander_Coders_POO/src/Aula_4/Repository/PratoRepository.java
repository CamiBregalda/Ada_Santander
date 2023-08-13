package Repository;

import Entity.Pedido;
import Entity.Prato;
import Entity.Restaurante;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PratoRepository {
    private static Map<Integer, Prato> listaPratos;

    public PratoRepository() {
        this.listaPratos = new HashMap<>();
    }

    public static void adicionarPrato(Prato prato){
        listaPratos.put(prato.getId(), prato);
    }

    public static void removerPrato(Prato prato){
        Iterator<Map.Entry<Integer, Prato>> iterator = listaPratos.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Prato> entry = iterator.next();
            if (entry.getKey() == prato.getId()) {
                iterator.remove();
                break;
            }
        }
    }

    public static Prato buscarPrato(int id){
        for (Prato pratos : listaPratos.values()){
            if (pratos.getId() == id){
                return pratos;
            }
        }

        return null;
    }

    public static Map<Integer, Prato> getListaPratos() {
        return listaPratos;
    }
}
