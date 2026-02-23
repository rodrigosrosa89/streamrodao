package com.br.rodrigo.streamrodao.domain1.excecao;

public class ErrodeConversaoException extends RuntimeException {

    private String mensagem;

    public ErrodeConversaoException(String s) {
        this.mensagem = s;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
