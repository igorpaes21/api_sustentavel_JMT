package br.com.senai.api_sutentavel.model.dtos;

import br.com.senai.api_sutentavel.model.entity.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestAcaoSustentavelDTO {


    @Getter
    @NotBlank(message = "O titulo da Ação é obrigatório")
    @Size(max = 100, message = "Descrição da Ação deve ter no máximo 100 caracteres")
    private String titulo;

    @NotBlank(message = "Descrição da Ação é obrigatório")
    @Size(max = 500, message = "Descrição da Ação deve ter no máximo 500 caracteres")
    private String  descricao;

    @NotBlank(message = "A categoria não pode estar em branco")
    private String categoria;

    @PastOrPresent(message = "A data de realização deve ser bo presente ou no passado")
    private LocalDate dataRealizacao;

    @NotBlank(message = "O responsável pela Ação é obrigatório")
    private String responsavel;

    @NotNull(message = "O usuário não pode ser nulo")
    private Usuario usuario;

}
