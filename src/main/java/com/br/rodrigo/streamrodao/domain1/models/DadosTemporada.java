package com.br.rodrigo.streamrodao.domain1.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosTemporada(@JsonAlias("Title") String titulo,
                             @JsonAlias("totalSeasons") Integer totalTemporadas,
                             @JsonAlias("imdbRating") String avaliacao,
                             @JsonAlias("Genre") String genero,
                             @JsonAlias("Actors") String atores,
                             @JsonAlias("Poster") String poster,
                             @JsonAlias("Plot") String sinopse) {
}