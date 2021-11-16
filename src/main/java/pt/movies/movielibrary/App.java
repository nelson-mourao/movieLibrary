/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt.movies.movielibrary;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
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
                    System.out.println(f.toString());
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
    
    
}
