package com.example.aulajpa.repository;

import com.example.aulajpa.connection.ConnectionFactory;
import com.example.aulajpa.domain.entities.Veiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class VeiculoRepository {

    private EntityManager entityManager;
    private EntityTransaction transaction;

    public VeiculoRepository(){
        this.entityManager = ConnectionFactory.getConnection();
        this.transaction = this.entityManager.getTransaction();
    }

    public Veiculo create(Veiculo veiculo){

        transaction.begin();
        entityManager.persist(veiculo);
        transaction.commit();

        return veiculo;
    }

    public Veiculo findById(Long id){

        Veiculo veiculo = entityManager.find(Veiculo.class, id);

        return veiculo;
    }

    public Veiculo update(Veiculo veiculo){

        transaction.begin();

        veiculo = entityManager.merge(veiculo);

        transaction.commit();

        return veiculo;

    }

        public Veiculo remove(Veiculo veiculo){

        if(veiculo == null){
            throw new RuntimeException("Veiculo não pode ser nulo");
        }

        transaction.begin();

        veiculo = entityManager.find(Veiculo.class, veiculo.getCodigo());

        entityManager.remove(veiculo);

        transaction.commit();

        return veiculo;
    }

    public List<Veiculo> findAll(){

        return entityManager.
                createQuery("SELECT v FROM veiculos v", Veiculo.class).
                getResultList();
    }




}
