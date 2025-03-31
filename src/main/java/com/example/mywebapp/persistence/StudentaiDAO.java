package com.example.mywebapp.persistence;

import com.example.mywebapp.entities.Studentas;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@ApplicationScoped
public class StudentaiDAO {
    @Inject
    private EntityManager em;

    public boolean existsByNameAndLastName(String vardas, String pavarde) {
        TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(s) FROM Studentas s WHERE s.vardas = :vardas AND s.pavarde = :pavarde", Long.class);
        query.setParameter("vardas", vardas);
        query.setParameter("pavarde", pavarde);
        return query.getSingleResult() > 0;
    }

    public void persist(Studentas studentas) {
        this.em.persist(studentas);
    }

    public Studentas findOne(Integer id) {
        return this.em.find(Studentas.class, id);
    }

    public Studentas update(Studentas studentas) {
        return this.em.merge(studentas);
    }
}
