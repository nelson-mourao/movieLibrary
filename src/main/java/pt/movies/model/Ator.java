/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt.movies.model;

import java.time.LocalDate;

/**
 *
 * @author nelson.mourao
 */
public class Ator {
    private String nome;
    private String personagem;
    private String nacionalidade;
    private LocalDate dataNascimento; 

    public Ator(String nome,String personagem){
        this.nome=nome;
        this.personagem =  personagem;
    }
    
    public String getPersonagem() {
        return personagem;
    }

    public void setPersonagem(String personagem) {
        this.personagem = personagem;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String Nome) {
        this.nome = Nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Ator{" + "nome=" + nome + ", personagem=" + personagem + ", nacionalidade=" + nacionalidade + ", dataNascimento=" + dataNascimento + '}';
    }
    
    
    
}
