package Aula_2;

import java.util.Objects;

public class Cliente {
    
    private String nome;
    private String cpf;
    private String email;

    public Cliente(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public int hashCode() {
	return Objects.hash(cpf, email, nome);
    }
    
    @Override
    public boolean equals(Object cliente){
        if (this == cliente) return true;
        if (cliente == null) return false;
        if (cliente == null || getClass() != cliente.getClass()) return false;
        
        Cliente outroCliente = (Cliente) cliente;
        if (cpf.equals(outroCliente.cpf)){
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public String toString() {
        return "Cliente{" + "nome='" + nome + '\'' + ", cpf='" + cpf + '\'' + ", email='" + email + '\'' + '}';
    }
    
}
