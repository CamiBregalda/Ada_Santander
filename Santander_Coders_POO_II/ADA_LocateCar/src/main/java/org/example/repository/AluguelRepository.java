package org.example.repository;

import org.example.entity.Aluguel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDate;

public class AluguelRepository {
    private SessionFactory sessionFactory;

    public AluguelRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void cadastrarAluguel(Aluguel aluguel){
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(aluguel);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
