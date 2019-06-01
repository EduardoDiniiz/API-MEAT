package br.com.pet.base.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private Date dataNascimento;
    private String raca;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @OneToMany(mappedBy = "animal")
    private List<Agendamento> agendamentos = new ArrayList<>();
    @OneToMany(mappedBy = "animal")
    private List<Prontuario> prontuarios = new ArrayList<>();
    private String foto;
}
