package com.br.rodrigo.streamrodao.domain1.service.strategy;

import com.br.rodrigo.streamrodao.domain1.models.Serie;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ValidarSeriePorAvaliacao implements ChainValidadorSerie {

    @Override
    public void validarListaSeries(List<Serie> serieList) {
        serieList.forEach(
                s -> {
                    if (s.getAvaliacao() < 5) {
                        throw new RuntimeException("Avaliação não passou na validação");
                    }
                }
        );
    }
}
