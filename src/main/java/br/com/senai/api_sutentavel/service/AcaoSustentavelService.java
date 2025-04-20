package br.com.senai.api_sutentavel.service;

import br.com.senai.api_sutentavel.model.entity.AcaoSustentavel;
import br.com.senai.api_sutentavel.model.exceptions.ResourceNotFoundException;
import br.com.senai.api_sutentavel.repository.AcaoSustentavelRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcaoSustentavelService {

    @Autowired
    AcaoSustentavelRepository acaoSustentavelRepository;

    //Método para listar todas as Ações Sustentáveis
    public List<AcaoSustentavel> findAllAcaoSustentavel() {
        return acaoSustentavelRepository.findAll();
    }

    //Método para listar uma Ação Sustentável pelo Id
    public AcaoSustentavel findAcaoSustentavelById(Long id) {
        return acaoSustentavelRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Ação Sustentável com Id: " + id + " não encontrado"));
    }

    //Método para criar uma Ação Sustentável
    public AcaoSustentavel create(AcaoSustentavel acaoSustentavel) {
        return acaoSustentavelRepository.save(acaoSustentavel);
    }

    //Método para atualizar uma Ação Sustentável
    public AcaoSustentavel update(Long id, AcaoSustentavel acaoSustentavelUpdate) {
        AcaoSustentavel existingAcaoSustentavel = findAcaoSustentavelById(id);
        existingAcaoSustentavel.setDescricao(acaoSustentavelUpdate.getDescricao());
        existingAcaoSustentavel.setDataRealizacao(acaoSustentavelUpdate.getDataRealizacao());
        existingAcaoSustentavel.setResponsavel(acaoSustentavelUpdate.getResponsavel());
        return acaoSustentavelRepository.save(existingAcaoSustentavel);
    }

    //Método para deletar uma Ação Sustentável
    public void delete(Long id) {
        AcaoSustentavel acaoSustentavel = findAcaoSustentavelById(id);
        acaoSustentavelRepository.delete(acaoSustentavel);
    }



}