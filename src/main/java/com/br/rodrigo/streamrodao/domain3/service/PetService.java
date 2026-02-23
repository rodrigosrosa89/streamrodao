package com.br.rodrigo.streamrodao.domain3.service;

import com.br.rodrigo.streamrodao.domain3.dto.CadastroPetDTO;
import com.br.rodrigo.streamrodao.domain3.dto.PetDTO;
import com.br.rodrigo.streamrodao.domain3.model.Pet;
import com.br.rodrigo.streamrodao.domain3.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository repository;

    @Autowired
    private ImageStorageService imagemService;

    public List<PetDTO> listarTodos(){
        return repository.findAll().stream().map(PetDTO::new).toList();
    }
    public void cadastrar(CadastroPetDTO dto, MultipartFile imagem){

        String nomeImagem = imagemService.upload(imagem);

        repository.save(new Pet(dto, nomeImagem));
    }
}
