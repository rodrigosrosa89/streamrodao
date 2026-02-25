package com.br.rodrigo.streamrodao.domain3.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.CompletionResult;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGpt {

    public static String obterTraducao(String texto) {
        OpenAiService serviceGpt = new OpenAiService("Coloque aqui a secrete key");

        CompletionRequest requisicao = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt("Traduza para o português o texto " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();

        CompletionResult resultado = serviceGpt.createCompletion(requisicao);
        System.out.println(resultado);

        return resultado.getChoices().get(0).getText();
    }
}
