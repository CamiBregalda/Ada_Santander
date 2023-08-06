package Aula_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Banco {
    private ArrayList<Conta> contas;

    public Banco() {
	contas = new ArrayList<>();
    }

    public ArrayList<Conta> getContas() {
    	return contas;
    }

    public void setContas(ArrayList<Conta> contas) {
    	this.contas = contas;
    }
		
    public void criarConta(Cliente cliente, int numero) {
        Conta conta = new Conta(cliente, numero, 0.0);
        contas.add(conta);
    }

    public Conta buscarConta(int numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumeroConta() == numeroConta) {
                return conta;
            }
        }
        return null;
    }
        
    public boolean checarCliente(String numeroCPF) {
        for (Conta conta : contas) {
            if (conta.getCliente().getCpf().equals(numeroCPF)) {
                return true;
            }
        }        
        return false;
    }

    public boolean depositar(int numeroConta, double valor) {
        Conta conta = buscarConta(numeroConta);
        if (conta != null) {
            conta.depositar(valor);
            return true;
        } else {
            return false;
        }
    }

    public boolean sacar(int numeroConta, double valor) {
        Conta conta = buscarConta(numeroConta);
        if (conta != null) {
            return conta.sacar(valor);
        } else {
            return false;
        }
    }
    
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Banco other = (Banco) obj;
            return Objects.equals(contas, other.contas);
    }
    
    @Override
    public int hashCode() {
	return Objects.hash(contas);
    }
    
    @Override
    public String toString() {
	return "Banco [contas=" + contas + "]";
    }
}
