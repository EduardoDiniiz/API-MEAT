package br.com.pet.base.enums;

import lombok.Getter;

@Getter
public enum SaudeAtual {

    CRITICO(0, "Saúde em estado crítico"),
    ESTAVEL(1, "Saúde estável"),
    SAUDAVEL(2, "Saudável");

    private int cod;
    private String descricao;

    private SaudeAtual(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public static SaudeAtual toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }

        for (SaudeAtual saudeAtual : SaudeAtual.values()) {
            if (cod.equals(saudeAtual.cod)) {
                return saudeAtual;
            }
        }
        throw new IllegalArgumentException("Id inválido: " + cod);
    }

}
