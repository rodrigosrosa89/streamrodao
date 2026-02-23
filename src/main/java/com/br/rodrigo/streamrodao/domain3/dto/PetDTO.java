package com.br.rodrigo.streamrodao.domain3.dto;

import com.br.rodrigo.streamrodao.domain3.model.Pet;
import com.br.rodrigo.streamrodao.domain3.model.TipoPet;

public record PetDTO(Long id, String nome, Integer idade, TipoPet tipo, Boolean adotado, String imagem) {

    public PetDTO(Pet pet){

        this(pet.getId(), pet.getNome(), pet.getIdade(), pet.getTipo(), pet.getAdotado(), pet.getImagem());
    }
}
