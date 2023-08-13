package Entity;

import Entity.Prato;
import Entity.Restaurante;
import Service.ClienteService;

import java.util.List;

public class Pedido {
    private static Integer ultimoNumeroPedido = 0;
    private int numeroPedido;
    private Restaurante restaurante;
    private Cliente cliente;
    private List<Prato> prato;
    private String enderecoEntrega;

    public Pedido(int numeroPedido, Restaurante restaurante, Cliente cliente, List<Prato> prato, String enderecoEntrega) {
        this.numeroPedido = ++ultimoNumeroPedido;
        this.restaurante = restaurante;
        this.cliente = cliente;
        this.prato = prato;
        this.enderecoEntrega = enderecoEntrega;
    }

    public int getNumeroPedido() {
        return numeroPedido;
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

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nNúmero do pedido: ").append(numeroPedido).append("\nRestaurante: ").append(restaurante).append("\nEndereco da entrega: ").append(enderecoEntrega).append("\nPratos: ");
        if (prato.isEmpty()) {
            stringBuilder.append("Nenhum prato disponível");
        } else {
            for (Prato pratos : prato) {
                stringBuilder.append(pratos.getNome()).append(", ");
            }
        }
        return stringBuilder.toString();
    }
}