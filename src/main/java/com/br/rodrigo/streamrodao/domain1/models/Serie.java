package com.br.rodrigo.streamrodao.domain1.models;

import com.br.rodrigo.streamrodao.domain2.model.DadosSerie;
import com.br.rodrigo.streamrodao.domain3.service.ConsultaChatGpt;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

@Entity
@Table(name = "series")
@Getter
@Setter
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private Integer totalTemporadas;
    private Double avaliacao;
    @Enumerated(EnumType.STRING)
    private Categoria genero;
    private String atores;
    private String poster;
    private String sinopse;

    @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Episodio> episodios = new ArrayList<>();

    public Serie() {}

    public Serie(DadosSerie dadosSerie){
        this.titulo = dadosSerie.titulo();
        this.totalTemporadas = dadosSerie.totalTemporadas();
        this.avaliacao = OptionalDouble.of(Double.valueOf(dadosSerie.avaliacao())).orElse(0);
        this.genero = Categoria.fromString(dadosSerie.genero().split(",")[0].trim());
        this.atores = dadosSerie.atores();
        this.poster = dadosSerie.poster();
        this.sinopse = ConsultaChatGpt.obterTraducao(dadosSerie.sinopse()).trim();
    }

    public void setEpisodios(List<Episodio> episodios) {
        episodios.forEach(e -> e.setSerie(this));
        this.episodios = episodios;
    }

    @Override
    public String toString() {
        return
                "genero=" + genero +
                        ", titulo='" + titulo + '\'' +
                        ", totalTemporadas=" + totalTemporadas +
                        ", avaliacao=" + avaliacao +
                        ", atores='" + atores + '\'' +
                        ", poster='" + poster + '\'' +
                        ", sinopse='" + sinopse + '\'' +
                        ", episodios='" + episodios + '\'';
    }
}