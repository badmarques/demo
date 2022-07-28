package ufabc;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Departamento implements Serializable{
    
    @Id
    @GeneratedValue
    private long id;



    private String nome;

    @OneToMany
    private List<Funcionário> funcionarios;

    public Departamento(){
        this.funcionarios = new LinkedList<Funcionário>();
    }

    public Departamento(String nome){
        this();
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void adicionarFuncionário(Funcionário f){
        
        if(! funcionarios.contains(f)){
            funcionarios.add(f);
        }
    }

    public void imprimeFuncionários(){
        for (Funcionário f : funcionarios) {
            System.out.println(f.getId() + " " + f.getNome() + " " + f.getSobrenome());
        }
    }

}
