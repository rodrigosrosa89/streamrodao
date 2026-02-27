package com.br.rodrigo.streamrodao.domain1.service.strategy;

import com.br.rodrigo.streamrodao.domain1.models.Serie;

import java.util.List;

public interface ChainValidadorSerie {

    void validarListaSeries(List<Serie> serieList);
}
