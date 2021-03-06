package br.com.pet.base.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(unique = true)
    private String email;
    private String nome;
    private Date dataNascimento;
    private String cpf;
    @JsonIgnore
    private String senha;
    private Date dataCadastro;
    @OneToMany(mappedBy = "cliente")
    private List<Endereco> endereco = new ArrayList<>();
    @OneToMany(mappedBy = "cliente")
    private List<Animal> animais = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "TELEFONE")
    private Set<String> telefone = new HashSet<>();

}
