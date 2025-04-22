package br.com.senai.api_sutentavel.model.dtos;

import br.com.senai.api_sutentavel.model.entity.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestAcaoSustentavelDTO {

    @NotBlank(message = "Descrição Ação é obrigatório")
    private String  descricao;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataRealizacao;
    @NotNull
    private String responsavel;
    @NotNull
    private Usuario usuario;
}
