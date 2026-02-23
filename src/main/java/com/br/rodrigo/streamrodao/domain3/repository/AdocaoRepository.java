package com.br.rodrigo.streamrodao.domain3.repository;

import com.br.rodrigo.streamrodao.domain3.model.Adocao;
import com.br.rodrigo.streamrodao.domain3.model.StatusAdocao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdocaoRepository extends JpaRepository<Adocao,Long> {
    Boolean existsByPetIdAndStatus(Long idPet, StatusAdocao statusAdocao);
    Integer countByTutorIdAndStatus(Long idTutor, StatusAdocao statusAdocao);
}
