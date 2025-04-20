package br.com.senai.api_sutentavel.repository;

import br.com.senai.api_sutentavel.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
