package com.br.rodrigo.streamrodao.domain1.service.strategy;

import com.br.rodrigo.streamrodao.domain1.models.Serie;
import com.br.rodrigo.streamrodao.domain1.service.strategy.chainresponsability.IValidadorSerieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ValidadorSerieService implements IValidadorSerieService {

    private List<ChainValidadorSerie> listaValidacoesChain;


    @Override
    public void validarSeries(List<Serie> series) {
        listaValidacoesChain.forEach(chainValidadorSerie ->
                chainValidadorSerie.validarListaSeries(series));
    }
}
