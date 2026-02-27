package com.br.rodrigo.streamrodao.domain1.service.strategy;

import com.br.rodrigo.streamrodao.domain1.models.Categoria;
import com.br.rodrigo.streamrodao.domain1.models.Serie;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ValidarSeriePorGenero implements ChainValidadorSerie {

    @Override
    public void validarListaSeries(List<Serie> serieList) {
        serieList.forEach(
                s -> {
                    if (s.getGenero().equals(Categoria.ACAO)) {
                        throw new RuntimeException("Série de ação não está dentro das regras");
                    }
                }
        );
    }

}
