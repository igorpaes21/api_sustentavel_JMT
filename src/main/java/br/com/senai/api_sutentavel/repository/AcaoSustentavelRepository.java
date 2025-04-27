package br.com.senai.api_sutentavel.repository;

import br.com.senai.api_sutentavel.model.entity.AcaoSustentavel;
import br.com.senai.api_sutentavel.model.enums.CategoriaAcao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AcaoSustentavelRepository extends JpaRepository<AcaoSustentavel, Long> {
    List<AcaoSustentavel> findByCategoria(CategoriaAcao categoria);
}
