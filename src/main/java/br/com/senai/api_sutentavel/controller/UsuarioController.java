package br.com.senai.api_sutentavel.controller;

import br.com.senai.api_sutentavel.model.dtos.RequestUsuarioDTO;
import br.com.senai.api_sutentavel.model.dtos.ResponseUsuarioDTO;
import br.com.senai.api_sutentavel.model.entity.Usuario;
import br.com.senai.api_sutentavel.service.UsuarioService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    ModelMapper modelMapper;

    //Método para listar todos os Usuários
    @GetMapping
    public ResponseEntity<List<ResponseUsuarioDTO>> list() {
        List<ResponseUsuarioDTO> usuarios = this.usuarioService.findAllUsuarios().stream()
                .map(usuario -> modelMapper.map(usuario, ResponseUsuarioDTO.class)).collect(Collectors.toList());
        return usuarios.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(usuarios);
    }

    //Método para buscar um Usuário pelo Id
    @GetMapping("/{id}")
    public ResponseEntity<ResponseUsuarioDTO> findById(@PathVariable Long id) {
        Usuario usuario = usuarioService.findUsuarioById(id);
        ResponseUsuarioDTO usuarioDTO = modelMapper.map(usuario, ResponseUsuarioDTO.class);
        return ResponseEntity.ok(usuarioDTO);
    }

    //Método para criar um Usuário
    @PostMapping
    public ResponseEntity<ResponseUsuarioDTO> create(@RequestBody @Valid RequestUsuarioDTO usuarioDTO) throws Exception {
        Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
        Usuario createdUsuario = usuarioService.create(usuario);
        ResponseUsuarioDTO createdUsuarioDTO = modelMapper.map(createdUsuario, ResponseUsuarioDTO.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdUsuarioDTO);
    }

    //Método para atualizar um Usuário
    @PutMapping("/{id}")
    public ResponseEntity<ResponseUsuarioDTO> update(@PathVariable Long id, @RequestBody RequestUsuarioDTO usuarioDTO) throws Exception {
        Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
        Usuario usuarioUpdate = this.usuarioService.update(id, usuario);
        ResponseUsuarioDTO usuarioUpdateDTO = modelMapper.map(usuarioUpdate, ResponseUsuarioDTO.class);

        return ResponseEntity.ok(usuarioUpdateDTO);
    }

    //Método para deletar um Usuário
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        this.usuarioService.delete(id);
        return ResponseEntity.ok("Usuário deletado com sucesso");
    }
}
