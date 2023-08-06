package Aula_2;

public class Conta {
    
    private Cliente cliente;
    private int numeroConta;
    private double saldo;

    public Conta(Cliente cliente, int numero, double saldo) {
            this.cliente = cliente;
            this.numeroConta = numero;
            this.saldo = saldo;
	}

	public Cliente getCliente() {
            return cliente;
	}

	public void setCliente(Cliente cliente) {
            this.cliente = cliente;
	}

	public int getNumeroConta() {
            return numeroConta;
	}

	public void setNumeroConta(int numero) {
            this.numeroConta = numero;
	}

	public double getSaldo() {
            return saldo;
	}

	public void setSaldo(double saldo) {
            this.saldo = saldo;
	}
	
	public void depositar(double quantia) {
            saldo += quantia;
    }

    public boolean sacar(double quantia) {
        if (quantia <= saldo) {
            saldo -= quantia;
            return true;
        } else {
            System.out.println("Saldo Insuficiente!");
            return false;
        }
    }
    
    @Override
    public boolean equals(Object conta){
        if (this == conta) return true;
        if (conta == null) return false;
        
        if (conta == null || getClass() != conta.getClass()) return false;
        
        Conta outraConta = (Conta) conta;
        if (numeroConta == outraConta.numeroConta){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "---- Dados da Conta ----\nNome: "+ cliente.getNome() + "\nCPF de " + cliente.getNome() + ": " + cliente.getCpf() + "\nNúmero da Conta: " + numeroConta + "\nSaldo: " + saldo;
    }
    
    
}
