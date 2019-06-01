package br.com.pet.base.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@Data
@Entity
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String descricao;
    private Date data;
    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;
}
