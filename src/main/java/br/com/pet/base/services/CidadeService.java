package br.com.pet.base.services;

import br.com.pet.base.entities.Cidade;
import br.com.pet.base.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;


    public Cidade save(Cidade cidade) {
        System.out.printf(cidade.getNome() + " e " + cidade.getEstado().getSigla());
        Cidade cidadeReturn = cidadeRepository.getCidade(cidade.getNome(), cidade.getEstado().getSigla());
        if (cidadeReturn != null) {
            return cidadeReturn;
        }
        return cidadeRepository.save(cidade);
    }
}
