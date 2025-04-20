package br.com.senai.api_sutentavel.controller;

import br.com.senai.api_sutentavel.model.dtos.RequestAcaoSustentavelDTO;
import br.com.senai.api_sutentavel.model.dtos.ResponseAcaoSustentavelDTO;
import br.com.senai.api_sutentavel.model.entity.AcaoSustentavel;
import br.com.senai.api_sutentavel.service.AcaoSustentavelService;
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
@RequestMapping("/acoes-sustentaveis")
public class AcaoSustentavelController {

    @Autowired
    AcaoSustentavelService acaoSustentavelService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<ResponseAcaoSustentavelDTO> create(@RequestBody @Valid RequestAcaoSustentavelDTO acaoSustentavelDTO) throws Exception {
        AcaoSustentavel acaoSustentavel = modelMapper.map(acaoSustentavelDTO, AcaoSustentavel.class);
        AcaoSustentavel createdAcaoSustentavel = acaoSustentavelService.create(acaoSustentavel);
        ResponseAcaoSustentavelDTO createdAcaoSustentavelDTO = modelMapper.map(createdAcaoSustentavel, ResponseAcaoSustentavelDTO.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdAcaoSustentavelDTO);
    }
}
