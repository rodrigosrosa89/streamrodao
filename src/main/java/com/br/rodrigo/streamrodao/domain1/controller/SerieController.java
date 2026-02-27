package com.br.rodrigo.streamrodao.domain1.controller;

import com.br.rodrigo.streamrodao.domain1.dto.EpisodioDTO;
import com.br.rodrigo.streamrodao.domain1.dto.SerieDTO;
import com.br.rodrigo.streamrodao.domain1.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SerieController {

    @Autowired
    private SerieService servico;

    @GetMapping
    public List<SerieDTO> obterSeries() {
        return servico.obterTodasAsSeries();
    }

    @GetMapping("/top5")
    public List<SerieDTO> obterTop5Series() {
        return servico.obterTop5Series();
    }

    @GetMapping("/lancamentos")
    public List<SerieDTO> obterLancamentos() {
        return servico.obterLancamentos();
    }

    @GetMapping("/{id}")
    public SerieDTO obterPorId(@PathVariable Long id) {
        return servico.obterPorId(id);
    }

    @GetMapping("/{id}/temporadas/todas")
    public List<EpisodioDTO> obterTodasTemporadas(@PathVariable Long id){
        return servico.obterTodasTemporadas(id);
    }

    @GetMapping("/{id}/temporadas/{numero}")
    public List<EpisodioDTO> obterTemporadasPorNumero(@PathVariable Long id, @PathVariable Long numero){
        return servico.obterTemporadasPorNumero(id, numero);
    }

    @GetMapping("/categoria/{nomeGenero}")
    public List<SerieDTO> obterSeriesPorCategoria(@PathVariable String nomeGenero){
        return servico.obterSeriesPorCategoria(nomeGenero);
    }
}