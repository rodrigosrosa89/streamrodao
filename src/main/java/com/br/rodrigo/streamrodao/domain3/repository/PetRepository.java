package com.br.rodrigo.streamrodao.domain3.repository;

import com.br.rodrigo.streamrodao.domain3.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
