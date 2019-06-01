package br.com.pet.base.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private String sigla;
    @OneToMany(mappedBy = "estado")
    private List<Cidade> Cidades = new ArrayList<>();
}
