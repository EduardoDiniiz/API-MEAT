package br.com.pet.base.entities;

import br.com.pet.base.enums.SaudeAtual;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
public class Prontuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String procedimento;
    private String analise;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;
    @Getter
    @Setter(AccessLevel.NONE)
    private Integer saudeAtual;

    public SaudeAtual getSaudeAtual() {
        return SaudeAtual.toEnum(this.saudeAtual);
    }

    public void setSaudeAtual(SaudeAtual saudeAtual) {
        this.saudeAtual = saudeAtual.getCod();
    }
}
