package com.example.mywebapp.usecases;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import com.example.mywebapp.persistence.StudentaiDAO;
import com.example.mywebapp.persistence.GrupesDAO;
import com.example.mywebapp.entities.Studentas;
import com.example.mywebapp.entities.Grupe;

@Model
public class Studentai implements Serializable {
    @Inject
    private GrupesDAO grupesDAO;

    @Inject
    private StudentaiDAO studentaiDAO;

    @Getter
    @Setter
    private Grupe grupe;

    @Getter
    @Setter
    private Studentas studentas = new Studentas();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer grupeId = Integer.parseInt(requestParameters.get("grupeId"));
        this.grupe = grupesDAO.findOne(grupeId);
    }

    @Transactional
    public void createStudentas() {
        if (!studentaiDAO.existsByNameAndLastName(studentas.getVardas(), studentas.getPavarde())) {
            studentas.setGrupe(this.grupe);
            studentaiDAO.persist(studentas);
        }
    }
}
