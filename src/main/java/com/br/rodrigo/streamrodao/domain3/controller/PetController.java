package com.br.rodrigo.streamrodao.domain3.controller;

import com.br.rodrigo.streamrodao.domain3.dto.CadastroPetDTO;
import com.br.rodrigo.streamrodao.domain3.dto.PetDTO;
import com.br.rodrigo.streamrodao.domain3.service.PetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("pets")
public class PetController {

    @Autowired
    private PetService service;

    @GetMapping
    public ResponseEntity<List<PetDTO>> buscarTodos(){
        List<PetDTO> pets = service.listarTodos();
        return ResponseEntity.ok(pets);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastrar(@RequestPart @Valid CadastroPetDTO dados,
                                            @RequestParam MultipartFile imagem){
        service.cadastrar(dados, imagem);
        return ResponseEntity.ok().build();
    }
}
