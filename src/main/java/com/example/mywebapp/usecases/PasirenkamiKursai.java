package com.example.mywebapp.usecases;


import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import com.example.mywebapp.persistence.PasirenkamiKursaiDAO;
import com.example.mywebapp.persistence.StudentaiDAO;
import com.example.mywebapp.entities.PasirenkamasKursas;
import com.example.mywebapp.entities.Studentas;

@Model
public class PasirenkamiKursai implements Serializable {
    @Inject
    private PasirenkamiKursaiDAO pasirenkamiKursaiDAO;

    @Inject
    private StudentaiDAO studentaiDAO;

    @Getter @Setter
    private Studentas studentas;

    @Getter @Setter
    private Integer selectedCourseId;

    @Getter @Setter
    private PasirenkamasKursas newCourse = new PasirenkamasKursas();

    @Getter
    private List<PasirenkamasKursas> availableCourses;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer studentId = Integer.parseInt(requestParameters.get("studentasId"));
        this.studentas = studentaiDAO.findOne(studentId);
        loadAvailableCourses();
    }

    private void loadAvailableCourses() {
        availableCourses = pasirenkamiKursaiDAO.loadAll();
    }

    @Transactional
    public void addCourseToStudent() {
        if (selectedCourseId != null) {
            PasirenkamasKursas course = pasirenkamiKursaiDAO.findOne(selectedCourseId);
            if (course != null && !studentas.getPasirenkamiKursai().contains(course)) {
                studentas.getPasirenkamiKursai().add(course); // Add course to student's list
                studentaiDAO.update(studentas); // Persist the updated student
            }
        }
    }

    @Transactional
    public void createCourse() {
        pasirenkamiKursaiDAO.persist(newCourse);
    }
}
