package ufabc;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main 
{
    public static void main( String[] args )
    {

        //Criando um funcionário
        Funcionário funcionario = new Funcionário();
        funcionario.setNome("Bruno");
        funcionario.setSobrenome("Marques");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(funcionario);
        entityManager.getTransaction().commit();
        
        
        //Criando um departamento e adicionando
        Departamento depto = new Departamento("Pesquisa");
        depto.adicionarFuncionário(funcionario);
        
        entityManager.getTransaction().begin();
        entityManager.persist(depto);
        entityManager.getTransaction().commit();


        //carrega deptoPesquisa a partir do banco de dados
        Departamento deptoPesquisa = entityManager.find(Departamento.class, depto.getId());
        System.out.println(deptoPesquisa.getNome());
        deptoPesquisa.imprimeFuncionários();


        entityManager.close();
        entityManagerFactory.close();
    }
}
