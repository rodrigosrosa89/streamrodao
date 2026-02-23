package com.br.rodrigo.streamrodao.domain3.dto;

import jakarta.validation.constraints.NotBlank;

public record CadastroTutorDTO(
        @NotBlank
        String nome,

        @NotBlank
        String email
) {
}
