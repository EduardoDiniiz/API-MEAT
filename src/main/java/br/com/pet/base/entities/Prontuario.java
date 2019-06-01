package br.com.pet.base.entities;

import br.com.pet.base.enums.SaudeAtual;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
public class Prontuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String procedimento;
    private String analise;
    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;
    @Getter @Setter(AccessLevel.NONE) private Integer saudeAtual;

    public SaudeAtual getSaudeAtual() {
        return SaudeAtual.toEnum(this.saudeAtual);
    }

    public void setSaudeAtual(SaudeAtual saudeAtual) {
        this.saudeAtual = saudeAtual.getCod();
    }
}
