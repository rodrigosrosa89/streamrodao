package com.br.rodrigo.streamrodao.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Serie extends TituloDTO{

    private int temporadas;
    private boolean ativa;
    private int episodioPorTemporada;
    private int minutosPorEpisodio;


}
