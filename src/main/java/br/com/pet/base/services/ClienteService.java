package br.com.pet.base.services;

import br.com.pet.base.dto.ClienteDTO;
import br.com.pet.base.entities.Animal;
import br.com.pet.base.entities.Cliente;
import br.com.pet.base.entities.Endereco;
import br.com.pet.base.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private CidadeService cidadeService;

    @Autowired
    private AnimalService animalService;

    /*@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;*/


    public Cliente save(@Valid ClienteDTO clienteDTO) throws ParseException {
        Cliente cliente = prepareInsert(clienteDTO);
        cliente = clienteRepository.save(cliente);
        if(cliente.getEndereco() != null && cliente.getEndereco().size() > 0){
            for (Endereco endereco : cliente.getEndereco()) {
                endereco.setCliente(cliente);
                endereco.setCidade(cidadeService.save(endereco.getCidade()));
                enderecoService.save(endereco);
            }
        }

        if(cliente.getAnimais() != null && cliente.getAnimais().size() > 0){
            for (Animal animal: cliente.getAnimais()) {
                animal.setCliente(cliente);
                animalService.save(animal);
            }
        }
        return cliente;
    }


    public Cliente prepareInsert(ClienteDTO clienteDTO) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Cliente cliente = new Cliente(clienteDTO.getEmail(), clienteDTO.getNome(), sdf.parse(clienteDTO.getDataNascimento()),
                clienteDTO.getCpf(), clienteDTO.getSenha(), clienteDTO.getAnimais(), clienteDTO.getEnderecos(), sdf.parse(clienteDTO.getDataNascimento()));
        Set<String> telefones = new HashSet<>();
        for (String telefone : clienteDTO.getTelefones()) {
            telefones.add(telefone);
        }
        cliente.setTelefone(telefones);
        return cliente;
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }
}
