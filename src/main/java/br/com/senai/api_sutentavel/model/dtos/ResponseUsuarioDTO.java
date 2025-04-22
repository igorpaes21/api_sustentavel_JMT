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
}
