package br.com.pet.base.services;

import br.com.pet.base.entities.Agendamento;
import br.com.pet.base.entities.Animal;
import br.com.pet.base.entities.Prontuario;
import br.com.pet.base.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private ProntuarioService prontuarioService;

    @Autowired
    private AgendamentoService agendamentoService;

    public Animal save(Animal animal) {
        animal = animalRepository.save(animal);

        if (animal.getAgendamentos() != null && animal.getAgendamentos().size() > 0) {
            for (Agendamento agendamento : animal.getAgendamentos()) {
                agendamento.setAnimal(animal);
                agendamentoService.save(agendamento);
            }
        }

        if (animal.getProntuarios() != null && animal.getProntuarios().size() > 0) {
            for (Prontuario prontuario: animal.getProntuarios()) {
                prontuario.setAnimal(animal);
                prontuarioService.save(prontuario);
            }
        }
        return animal;
    }
}
