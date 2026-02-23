package com.br.rodrigo.streamrodao.domain2.service;

public interface IConverteDados {
    <T> T  obterDados(String json, Class<T> classe);
}