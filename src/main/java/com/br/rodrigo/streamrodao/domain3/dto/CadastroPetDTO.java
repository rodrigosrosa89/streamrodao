package com.br.rodrigo.streamrodao.domain3.dto;

import com.br.rodrigo.streamrodao.domain3.model.TipoPet;
import com.br.rodrigo.streamrodao.domain3.model.TipoPorte;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastroPetDTO(
        @NotBlank
        String nome,
        @NotNull
        Integer idade,
        @NotNull
        TipoPet tipo,
        @NotNull
        TipoPorte porte
) {
}
