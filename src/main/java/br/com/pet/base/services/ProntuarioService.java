package br.com.pet.base.services;

import br.com.pet.base.entities.Prontuario;
import br.com.pet.base.repositories.ProntuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProntuarioService {

    @Autowired
    private ProntuarioRepository prontuarioRepository;

    public Prontuario save (Prontuario prontuario) {
        return prontuarioRepository.save(prontuario);
    }
}
