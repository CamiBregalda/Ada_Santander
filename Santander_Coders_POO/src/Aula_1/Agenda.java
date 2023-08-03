
package Aula_1;

import java.util.Scanner;

public class Agenda {

    private Contato[] contatos;
    
    public Contato[] inicializarAgenda(){
        Contato contato1 = new Contato("Paula", "123456789");
        Contato contato2 = new Contato("Maria", "987654321");
        Contato contato3 = new Contato("Pedro", "111222333");
        Contato contato4 = new Contato("Ana", "444555666");
        
        contatos = new Contato[] {contato1, contato2, contato3, contato4};
        
        return contatos;
    }
    
    public void deletarContato(Contato contato) {
        Contato[] novaLista = new Contato[contatos.length - 1];
        int posicaoNovaLista = 0;
        
        for (int i = 0; i < contatos.length; i++) {
            String nomeContatoADeletar = contato.getNome();
            String numeroADeletar = contato.getNumero();
            
            String nomeContatoAtualDoFor = contatos[i].getNome();
            String numeroAtualDoFor = contatos[i].getNumero();
            
            if(!nomeContatoADeletar.equals(nomeContatoAtualDoFor) && !numeroADeletar.equals(numeroAtualDoFor)){
                novaLista[posicaoNovaLista] = contatos[i];
                posicaoNovaLista++;
            }
        }
        contatos = novaLista;
        System.out.println("Contato não encontrado na agenda.");
    }

    public Contato buscarContato(String nome) {
        for (int i = 0; i < contatos.length; i++) {
            if (contatos[i].getNome().equalsIgnoreCase(nome)) {
                return contatos[i];
            }
        }
        return null;
    }

    public void listarContatos() {
        int totalContatos = contatos.length;
        
        if (totalContatos == 0) {
            System.out.println("A agenda está vazia.");
            return;
        }

        System.out.println("Lista de contatos:");
        for (int i = 0; i < totalContatos; i++) {
            System.out.println((i + 1) + ". " + contatos[i].getNome() + " - " + contatos[i].getNumero());
        }
    }
}
