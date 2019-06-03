package br.com.pet.base.services;

import br.com.pet.base.entities.Agendamento;
import br.com.pet.base.repositories.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;


    public Agendamento save(Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }
}
