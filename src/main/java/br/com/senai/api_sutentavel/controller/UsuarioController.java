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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<ResponseUsuarioDTO> create(@RequestBody @Valid RequestUsuarioDTO usuarioDTO) throws Exception {
        Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
        Usuario createdUsuario = usuarioService.create(usuario);
        ResponseUsuarioDTO createdUsuarioDTO = modelMapper.map(createdUsuario, ResponseUsuarioDTO.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdUsuarioDTO);
    }
}
