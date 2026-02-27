package com.br.rodrigo.streamrodao.domain1.service.strategy.chainresponsability;

import com.br.rodrigo.streamrodao.domain1.models.Serie;

import java.util.List;

public interface IValidadorSerieService {

    void validarSeries(List<Serie> series);
}
