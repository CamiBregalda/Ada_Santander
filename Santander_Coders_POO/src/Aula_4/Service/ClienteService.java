package Service;

import Entity.Cliente;
import Repository.ClienteRepository;

import java.util.List;

public class ClienteService {
    public static void cadastrarCliente(Cliente cliente){
        ClienteRepository.adicionarCliente(cliente);
    }
    public static List<Cliente> listarClientes(){
        return ClienteRepository.getListaClientes();
    }

    public static Cliente buscarCliente(int id){
        return ClienteRepository.buscarCliente(id);
    }
}
