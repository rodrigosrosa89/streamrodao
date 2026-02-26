package com.br.rodrigo.streamrodao.domain1.repository;

import com.br.rodrigo.streamrodao.domain1.dtos.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SerieRepository extends JpaRepository<Serie, Long> {

    Optional<Serie> findByTituloContainingIgnoreCase(String nomeSerie);

    List<Serie> findAllByAtoresContainingIgnoreCas(String ator);
}
