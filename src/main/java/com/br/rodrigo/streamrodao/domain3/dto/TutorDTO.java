package com.br.rodrigo.streamrodao.domain3.dto;

import com.br.rodrigo.streamrodao.domain3.model.Tutor;

public record TutorDTO(Long id, String nome, String email) {

    public TutorDTO(Tutor tutor){
        this(tutor.getId(), tutor.getNome(), tutor.getEmail());
    }
}
