package br.com.senai.api_sutentavel.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseUsuarioDTO {
    private Long id;
    private String nome;
    private String email;
    private String endereco;
    private String cidade;
    private String estado;
    private String telefone;
}
