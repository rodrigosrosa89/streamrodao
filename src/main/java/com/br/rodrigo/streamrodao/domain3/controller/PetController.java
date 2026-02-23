package com.br.rodrigo.streamrodao.domain3.controller;

import com.br.rodrigo.streamrodao.domain3.dto.CadastroPetDTO;
import com.br.rodrigo.streamrodao.domain3.dto.PetDTO;
import com.br.rodrigo.streamrodao.domain3.service.PetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("pets")
public class PetController {

    @Autowired
    private PetService service;

    @GetMapping
    public ResponseEntity<List<PetDTO>> buscarTodos() {
        List<PetDTO> pets = service.listarTodos();
        return ResponseEntity.ok(pets);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastrar(@RequestPart @Valid CadastroPetDTO dados,
                                            @RequestParam MultipartFile imagem) {
        try {
            service.cadastrar(dados, imagem);
        } catch (IOException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
        return ResponseEntity.ok().build();
    }
}
