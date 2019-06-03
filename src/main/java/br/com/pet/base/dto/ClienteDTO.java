package br.com.pet.base.dto;

import br.com.pet.base.entities.Animal;
import br.com.pet.base.entities.Endereco;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class ClienteDTO {

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")
    private String nome;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Email(message = "Email inválido")
    private String email;

    private String dataNascimento;

    private String senha;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String cpf;

    @NotEmpty(message = "Preenchimento obrigatório")
    private List<Endereco> enderecos;

    private List<String> telefones;

    private List<Animal> animais;

}
