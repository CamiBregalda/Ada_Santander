package org.example.service;

import org.example.entity.Aluguel;
import org.example.entity.Pessoa;
import org.example.repository.AluguelRepository;
import org.hibernate.SessionFactory;

public class AluguelService {

    private AluguelRepository aluguelRepository;
    public AluguelService(SessionFactory sessionFactory) {
        this.aluguelRepository = new AluguelRepository(sessionFactory);
    }

    public void cadastrarAluguel(Aluguel aluguel){
        try{
            aluguelRepository.cadastrarAluguel(aluguel);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
