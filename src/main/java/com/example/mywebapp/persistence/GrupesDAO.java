package com.example.mywebapp.persistence;

import com.example.mywebapp.entities.Grupe;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class GrupesDAO {
    @Inject EntityManager em;

    public boolean existsByNameAndCourse(String name, Integer course) {
        TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(g) FROM Grupe g WHERE g.specialybe = :name AND g.kursas = :course", Long.class);
        query.setParameter("name", name);
        query.setParameter("course", course);
        return query.getSingleResult() > 0;
    }

    public List<Grupe> loadAll() {
        return em.createNamedQuery("Grupe.findAll", Grupe.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Grupe grupe) {
        this.em.persist(grupe);
    }

    public Grupe findOne(Integer id) {
        return em.find(Grupe.class, id);
    }
}
