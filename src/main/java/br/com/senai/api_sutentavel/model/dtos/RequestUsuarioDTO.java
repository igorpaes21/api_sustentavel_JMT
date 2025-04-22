package br.com.senai.api_sutentavel.model.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestUsuarioDTO {

    @NotBlank(message = "O nome não pode ser vazio")
    private String nome;




}
