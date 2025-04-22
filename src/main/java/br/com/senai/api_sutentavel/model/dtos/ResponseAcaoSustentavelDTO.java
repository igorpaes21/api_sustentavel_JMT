package br.com.senai.api_sutentavel.model.dtos;

import br.com.senai.api_sutentavel.model.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAcaoSustentavelDTO {

    private Long id;
    private String descricao;
    private String dataRealizacao;
    private String responsavel;
    private Usuario usuario;
}
