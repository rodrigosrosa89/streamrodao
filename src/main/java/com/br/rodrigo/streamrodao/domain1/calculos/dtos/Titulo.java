package com.br.rodrigo.streamrodao.domain1.calculos.dtos;

import com.br.rodrigo.streamrodao.domain1.calculos.excecao.ErrodeConversaoException;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo>  {
    @SerializedName("Title")
    private String nome;

    @SerializedName("Year")
    private int anoDeLancamento;

    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;

    public Titulo(TituloOmdb meuTituloomdb) {
        this.nome = meuTituloomdb.title();

        if (meuTituloomdb.year().length() > 4) {
            throw new ErrodeConversaoException("Não consegui converter o ano do titulo.");
        }
        this.anoDeLancamento = Integer.parseInt(meuTituloomdb.year());
        this.duracaoEmMinutos = Integer.parseInt(meuTituloomdb.runtime());
    }

    @Override
    public String toString() {
        return "Titulo{" +
                "anoDeLancamento=" + anoDeLancamento +
                ", nome='" + nome + '\'' +
                '}';
    }

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public void exibeFichaTecnica(){
        System.out.println("Nome do filme: " + nome);
        System.out.println("Ano de lançamento: " + anoDeLancamento);
    }

    public void avalia(double nota){
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    public double pegaMedia(){
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }
}