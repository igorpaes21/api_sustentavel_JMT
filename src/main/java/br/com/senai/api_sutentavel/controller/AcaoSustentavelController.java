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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/acoes-sustentaveis")
public class AcaoSustentavelController {

    @Autowired
    AcaoSustentavelService acaoSustentavelService;

    @Autowired
    ModelMapper modelMapper;

    //Método para listar todas as Ações Sustentáveis
    @GetMapping
    public ResponseEntity<List<ResponseAcaoSustentavelDTO>> list() {
        List<ResponseAcaoSustentavelDTO> acoesSustentaveis = this.acaoSustentavelService.findAllAcaoSustentavel().stream()
                .map(acaoSustentavel -> modelMapper.map(acaoSustentavel, ResponseAcaoSustentavelDTO.class)).collect(Collectors.toList());
        return acoesSustentaveis.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(acoesSustentaveis);
    }

    //Método para buscar uma Ação Sustentável pelo Id
    @GetMapping("/{id}")
    public ResponseEntity<ResponseAcaoSustentavelDTO> findById(@PathVariable Long id) {
        AcaoSustentavel acaoSustentavel = acaoSustentavelService.findAcaoSustentavelById(id);
        ResponseAcaoSustentavelDTO acaoSustentavelDTO = modelMapper.map(acaoSustentavel, ResponseAcaoSustentavelDTO.class);
        return ResponseEntity.ok(acaoSustentavelDTO);
    }

    //Método para criar uma Ação Sustentável
    @PostMapping
    public ResponseEntity<ResponseAcaoSustentavelDTO> create(@RequestBody @Valid RequestAcaoSustentavelDTO acaoSustentavelDTO) throws Exception {
        AcaoSustentavel acaoSustentavel = modelMapper.map(acaoSustentavelDTO, AcaoSustentavel.class);
        AcaoSustentavel createdAcaoSustentavel = acaoSustentavelService.create(acaoSustentavel);
        ResponseAcaoSustentavelDTO createdAcaoSustentavelDTO = modelMapper.map(createdAcaoSustentavel, ResponseAcaoSustentavelDTO.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdAcaoSustentavelDTO);
    }

    //Método para atualizar uma Ação Sustentável
    @PutMapping("/{id}")
    public ResponseEntity<ResponseAcaoSustentavelDTO> update(@PathVariable Long id, @RequestBody RequestAcaoSustentavelDTO acaoSustentavelDTO) throws Exception {
        AcaoSustentavel acaoSustentavel = modelMapper.map(acaoSustentavelDTO, AcaoSustentavel.class);
        AcaoSustentavel acaoSustentavelUpdate = this.acaoSustentavelService.update(id, acaoSustentavel);
        ResponseAcaoSustentavelDTO acaoSustentavelUpdateDTO = modelMapper.map(acaoSustentavelUpdate, ResponseAcaoSustentavelDTO.class);

        return ResponseEntity.ok(acaoSustentavelUpdateDTO);
    }
    //Método para deletar uma Ação Sustentável
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        this.acaoSustentavelService.delete(id);
        return ResponseEntity.ok("Ação Sustentável deletada com sucesso");
    }

    //Método para buscar Ações Sustentáveis por categoria
    @GetMapping("categoria/{categoria}")
    public ResponseEntity<List<ResponseAcaoSustentavelDTO>> findByCategoriaPath(@PathVariable String categoria) {
        List<AcaoSustentavel> acoesSustentaveis = this.acaoSustentavelService.findAcaoSustentavelByCategoria(categoria);
        List<ResponseAcaoSustentavelDTO> acoesSustentaveisDTO = this.acaoSustentavelService.findAcaoSustentavelByCategoria(categoria).stream()
                .map(acaoSustentavel -> modelMapper.map(acaoSustentavel, ResponseAcaoSustentavelDTO.class)).collect(Collectors.toList());
        return acoesSustentaveis.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(acoesSustentaveisDTO);
    }

    //Método para buscar Ações Sustentáveis por categoria
    @GetMapping("/categoria")
    public ResponseEntity<List<ResponseAcaoSustentavelDTO>> findByCategoriaQuery(@RequestParam String tipo) {
        List<AcaoSustentavel> acoesSustentaveis = this.acaoSustentavelService.findAcaoSustentavelByCategoria(tipo);
        List<ResponseAcaoSustentavelDTO> acoesSustentaveisDTO = this.acaoSustentavelService.findAcaoSustentavelByCategoria(tipo).stream()
                .map(acaoSustentavel -> modelMapper.map(acaoSustentavel, ResponseAcaoSustentavelDTO.class)).collect(Collectors.toList());
        return acoesSustentaveis.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(acoesSustentaveisDTO);
    }


    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public String listAcesso() {
        return "Ações sustentáveis (GET - Acesso para USER e ADMIN)";
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String createAcesso() {
        return "Ação sustentável criada (POST - Acesso apenas para ADMIN)";
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String updateAcesso(@PathVariable Long id) {
        return "Ação sustentável atualizada (PUT - Acesso apenas para ADMIN)";
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteAcesso(@PathVariable Long id) {
        return "Ação sustentável deletada (DELETE - Acesso apenas para ADMIN)";
    }

}
