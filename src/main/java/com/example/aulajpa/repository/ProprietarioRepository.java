package com.example.aulajpa.repository;

import com.example.aulajpa.connection.ConnectionFactory;
import com.example.aulajpa.domain.entities.Proprietario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class ProprietarioRepository {

    private final EntityManager entityManager;

    public ProprietarioRepository(){
        this.entityManager = ConnectionFactory.getConnection();
    }

    public Proprietario findById(Integer id){
        return entityManager.find(Proprietario.class, id);
    }

    public List<Proprietario> findAll(){

        Query query = entityManager.createNativeQuery("select * from proprietario", Proprietario.class);
        List<Proprietario> proprietarios = query.getResultList();

        return proprietarios;
    }

    /*
    public Proprietario findByEmail(String email) throws NoResultException {
        return  entityManager.createQuery("SELECT p FROM Proprietario p WHERE p.email = :email", Proprietario.class)
                    .setParameter("email", email)
                    .getSingleResult();
    }*/

    public void create(Proprietario proprietario){
        entityManager.getTransaction().begin();
        entityManager.persist(proprietario);
        entityManager.getTransaction().commit();
    }

    public void remove(Proprietario pessoa){
        entityManager.getTransaction().begin();
        entityManager.remove(pessoa);
        entityManager.getTransaction().commit();
    }

    public void update(Proprietario pessoa){
        entityManager.getTransaction().begin();

        pessoa = entityManager.merge(pessoa);

        entityManager.persist(pessoa);
        entityManager.getTransaction().commit();
    }

}
