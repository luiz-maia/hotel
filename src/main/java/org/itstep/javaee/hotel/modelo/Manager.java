/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itstep.javaee.hotel.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author Student
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Manager.all", query = "SELECT e FROM Empregado e")
})
@Table(name = "empregado")
public class Manager implements Serializable {

    private static final long serialVersionUID = 3508262578732194039L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    @NotNull(message = "Nome não pode ser vazio")
    @Size(min = 1, max = 100, message = "Nome deve conter entre 1 a 100 caracteres")
    @Pattern(regexp = "[^0-9]*", message = "Nome não deve conter numeros")
    private String nome;

    @Column(name = "telefone")
    @Size(min = 1, max = 12, message = "Telefone deve conter entre 1 a 12 caracteres")
    @Pattern(regexp = "[0-9]*", message = "Telefone deve conter apenas numeros")
    private String telefone;

    @Column(name = "endereco")
    @NotNull(message = "Endereço não pode ser vazio")
    @Size(min = 1, max = 200, message = "Endereco deve conter entre 1 a 200 caracteres")
    private String endereco;

    @Column(name = "cargo")
    @NotNull(message = "Cargo não pode ser vazio")
    private EmployeeRole cargo;

    //Constructors
    public Manager() {
    }

    public Manager(Integer id, String nome, String telefone, String endereco) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cargo = EmployeeRole.MANAGER;
    }

    //Getters & Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public EmployeeRole getCargo() {
        return cargo;
    }

    public void setCargo(EmployeeRole cargo) {
        this.cargo = cargo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Manager other = (Manager) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Manager{" + "nome=" + nome + ", id=" + id + ", telefone=" + telefone + ", endereco=" + endereco + '}';
    }
}
