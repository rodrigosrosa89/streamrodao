package com.br.rodrigo.streamrodao.domain1.principal;

import com.br.rodrigo.streamrodao.domain1.dtos.Titulo;
import com.br.rodrigo.streamrodao.domain1.dtos.TituloOmdb;
import com.br.rodrigo.streamrodao.domain1.excecao.ErrodeConversaoException;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite um filme para busca: ");
        var busca = leitura.nextLine();

        try {
            String url = "http://omdbapi.com/?t=" + busca + "&apikey=6585022c";

            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            System.out.println(httpResponse.body());

            Gson gson = new Gson();
            Titulo meuTitulo = gson.fromJson(httpResponse.body(), Titulo.class);
            System.out.println("Título: " + meuTitulo.getNome());

            Gson gsonOmdb = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
            TituloOmdb meuTituloomdb = gsonOmdb.fromJson(httpResponse.body(), TituloOmdb.class);
            System.out.println("TituloOmdb: " + meuTituloomdb);

            Titulo meuTituloNovo = new Titulo(meuTituloomdb);
            System.out.println("meuTituloNovo: " + meuTituloNovo);

            FileWriter escrita = new FileWriter("Filmes.txt");
            escrita.write(meuTitulo.toString());
            escrita.close();
        } catch (NumberFormatException ex) {
            System.out.println("Aconteceu um erro!");
            System.out.println(ex.getMessage());
        } catch (IllegalArgumentException ex) {
            System.out.println("Erro de busca ou argumento!");
            System.out.println(ex.getMessage());
        } catch (ErrodeConversaoException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
