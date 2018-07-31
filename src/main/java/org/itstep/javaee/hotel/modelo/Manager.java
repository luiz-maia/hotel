/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itstep.javaee.hotel.modelo;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Student
 */
@Named(value = "manager")
@RequestScoped
public class Manager {

    private String nome;
    private Integer id;
    private String telefone;
    private String endereco;
    
    //Constructors
    public Manager() {
    }
    
    public void salvar(){
       
    }

    //Getters & Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    

    @Override
    public String toString() {
        return "Manager{" + "nome=" + nome + ", id=" + id + ", telefone=" + telefone + ", endereco=" + endereco + '}';
    }
    
    
    
}
