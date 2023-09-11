package org.example.repository;

import lombok.NoArgsConstructor;
import org.example.entity.Veiculo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@NoArgsConstructor
public class VeiculoRepository {

    private SessionFactory sessionFactory;

    public VeiculoRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void cadastrarVeiculos(Veiculo veiculo){
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(veiculo);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void atualizarVeiculo(Veiculo veiculo) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(veiculo);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Veiculo> listarVeiculos(){
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            System.out.println("Veículos: ");

            List<Veiculo> veiculos = session.createQuery("SELECT p FROM Veiculo p", Veiculo.class)
                    .getResultList();

            session.getTransaction().commit();

            return veiculos;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        } finally {
            session.close();
        }
    }

    public List<Veiculo> listarVeiculosDisponiveis(LocalDate dataInicio, LocalDate dataDevolucao){
        Session session = sessionFactory.openSession();
        List<Veiculo> veiculosDisponiveis = new ArrayList<>();

        try {
            session.beginTransaction();

            System.out.println("Veículos disponíveis entre " + dataInicio + " e " + dataDevolucao + ": ");

            List<Veiculo> veiculos = session.createQuery("SELECT p FROM Veiculo p", Veiculo.class)
                    .getResultList();

            for (Veiculo veiculo : veiculos){
                if (isDisponivelParaAluguel(veiculo.getId(), dataInicio, dataDevolucao) == true){
                    veiculosDisponiveis.add(veiculo);
                }
            }
            session.getTransaction().commit();

            return veiculosDisponiveis;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        } finally {
            session.close();
        }
    }

    public Veiculo buscarVeiculoPorId(int id){
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Veiculo veiculo = session.get(Veiculo.class, id);

            session.getTransaction().commit();

            return veiculo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Veiculo> buscarVeiculoPorNome(String modelo){
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            List<Veiculo> veiculos = session.createQuery("SELECT p FROM Veiculo p WHERE p.modelo LIKE :modelo", Veiculo.class)
                    .setParameter("modelo", modelo + "%") // % corresponde a qualquer sequência após o nome
                    .getResultList();

            session.getTransaction().commit();

            return veiculos;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        } finally {
            session.close();
        }
    }

    public void deletarVeiculo(int id){
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Veiculo veiculo = session.get(Veiculo.class, id);

            if (veiculo != null) {
                session.delete(veiculo);
                session.getTransaction().commit();
                System.out.println("Veículo excluída com sucesso!");
            } else {
                System.out.println("Veículo não encontrada.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erro ao excluir a veículo.");
        }
    }

    public boolean isDisponivelParaAluguel(int id, LocalDate dataInicio, LocalDate dataDevolucao) {
        Veiculo veiculo = buscarVeiculoPorId(id);

        if (veiculo != null) {
            for (LocalDate data : veiculo.getDatasOcupadas()) {
                if (!data.isBefore(dataInicio) && !data.isAfter(dataDevolucao)) {
                    return false;
                }
            }
        } else {
            System.out.println("Veículo não encontrado!");
        }

        return true;
    }

    public void bloquearDatas(int id, LocalDate dataInicio, LocalDate dataDevolucao){
        Veiculo veiculo = buscarVeiculoPorId(id);

        if (veiculo != null) {
            List<LocalDate> datas = veiculo.getDatasOcupadas();
            LocalDate data = dataInicio;
            while (!data.isAfter(dataDevolucao)) {
                datas.add(data);
                data = data.plusDays(1);
            }

            veiculo.setDatasOcupadas(datas);
            atualizarVeiculo(veiculo);
        } else {
            System.out.println("Veículo não encontrado!");
        }
    }
}
