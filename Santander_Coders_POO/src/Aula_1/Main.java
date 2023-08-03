/*Modele a classe AGENDA que contém um array de contatos como atributo e os seguintes métodos:
   deletar(Contato);
   buscar(String);

Modele uma classe CONTATO com os devidos atributos e os seguintes métodos:
    ligar()
    detalhar()
    verNumero()

crie vários contatos e coloque-os em uma classe Agenda;

no método main, faça a impressão usando cada método*/

package Aula_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Agenda agenda = new Agenda();
        Contato[] contato = agenda.inicializarAgenda();
        agenda.listarContatos();
        
        System.out.println("\nQual o nome do contato que deseja interajir:");
        String busca = scanner.nextLine();
        
        System.out.println("\nQual ação deseja realizar: \n1 - Detalhar contato \n2 - Ligar para o contato \n3 - Ver número \n4 - Deletar número");
        int dec = scanner.nextInt();
        
        if (busca != null) {
            Contato contatoBuscado = agenda.buscarContato(busca);
            if(dec == 1){
                contatoBuscado.detalhar();
            } else if (dec == 2) {
                contatoBuscado.ligar();
            } else if (dec == 3) {
                contatoBuscado.verNumero();
            } else if (dec == 4) {
                agenda.deletarContato(contatoBuscado);
                System.out.println();
                agenda.listarContatos();
            }
            
        } else {
            System.out.println("Contato não encontrado.");
        }
    }
}
