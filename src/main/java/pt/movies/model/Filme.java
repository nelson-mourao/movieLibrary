/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt.movies.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nelson.mourao
 */
public class Filme {

    private String imdbId;
    private String titulo;
    private LocalDate dataEstreia;
    private List<GeneroEnum> genero;
    private List<Ator> elenco;
    private Double classificação;
    private Integer duracao; //minutos

    public Filme(String imdbId, String titulo) {
        setImdbId(imdbId);
        setTitulo(titulo);
    }

    public Filme() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getDataEstreia() {
        return dataEstreia;
    }

    public void setDataEstreia(LocalDate dataEstreia) {
        this.dataEstreia = dataEstreia;
    }

    public List<GeneroEnum> getGenero() {
        return genero;
    }

    public void setGenero(List<GeneroEnum> genero) {
        this.genero = genero;
    }

    public void setGenero(String genero) {
        List<GeneroEnum> generoTemp = new ArrayList<>();
        for (GeneroEnum e : GeneroEnum.values()) {
            if (genero.contains(e.name())) {
                generoTemp.add(e);
            }
        }
        this.genero = generoTemp;
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
        String toString = "Filme: " + "\n imdbId=" + imdbId + "\n titulo=" + titulo + "\n dataEstreia=" + dataEstreia + "\n genero=" + genero + "\n classifica\u00e7\u00e3o=" + classificação + "\n duracao(min)=" + duracao + "\n elenco:";
        String toStringAtores = "";

        if (elenco != null) {
            for (Ator ator : elenco) {
                toStringAtores = toStringAtores + "\n" + ator.toString();
            }
        }
        return toString + toStringAtores;
    }

}
