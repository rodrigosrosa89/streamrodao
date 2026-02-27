package com.br.rodrigo.streamrodao.domain1.dto;

import com.br.rodrigo.streamrodao.domain1.models.Categoria;

public record SerieDTO(
        Long id,
        String titulo,
        Integer totalTemporadas,
        Double avaliacao,
        Categoria genero,
        String atores,
        String poster,
        String sinopse) {
}
