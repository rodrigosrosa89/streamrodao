package com.br.rodrigo.streamrodao.domain3.controller;

import com.br.rodrigo.streamrodao.domain3.dto.AdocaoDTO;
import com.br.rodrigo.streamrodao.domain3.dto.AprovarAdocaoDTO;
import com.br.rodrigo.streamrodao.domain3.dto.ReprovarAdocaoDTO;
import com.br.rodrigo.streamrodao.domain3.dto.SolicitacaoDeAdocaoDTO;
import com.br.rodrigo.streamrodao.domain3.service.AdocaoService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("adocao")
public class AdocaoController {

    @Autowired
    private AdocaoService service;

    @GetMapping
    public ResponseEntity<List<AdocaoDTO>> buscarTodos() {
        List<AdocaoDTO> adocoes = service.listarTodos();
        return ResponseEntity.ok(adocoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdocaoDTO> buscar(@PathVariable Long id) {
        AdocaoDTO adocao = service.listar(id);
        return ResponseEntity.ok(adocao);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<String> solicitar(@RequestBody @Valid SolicitacaoDeAdocaoDTO dados) {

        try {
            this.service.solicitar(dados);
        } catch (IllegalStateException | UnsupportedOperationException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }

        return ResponseEntity.ok("Adoção solicitada com sucesso!");
    }

    @PutMapping("/aprovar")
    @Transactional
    public ResponseEntity<String> aprovar(@RequestBody @Valid AprovarAdocaoDTO dto) {
        try {
            this.service.aprovar(dto);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Adocao não encontrada");
        }

        return ResponseEntity.ok().build();
    }

    @PutMapping("/reprovar")
    @Transactional
    public ResponseEntity<String> reprovar(@RequestBody @Valid ReprovarAdocaoDTO dto) {
        this.service.reprovar(dto);
        return ResponseEntity.ok().build();
    }
}
