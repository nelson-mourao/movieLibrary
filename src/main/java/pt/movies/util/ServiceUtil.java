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
    public static String getMovies(String pesquisa){
        WebClient webClient2 = WebClient.builder()
        .baseUrl("https://imdb-api.com/en/API/Search")
        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .build();
       return webClient2.get().uri(TOKEN_IMDB.concat(pesquisa)).retrieve().bodyToMono(String.class).block();
    }
    
     public static String getMovieDetail(String id){
        WebClient webClient2 = WebClient.builder()
        .baseUrl("https://imdb-api.com/en/API/Title")
        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .build();
       return webClient2.get().uri(TOKEN_IMDB+id+"/"+DETAIL_CAST+","+DETAIL_RATINGS+","+DETAIL_FAQ).retrieve().bodyToMono(String.class).block();
    }
     
     
      public static String getMovieDetailImdbAlternative(String pesquisa){
        WebClient webClient2 = WebClient.builder()
        .baseUrl("https://imdb8.p.rapidapi.com/")
        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .defaultHeader("x-rapidapi-host", "imdb8.p.rapidapi.com")
	.defaultHeader("x-rapidapi-key", "06feeefce8msh7dd7155897f2647p152b46jsnbbc265d7cfa3")
        .build();
       return webClient2.get().uri("title/find?q="+pesquisa).retrieve().bodyToMono(String.class).block();
    }
}
