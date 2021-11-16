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
    public static String getMovies(String pesquisa){
        WebClient webClient2 = WebClient.builder()
        .baseUrl("https://imdb-api.com/en/API/Search")
        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .build();
       return webClient2.get().uri(TOKEN_IMDB.concat(pesquisa)).retrieve().bodyToMono(String.class).block();
    }
    
}
