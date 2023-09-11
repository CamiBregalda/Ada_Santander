package org.example.repository;

import lombok.NoArgsConstructor;
import org.example.entity.Pessoa;
import org.example.entity.Veiculo;
import org.example.utils.Instance;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@NoArgsConstructor
public class PessoaRepository {

    private SessionFactory sessionFactory;

    public PessoaRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void cadastrarPessoas(Pessoa pessoa){
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(pessoa);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Pessoa buscarPessoaPorId(int id){
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Pessoa pessoa = session.get(Pessoa.class, id);

            session.getTransaction().commit();

            return pessoa;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<Pessoa> listarPessoas(){
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            System.out.println("Usuários: ");

            List<Pessoa> pessoas = session.createQuery("SELECT p FROM Pessoa p", Pessoa.class)
                    .getResultList();

            session.getTransaction().commit();

            return pessoas;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList(); // Retorna uma lista vazia em caso de erro.
        } finally {
            session.close();
        }
    }

    public List<Pessoa> buscarPessoasPorNome(String nome) {
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            List<Pessoa> pessoas = session.createQuery("SELECT p FROM Pessoa p WHERE p.nome LIKE :nome", Pessoa.class)
                    .setParameter("nome", nome + "%") // % corresponde a qualquer sequência após o nome
                    .getResultList();

            session.getTransaction().commit();

            return pessoas;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        } finally {
            session.close();
        }
    }

    public void atualizarPessoa(Pessoa pessoa) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(pessoa);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletarPessoa(int id){
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Pessoa pessoa = session.get(Pessoa.class, id);

            if (pessoa != null) {
                session.delete(pessoa);
                session.getTransaction().commit();
                System.out.println("Pessoa excluída com sucesso!");
            } else {
                System.out.println("Pessoa não encontrada.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erro ao excluir a pessoa.");
        }
    }
}
