package br.com.pet.base.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String rua;
    private String cep;
    private String numero;
    private String complemento;
    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
