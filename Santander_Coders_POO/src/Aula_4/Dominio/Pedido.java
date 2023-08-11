package Aula_4.Dominio;

import Aula_4.Dominio.Prato;
import Aula_4.Dominio.Restaurante;
import java.util.List;

public class Pedido {
    private Restaurante restaurante;
    private List<Prato> prato;
    private String enderecoEntrega;

    public Pedido(Restaurante restaurante, List<Prato> prato, String enderecoEntrega) {
        this.restaurante = restaurante;
        this.prato = prato;
        this.enderecoEntrega = enderecoEntrega;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public List<Prato> getPrato() {
        return prato;
    }

    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }
}