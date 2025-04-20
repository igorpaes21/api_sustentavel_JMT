package br.com.senai.api_sutentavel.service;

import br.com.senai.api_sutentavel.model.entity.Usuario;
import br.com.senai.api_sutentavel.model.exceptions.ResourceNotFoundException;
import br.com.senai.api_sutentavel.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    //Método para criar todos os Usuários
    public Usuario create(Usuario usuario) {
      return usuarioRepository.save(usuario);
    }

    //Método para lista todos os Usuários
    public List<Usuario> findAllUsuarios() {
        return usuarioRepository.findAll();
    }

    //Método para listar um Usuário pelo Id
    public Usuario findUsuarioById(Long id) {
        return usuarioRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Usuário com Id: " + id + " não encontrado"));
    }

    //Método para atualizar um Usuário
    public Usuario update(Long id, Usuario usuarioUpdate) {
        Usuario existingUsuario = findUsuarioById(id);
        existingUsuario.setNome(usuarioUpdate.getNome());
        return usuarioRepository.save(existingUsuario);
    }

    //Método para deletar um Usuário
    public void delete(Long id) {
        Usuario usuario = findUsuarioById(id);
        usuarioRepository.delete(usuario);
    }



}
