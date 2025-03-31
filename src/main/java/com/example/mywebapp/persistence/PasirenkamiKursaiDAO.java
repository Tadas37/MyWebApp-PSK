package com.example.mywebapp.persistence;

import com.example.mywebapp.entities.PasirenkamasKursas;
import com.example.mywebapp.entities.Studentas;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class PasirenkamiKursaiDAO {
    @Inject
    private EntityManager em;

    public List<PasirenkamasKursas> loadAll() {
        return em.createNamedQuery("PasirenkamasKursas.findAll", PasirenkamasKursas.class).getResultList();
    }

    public void persist(PasirenkamasKursas pasirenkamasKursas) {
        this.em.persist(pasirenkamasKursas);
    }

    public PasirenkamasKursas findOne(Integer id) {
        return em.find(PasirenkamasKursas.class, id);
    }
}
