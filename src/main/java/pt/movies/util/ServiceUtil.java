/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt.movies.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

/**
 *
 * @author nelson.mourao
 */
public class ServiceUtil {

    private static final String TOKEN_IMDB = "/k_b2e2u4qg/";
    private static final String DETAIL_CAST = "FullCast";
    private static final String DETAIL_RATINGS = "Ratings";
    private static final String DETAIL_FAQ = "faq";

    /**
     * Realiza uma procura na API do imdb de filmes com base numa String
     * pesquisa Devolve uma String JSON com o response
     */
    public static String getMovies(String pesquisa) {
        WebClient webClient2 = WebClient.builder()
                .baseUrl("https://imdb-api.com/en/API/Search")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
        return webClient2.get().uri(TOKEN_IMDB.concat(pesquisa)).retrieve().bodyToMono(String.class).block();
    }

    /**
     * Realiza uma procura na API do imdb do detalhe de filme com base num id do
     * imdb pesquisa Devolve uma String JSON com o response
     */
    public static String getMovieDetail(String id) {
        WebClient webClient2 = WebClient.builder()
                .baseUrl("https://imdb-api.com/en/API/Title")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
        return webClient2.get().uri(TOKEN_IMDB + id + "/" + DETAIL_CAST + "," + DETAIL_RATINGS + "," + DETAIL_FAQ).retrieve().bodyToMono(String.class).block();
    }
}
