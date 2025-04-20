package br.com.senai.api_sutentavel.model.entity;

import br.com.senai.api_sutentavel.model.enums.CategoriaAcao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "acoes_sustentaveis")
public class AcaoSustentavel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoriaAcao categoria;
    @Column
    @Temporal(value = TemporalType.DATE)
    private LocalDate dataRealizacao;
    @Column
    private String responsavel;
    @ManyToOne
    @JoinColumn(name = "fk_usuario", nullable = false)
    private Usuario usuario;
}

