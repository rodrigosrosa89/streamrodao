package com.br.rodrigo.streamrodao.domain3.service;

import com.br.rodrigo.streamrodao.domain3.dto.CadastroTutorDTO;
import com.br.rodrigo.streamrodao.domain3.dto.TutorDTO;
import com.br.rodrigo.streamrodao.domain3.model.Tutor;
import com.br.rodrigo.streamrodao.domain3.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorService {

    @Autowired
    private TutorRepository repository;

    public List<TutorDTO> listarTodos(){
        return repository.findAll().stream().map(TutorDTO::new).toList();
    }
    public void cadastrar(CadastroTutorDTO dados){
        repository.save(new Tutor(dados));
    }
}
