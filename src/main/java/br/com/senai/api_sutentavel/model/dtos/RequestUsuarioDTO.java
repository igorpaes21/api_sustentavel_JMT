package br.com.senai.api_sutentavel.model.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestUsuarioDTO {


    @NotBlank(message = "O nome não pode ser vazio")
    @Size(min = 3, max = 255, message = "O nome deve ter entre 3 e 255 caracteres")
    private String nome;

    @NotBlank(message = "O email não pode ser vazio")
    @Size(max = 255, message = "O email não pode ter mais de 255 caracteres")
    private String email;

    @NotBlank(message = "A senha não pode ser vazia")
    @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres")
    private String senha;

    @NotBlank(message = "O CPF não pode ser vazio")
    private String cpf;

    @NotBlank(message = "O endereço não pode ser vazio")
    private String endereco;

    @NotBlank(message = "A cidade não pode ser vazia")
    private String cidade;

    @NotBlank(message = "O estado não pode ser vazio")
    private String estado;

    private String telefone;

}
