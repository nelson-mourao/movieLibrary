/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt.movies.model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author nelson.mourao
 */
public class Filme {

    private String imdbId;
    private String titulo;
    private Date dataEstreia;
    private GeneroEnum genero;
    private List<Ator> elenco;
    private Double classificação;
    private Integer duracao; //minutos

    public Filme(){
    }
    
     public Filme(String imdbId,String titulo){
        setImdbId(imdbId);
        setTitulo(titulo);
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getDataEstreia() {
        return dataEstreia;
    }

    public void setDataEstreia(Date dataEstreia) {
        this.dataEstreia = dataEstreia;
    }

    public GeneroEnum getGenero() {
        return genero;
    }

    public void setGenero(GeneroEnum genero) {
        this.genero = genero;
    }

    public List<Ator> getElenco() {
        return elenco;
    }

    public void setElenco(List<Ator> elenco) {
        this.elenco = elenco;
    }

    public Double getClassificação() {
        return classificação;
    }

    public void setClassificação(Double classificação) {
        this.classificação = classificação;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    @Override
    public String toString() {
        return "\n" + getImdbId()+ " - " + getTitulo();
    }   
}
