package com.br.rodrigo.streamrodao.dtos;

import com.br.rodrigo.streamrodao.calculos.Classificavel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Filme extends Titulo implements Classificavel {
    private String diretor;

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public int getClassificacao() {
        return (int) pegaMedia() / 2;
    }
}

