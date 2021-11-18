/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt.movies.movielibrary;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import pt.movies.model.Ator;
import pt.movies.model.Filme;
import pt.movies.util.ServiceUtil;

/**
 *
 * @author nelson.mourao
 */
public class App {
    
    private App() {
    }

    public static void main(String... args) {
        System.out.println("Inicio da app movieLibrary...");
        System.out.println("Insira o filme que quer pesquisar");
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        try {
            String name = reader.readLine();
             List<Filme> filmes = getMovies(name);
            
            if(filmes!=null && filmes.size()>0){
                for(Filme f :filmes){
                    System.out.println(f.getImdbId() + " - " + f.getTitulo());
                }
                System.out.println("Insira o id do Filme que pertende obter detalhe\nInsira 'exit' para sair");
                String id = reader.readLine();
                if(!"exit".equals(id)){
                    Filme filme = getMovieDetail(id);
                    System.out.println(filme.toString());
                }
                
            }else{
                System.out.println("Não foram encontrados filmes");
            }
          
            
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
    *
    * devolve filmes
    * com base num String search
    */
    public static List<Filme> getMovies(String search){
        String result = ServiceUtil.getMovies(search);
        JSONObject jsonResult = new JSONObject(result);
        JSONArray jsonMoviesList = jsonResult.getJSONArray("results");
        List<Filme> filmes = new ArrayList<>();
        for(int i=0;i<jsonMoviesList.length();i++){
            JSONObject jsonMovie = jsonMoviesList.getJSONObject(i);
            filmes.add(new Filme(jsonMovie.getString("id"),jsonMovie.getString("title")));   
        }
        return filmes;
    }
    
    /**
    *
    * devolve detalhe 
    * de um filme
    */
    public static Filme getMovieDetail(String id){
        try{
            
            String result = ServiceUtil.getMovieDetail(id);
            System.out.println(result);
            JSONObject jsonResult = new JSONObject(result);
            Filme filme = new Filme();
            filme.setImdbId(jsonResult.getString("id"));
            filme.setTitulo( jsonResult.getString("title"));
            filme.setDataEstreia( new SimpleDateFormat("yyyy-MM-dd").parse(jsonResult.getString("releaseDate")));
            filme.setDuracao((Integer.valueOf(jsonResult.getString("runtimeMins"))));
            filme.setClassificação(Double.valueOf(jsonResult.getString("imDbRating")));
            JSONArray jsonActorList = jsonResult.getJSONArray("actorList");
            List<Ator> atores = new ArrayList<>();
            for(int i=0;i<jsonActorList.length();i++){
                JSONObject jsonActor = jsonActorList.getJSONObject(i);
                atores.add(new Ator(jsonActor.getString("name"),jsonActor.getString("asCharacter") ));   
            } 

            filme.setElenco(atores);
            return filme;
        }catch(Exception e){
            System.out.println("Ocorreu um erro a obter os detalhes");    
        }
        return new Filme();
    }
    
    
}
