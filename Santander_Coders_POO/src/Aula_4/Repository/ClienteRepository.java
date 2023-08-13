package Repository;

import Entity.Cliente;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClienteRepository {
    private static List<Cliente> listaClientes;

    public ClienteRepository() {
        this.listaClientes = new ArrayList<>();
    }

    public static void adicionarCliente(Cliente cliente){
        listaClientes.add(cliente);
    }

    public static void removerCliente(Cliente cliente){
        Iterator<Cliente> iterator = listaClientes.iterator();
        while (iterator.hasNext()) {
            Cliente cliente1 = iterator.next();
            if (cliente1.getId() == cliente.getId()) {
                iterator.remove();
                break;
            }
        }
    }

    public static Cliente buscarCliente(int idCliente){
        for (Cliente cliente : listaClientes) {
            if (cliente.getId() == idCliente) {
                return cliente;
            }
        }
        return null;
    }

    public static List<Cliente> getListaClientes() {
        return listaClientes;
    }
}
