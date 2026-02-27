package com.br.rodrigo.streamrodao.domain1.service.strategy;

import com.br.rodrigo.streamrodao.domain1.models.Serie;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ValidarSeriePorTemporadas implements ChainValidadorSerie {

    @Override
    public void validarListaSeries(List<Serie> serieList) {
        serieList.forEach(
                s -> {
                    if (s.getTotalTemporadas() < 2) {
                        throw new RuntimeException("Série tem que ter pelo menos 2 temporadas");
                    }
                }
        );
    }
}
