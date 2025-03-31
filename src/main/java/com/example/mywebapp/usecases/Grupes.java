package com.example.mywebapp.usecases;

import lombok.Getter;
import lombok.Setter;
import com.example.mywebapp.persistence.GrupesDAO;
import com.example.mywebapp.entities.Grupe;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Grupes {

    @Inject
    private GrupesDAO grupesDAO;

    @Getter
    @Setter
    private Grupe grupe = new Grupe();

    @Getter
    private List<Grupe> grupes;

    @PostConstruct
    public void init() {
        loadAllGrupes();
    }

    @Transactional
    public void createGrupe() {
        if (!grupesDAO.existsByNameAndCourse(grupe.getSpecialybe(), grupe.getKursas())) {
            this.grupesDAO.persist(grupe);
        }
    }

    private void loadAllGrupes() {
        this.grupes = grupesDAO.loadAll();
    }
}
