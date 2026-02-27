package com.br.rodrigo.streamrodao.domain1.dto;

import com.br.rodrigo.streamrodao.domain1.models.Categoria;

public record EpisodioDTO(
        Integer temporada,
        Integer numeroEpisodio,
        String titulo) {
}
