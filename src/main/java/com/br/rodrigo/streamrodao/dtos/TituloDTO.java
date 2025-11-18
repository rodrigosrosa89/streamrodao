package com.br.rodrigo.streamrodao.dtos;

import lombok.Setter;

public class TituloDTO {

    @Setter
    protected String nome;

    protected int anoDeLancamento;
    protected boolean incluidoNoPlano;
    protected double somaAvaliacoes;
    protected int totalDeAvaliacoes;
    protected int duracaoEmMinutos;

}
